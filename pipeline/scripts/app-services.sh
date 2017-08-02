#!/bin/bash

set -xe

# Login to PCF
cf api $CF_API --skip-ssl-validation

# Don't echo password
set +x
echo "Logging in to PCF as $CF_USER (org: $CF_ORG, space: $CF_SPACE)"
cf login -u $CF_USER -p $CF_PWD -o "$CF_ORG" -s "$CF_SPACE"
set -x

#cf apps

set +e
# Current app colour:
APP_NAME=$CF_APP-$(cat ./app-colour/current-app.txt)

# Get list of services
SERVICES=$(echo $(cf services | grep $APP_NAME | awk '{print $1}')|sed 's/ /, /g')

# Save services
echo $SERVICES > ./app-services/services.txt