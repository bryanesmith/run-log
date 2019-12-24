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
    get_events_lambda_arn = "${aws_lambda_function.run-log-get-events-lambda.invoke_arn}"
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

  source_arn = "${aws_api_gateway_deployment.run-log-api-gateway-deployment.execution_arn}/*/*"
}
