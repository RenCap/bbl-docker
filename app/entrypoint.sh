#!/bin/sh
set -xe
: "${API_URL?Need an api url}"

sed -i "s#API_URL#$API_URL#g" /usr/share/nginx/html/main*.js

exec "$@"
