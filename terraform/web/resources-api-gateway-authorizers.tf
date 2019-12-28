# Roles
# - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
resource "aws_iam_role" "run-log-authorizer-role" {
  name = "RunLogAuthorizerRole"
  path = "/"
  tags = var.common_tags

  assume_role_policy = <<EOF
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Action": "sts:AssumeRole",
      "Principal": {
        "Service": "apigateway.amazonaws.com"
      },
      "Effect": "Allow",
      "Sid": ""
    }
  ]
}
EOF
}

# Policy
# - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
resource "aws_iam_role_policy" "run-log-authorizer-lambda-policy" {
  name = "RunLogAuthorizerLambdaPolicy"
  role = aws_iam_role.run-log-authorizer-role.id

  policy = <<EOF
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Action": "lambda:InvokeFunction",
      "Effect": "Allow",
      "Resource": [
        "${aws_lambda_function.token-authorizer.arn}"
      ]
    }
  ]
}
EOF
}
