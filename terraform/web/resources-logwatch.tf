#
# TODO: Finish setting up logwatch
# https://www.orangecollarmedia.com/amazon-api-gateway-integration-with-sqs-using-terraform/
#

# TODO: how to lock down logwatch access to specific API Gateway instance?

# Roles
# - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
resource "aws_iam_role" "run-log-api-gateway-role" {
  name = "RunLogAPIGatewayRole"
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

# Policies
# - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
resource "aws_iam_role_policy" "run-log-api-gateway-cloudwatch-policy"{
  name = "RunLogAPIGatewayCloudWatchPolicy"
  role = aws_iam_role.run-log-api-gateway-role.id
  policy = <<EOF
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": [
                "logs:CreateLogGroup",
                "logs:CreateLogStream",
                "logs:DescribeLogGroups",
                "logs:DescribeLogStreams",
                "logs:PutLogEvents",
                "logs:GetLogEvents",
                "logs:FilterLogEvents"
            ],
            "Resource": "*"
        }
    ]
}
EOF
}
