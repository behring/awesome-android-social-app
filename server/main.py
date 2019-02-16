import json
from flask import Flask
from flask import request

app = Flask(__name__)


@app.route('/login', methods=['POST'])
def login():
    account_name = request.form.get('account_name')
    password = request.form.get('password')
    response = {}
    if account_name == 'behring' and password == '111111':
        response['code'] = 0
        response['message'] = 'login success'
        response['data'] = {'token': '123132r24er2dsfdsf'}
    else:
        response['code'] = -1
        response['message'] = 'account name or password error'
    return json.dumps(response, ensure_ascii=False)


if __name__ == "__main__":
    app.run(debug=True)
