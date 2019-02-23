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

@app.route('/chat_items', methods=['GET'])
def get_chat_items():
    response = {'code': 0, 'message': 'get chat items success'}
    data = []
    for number in range(10):
        chat_item = {'avatar_url': 'http://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000' \
                                   '&sec=1550774291648&di=d021d4fec92c4af2474b8bd79af89ea4&imgtype=' \
                                   '0&src=http%3A%2F%2Ftupian.qqjay.com%2Ftou3%2F2015%2F1030%2F64d84' \
                                   '30af77d66c80254092965e98398.jpg',
                     'name': 'zhaolin' + str(number),
                     'time': '2016-11-01 16:28:30',
                     'new_message': 'I love RJJ',
                     'new_message_count': 10}
        data.append(chat_item)
    response['data'] = data
    return json.dumps(response, ensure_ascii=False)

if __name__ == "__main__":
    app.run(debug=True)
