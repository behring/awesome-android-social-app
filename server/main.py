import json
from flask import Flask

app = Flask(__name__)

@app.route('/login', methods = ['POST'])
def login() -> 'json':
	username = request.form.get('username')
	password = request.form.get('password')
	response = {}
	if username == 'zhaolin' and password == '111111':
		response['code'] = 0
		response['message'] = 'login success'
	else:
		response['code'] = -1
		response['message'] = 'username or password error'
	return json.dumps(response, ensure_ascii = False)

if __name__ == "__main__":
    app.run(debug = True)