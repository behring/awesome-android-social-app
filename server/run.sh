#!/bin/bash

export FLASK_APP=main.py
export FLASK_ENV=development

if [[ ! -z ${ENV} ]] && [[ ${ENV} = "ci" ]]; then
    flask run --host jenkins
else
    flask run --host localhost
fi
