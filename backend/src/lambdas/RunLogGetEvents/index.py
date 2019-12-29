import boto3
import json
import lambda_utils
import os

#
# REQUIRED ENVIRONMENT VARIABLES:
#   - DB_TABLE_NAME: DynamoDB table name for run-log events
#   - CORS_ALLOWED_ORIGINS: comma-separated list of supported domains. E.g., http://foo.com,http://bar.com
#
def lambda_handler(event, context):

    dynamodb = boto3.resource('dynamodb')
    table = dynamodb.Table(os.environ['DB_TABLE_NAME'])
    items = table.scan()

    sortedItems = sorted(items["Items"], key=lambda e: e['date'], reverse=True)

    # json.dumps doesn't support Decimal, so convert to floats
    payload = list(map(lambda_utils.replace_decimals, sortedItems))

    respBody = {
        'statusCode': 200,
        'headers': {
            'Content-Type': 'application/json'
        },
        'body': json.dumps({'events': payload})
    }

    return lambda_utils.addCORS(event, respBody)
