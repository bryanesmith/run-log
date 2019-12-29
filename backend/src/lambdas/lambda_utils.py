import collections
from decimal import Decimal
import os

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
