import boto3
import json
import lambda_utils
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

    return lambda_utils.addCORS(event, respBody)

def add_run_event(table, run_event):

    key = '@id'

    # DynamoDB doesn't support Python floats: https://github.com/boto/boto3/issues/534#issuecomment-191960592
    run_event = lambda_utils.replace_floats(run_event)

    id = run_event[key]

    # Check before adding; cannot have two events with same ID
    item = lambda_utils.find_item_by_key(table, key, id)

    if item != None:
        print('Item already exists: {}'.format(id))
    else:
        print('Adding item: {}'.format(id))
        table.put_item(Item=run_event)
