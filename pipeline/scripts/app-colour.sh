#!/bin/bash

set -xe

# Login to PCF
cf api $CF_API --skip-ssl-validation
cf login -u $CF_USER -p $CF_PWD -o "$CF_ORG" -s "$CF_SPACE"
cf apps

set +e

export CURR_APP_COLOR=$(cf apps | grep "$CF_APP.$CF_APP_DOMAIN" | awk '{print $1}')
if [[ $CURR_APP_COLOR =~ .*green.* ]]; then
  echo "green" > ./app-colour/current-app.txt
  echo "blue" > ./app-colour/next-deployment.txt
else
  echo "blue" > ./app-colour/current-app.txt
  echo "green" > ./app-colour/next-deployment.txt
fi

set -xe

echo "Current app is: $(cat ./app-colour/current-app.txt)"
echo "New version of app will be: $(cat ./app-colour/next-deployment.txt)"