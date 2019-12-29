from decimal import Decimal
import boto3
import collections
import json
import os

def lambda_handler(event, context):

    dynamodb = boto3.resource('dynamodb')
    table = dynamodb.Table(os.environ['DB_TABLE_NAME'])
    body = json.loads(event['body'])
    events = body['events']

    print("Total number of events: {}".format(len(events)))

    for run_event in events:
        add_run_event(table, run_event)

    respBody = {
        'statusCode': 200,
        'headers': {}
    }

    return addCORS(event, respBody)

#
def add_run_event(table, run_event):

    key = '@id'

    # DynamoDB doesn't support Python floats: https://github.com/boto/boto3/issues/534#issuecomment-191960592
    run_event = replace_floats(run_event)

    id = run_event[key]

    # Check before adding; cannot have two events with same ID
    item = find_item_by_key(table, key, id)

    if item != None:
        print('Item already exists: {}'.format(id))
    else:
        print('Adding item: {}'.format(id))
        table.put_item(Item=run_event)

# TODO: move to shared library
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

# TODO: move to shared library
def getAllowedOrigins():
    if 'CORS_ALLOWED_ORIGINS' in os.environ:
        return os.environ['CORS_ALLOWED_ORIGINS'].split(',')
    else:
        return []

# TODO: move to shared library
def find_item_by_key(table, key, value):
    result = table.get_item(
        Key={
            key: value
        }
    )
    if 'Item' in result:
        return result['Item']
    else:
        return None

# TODO: move to shared library
def replace_floats(dict):
    """Recursively replaces all floats with decimal"""
    clone = {}
    for key, value in dict.items():
        if isinstance(value, collections.Mapping):
            clone[key] = replace_floats(value)
        elif isinstance(value, float):
            clone[key] = Decimal('{}'.format(dict[key]))
        else:
            clone[key] = value
    return clone
