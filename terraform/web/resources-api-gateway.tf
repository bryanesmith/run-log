# API Gateway
# - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
resource "aws_api_gateway_rest_api" "run-log-api-gateway" {
  name        = "RunLogAPIGateway"
  description = "run-log web API"

  body        = data.template_file.run-log-swagger.rendered
  tags = var.common_tags
}

data "template_file" "run-log-swagger" {
  template = "${file("swagger.yaml")}"

  vars = {
    get_events_lambda_arn     = aws_lambda_function.run-log-get-events-lambda.invoke_arn
    put_events_lambda_arn    = aws_lambda_function.run-log-put-events-lambda.invoke_arn
    delete_events_lambda_arn  = aws_lambda_function.run-log-delete-events-lambda.invoke_arn
    lambda_role_arn           = aws_iam_role.run-log-authorizer-role.arn
    authorizer_arn            = aws_lambda_function.token-authorizer.invoke_arn
  }
}

# Deployments
# - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
resource "aws_api_gateway_deployment" "run-log-api-gateway-deployment" {
  rest_api_id = aws_api_gateway_rest_api.run-log-api-gateway.id
  stage_name  = var.environment
}


# Permissions
# - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
resource "aws_lambda_permission" "run-log-api-gateway-invoke-get-lambda" {
  statement_id  = "RunLogAPIGatewayInvokeGetLambda"
  action        = "lambda:InvokeFunction"
  function_name = aws_lambda_function.run-log-get-events-lambda.arn
  principal     = "apigateway.amazonaws.com"

  source_arn = "${aws_api_gateway_deployment.run-log-api-gateway-deployment.execution_arn}/*/*/*"
}

resource "aws_lambda_permission" "run-log-api-gateway-invoke-put-lambda" {
  statement_id  = "RunLogAPIGatewayInvokePutLambda"
  action        = "lambda:InvokeFunction"
  function_name = aws_lambda_function.run-log-put-events-lambda.arn
  principal     = "apigateway.amazonaws.com"

  source_arn = "${aws_api_gateway_deployment.run-log-api-gateway-deployment.execution_arn}/*/*/*"
}

resource "aws_lambda_permission" "run-log-api-gateway-invoke-delete-lambda" {
  statement_id  = "RunLogAPIGatewayInvokeDeleteLambda"
  action        = "lambda:InvokeFunction"
  function_name = aws_lambda_function.run-log-delete-events-lambda.arn
  principal     = "apigateway.amazonaws.com"

  source_arn = "${aws_api_gateway_deployment.run-log-api-gateway-deployment.execution_arn}/*/*/*"
}

# Settings
# - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
resource "aws_api_gateway_method_settings" "run-log-api-gateway-deployment-settings" {
  rest_api_id = aws_api_gateway_rest_api.run-log-api-gateway.id
  stage_name  = var.environment
  method_path = "*/*/*"

  settings {
    data_trace_enabled = true
    logging_level   = "INFO"
  }
}
