import lambda_utils
import os

def lambda_handler(event, context):

    table = lambda_utils.get_dynamodb_table(os.environ['DB_TABLE_NAME'])
    events = lambda_utils.parse_run_events(event)

    print("Total number of events to delete: {}".format(len(events)))

    for run_event in events:
        table.delete_item(
            Key={
                '@id': run_event['@id']
            }
        )

    respBody = {
        'statusCode': 200,
        'headers': {}
    }

    return lambda_utils.addCORS(event, respBody)
