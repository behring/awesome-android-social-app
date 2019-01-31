import json
from flask import Flask
from flask import request

app = Flask(__name__)


@app.route('/login', methods=['POST'])
def login() -> 'json':
    username = request.form.get('uname')
    password = request.form.get('pwd')
    response = {}
    if username == 'behring' and password == '111111':
        response['code'] = 0
        response['message'] = 'login success'
        response['data'] = {'token': '123132r24er2dsfdsf'}
    else:
        response['code'] = -1
        response['message'] = 'username or password error'
    return json.dumps(response, ensure_ascii=False)


if __name__ == "__main__":
    app.run(debug=True)
