import lambda_utils
import os

def lambda_handler(event, context):

    table = lambda_utils.get_dynamodb_table(os.environ['DB_TABLE_NAME'])
    events = lambda_utils.parse_run_events(event)

    print("Total number of events to create: {}".format(len(events)))

    for run_event in events:

        # DynamoDB doesn't support Python floats: https://github.com/boto/boto3/issues/534#issuecomment-191960592
        run_event = lambda_utils.replace_floats(run_event)

        table.put_item(Item=run_event)

    respBody = {
        'statusCode': 200,
        'headers': {}
    }

    return lambda_utils.addCORS(event, respBody)
