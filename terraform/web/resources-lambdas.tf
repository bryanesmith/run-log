# Roles
# - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
resource "aws_iam_role" "run-log-lambda-role" {
  name = "RunLogLambdaRole"
  tags = var.common_tags
  assume_role_policy = <<EOF
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Action": "sts:AssumeRole",
      "Principal": {
        "Service": "lambda.amazonaws.com"
      },
      "Effect": "Allow",
      "Sid": ""
    }
  ]
}
EOF
}

# Policies
# - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
resource "aws_iam_role_policy" "run-log-lambda-cloudwatch-policy"{
  name = "RunLogLambdaCloudWatchPolicy"
  role = aws_iam_role.run-log-lambda-role.id
  policy = <<EOF
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": [
                "logs:CreateLogGroup",
                "logs:CreateLogStream",
                "logs:PutLogEvents"
            ],
            "Resource": [
                "*"
            ]
        }
    ]
}
EOF
}

resource "aws_iam_role_policy" "run-log-lambda-dynamodb-policy"{
  name = "RunLogLambdaDynamoDBPolicy"
  role = aws_iam_role.run-log-lambda-role.id
  policy = <<EOF
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": [
                "dynamodb:DeleteItem",
                "dynamodb:GetItem",
                "dynamodb:PutItem",
                "dynamodb:Scan",
                "dynamodb:UpdateItem"
            ],
            "Resource": "${aws_dynamodb_table.run-log-dynamodb-table.arn}"
        }
    ]
}
EOF
}

# Lambdas
# - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

# TokenAuthorizer
resource "aws_lambda_function" "token-authorizer" {
  function_name = "TokenAuthorizer"

  handler = "index.lambda_handler"
  memory_size = 128
  role = aws_iam_role.run-log-lambda-role.arn
  runtime = "python3.8"
  s3_bucket = var.s3_bucket_stage
  s3_key = "${var.run_log_version}/TokenAuthorizer.zip"
  tags = var.common_tags

  environment {
    variables = {
      AUTHORIZED_TOKENS=var.authorized_tokens
    }
  }
}

# RunLogGetEvents
resource "aws_lambda_function" "run-log-get-events-lambda" {
  function_name = "RunLogGetEvents"

  handler = "index.lambda_handler"
  memory_size = 128
  role = aws_iam_role.run-log-lambda-role.arn
  runtime = "python3.7"
  s3_bucket = var.s3_bucket_stage
  s3_key = "${var.run_log_version}/RunLogGetEvents.zip"
  tags = var.common_tags

  environment {
    variables = {
      CORS_ALLOWED_ORIGINS=var.cors_allowed_origins
      DB_TABLE_NAME=var.dynamodb_table
    }
  }
}

# RunLogPostEvents
resource "aws_lambda_function" "run-log-post-events-lambda" {
  function_name = "RunLogPostEvents"

  handler = "index.lambda_handler"
  memory_size = 128
  role = aws_iam_role.run-log-lambda-role.arn
  runtime = "python3.7"
  s3_bucket = var.s3_bucket_stage
  s3_key = "${var.run_log_version}/RunLogPostEvents.zip"
  tags = var.common_tags

  environment {
    variables = {
      CORS_ALLOWED_ORIGINS=var.cors_allowed_origins
      DB_TABLE_NAME=var.dynamodb_table
    }
  }
}
