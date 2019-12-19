import boto3
import collections
from decimal import Decimal
import json
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

    # TODO: sort by @id (but numerically, not alphabetically)
    sortedItems = sorted(items["Items"], key=lambda e: e['date'], reverse=True)

    # json.dumps doesn't support Decimal, so convert to floats
    payload = list(map(replace_decimals, sortedItems))

    respBody = {
        'statusCode': 200,
        'headers': {
            'Content-Type': 'application/json'
        },
        'body': json.dumps({'events': payload})
    }

    return addCORS(event, respBody)

def addCORS(event, respBody):
    try:
        origin = event['headers']['origin']
        print('Found origin: {}'.format(origin))
        if origin in getAllowedOrigins():
            print('Origin is whitelisted for CORS')
            respBody['headers']['Access-Control-Allow-Origin'] = origin
            respBody['headers']['Access-Control-Allow-Credentials'] = 'true'
    except KeyError:
        print('No origin found, ignoring')

    return respBody

def getAllowedOrigins():
    if 'CORS_ALLOWED_ORIGINS' in os.environ:
        return os.environ['CORS_ALLOWED_ORIGINS'].split(',')
    else:
        return []

def replace_decimals(dict):
    """Recursively replaces all decimals with floats"""
    clone = {}
    for key, value in dict.items():
        if isinstance(value, collections.Mapping):
            clone[key] = replace_decimals(value)
        elif isinstance(value, Decimal):
            clone[key] = float(dict[key])
        else:
            clone[key] = value
    return clone
