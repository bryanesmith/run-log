output "dynamodb-table-arn" {
  value = aws_dynamodb_table.run-log-dynamodb-table.arn
}

output "token-authorizer-lambda-arn" {
  value = aws_lambda_function.token-authorizer.arn
}

output "get-events-lambda-arn" {
  value = aws_lambda_function.run-log-get-events-lambda.arn
}

output "post-events-lambda-arn" {
  value = aws_lambda_function.run-log-post-events-lambda.arn
}

output "api-gateway-url" {
  value = aws_api_gateway_deployment.run-log-api-gateway-deployment.invoke_url
}

output "distribution-arn" {
  value = aws_cloudfront_distribution.run-log-distribution.arn
}

output "distribution-url" {
  value = aws_cloudfront_distribution.run-log-distribution.domain_name
}
