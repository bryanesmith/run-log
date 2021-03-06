import boto3
import os

def lambda_handler(event, context):

    dynamodb = boto3.resource('dynamodb')
    table = dynamodb.Table(os.environ['DB_TABLE_NAME'])
    items = table.scan()

    return sorted(items["Items"], key=lambda e: e['date'], reverse=True)
