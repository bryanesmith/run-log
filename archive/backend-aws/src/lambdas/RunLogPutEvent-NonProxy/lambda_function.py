import boto3
import os
from decimal import Decimal
import collections

def lambda_handler(event, context):

    dynamodb = boto3.resource('dynamodb')
    table = dynamodb.Table(os.environ['DB_TABLE_NAME'])
    events = event['events']

    print("Total number of events: {}".format(len(events)))

    for run_event in events:

        # DynamoDB doesn't support Python floats: https://github.com/boto/boto3/issues/534#issuecomment-191960592
        run_event = replace_floats(run_event)

        key = run_event['@id']

        # Check before adding; cannot have two events with same ID
        item = get_item(table, key)
        if item != None:
            print('Item already exists: {}'.format(key))
        else:
            print('Adding item: {}'.format(key))
            table.put_item(
                Item=run_event
            )


def get_item(table, idVal):
    result = table.get_item(
        Key={
            '@id': idVal
        }
    )
    if 'Item' in result:
        return result['Item']
    else:
        return None

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
