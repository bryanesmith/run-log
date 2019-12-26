import base64
import os

def lambda_handler(event, context):
    user = 'unknown'
    try:
        str = base64.b64decode(event['authorizationToken'])
        user = str.decode("utf-8").split(':')[0]
    except Exception as e:
        pass

    if event['authorizationToken'] in getAuthorizedTokens():
        return generate_policy(user, 'Allow', event['methodArn'])
    else:
        return generate_policy(user, 'Deny', event['methodArn'])


def getAuthorizedTokens():
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
