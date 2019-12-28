import base64
import os

def lambda_handler(event, context):

    authorization = parseBasicAuthorizationToken(getAuthorizationToken(event))

    user = 'unknown'
    try:
        str = base64.b64decode(authorization)
        user = str.decode("utf-8").split(':')[0]
    except Exception as e:
        pass

    if authorization in getValidAuthorizedTokens():
        return generate_policy(user, 'Allow', event['methodArn'])
    else:
        return generate_policy(user, 'Deny', event['methodArn'])

def getAuthorizationToken(event):
    if 'authorizationToken' in event:
        return event['authorizationToken']
    else:
        raise Exception('Unauthorized')

def parseBasicAuthorizationToken(token):
    if token.startswith('Basic '):
        return token[6:].strip()
    else:
        raise Exception('Unauthorized')

def getValidAuthorizedTokens():
    if 'AUTHORIZED_TOKENS' in os.environ:
        return os.environ['AUTHORIZED_TOKENS'].split(',')
    else:
        return []


def generate_policy(principalId, effect, resource):
    return {
        'principalId': principalId,
        'policyDocument': {
            'Version': '2012-10-17',
            'Statement': [
                {
                    'Action': 'execute-api:Invoke',
                    'Effect': effect,
                    'Resource': resource
                }
            ]
        }
    }
