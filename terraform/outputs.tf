output "dynamodb-table-arn" {
  value = aws_dynamodb_table.run-log-dynamodb-table.arn
}

output "get-events-lambda-arn" {
  value = aws_lambda_function.run-log-get-events-lambda.arn
}
