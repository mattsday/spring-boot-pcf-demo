#!/bin/bash

set -xe

# Login to PCF
cf api $CF_API --skip-ssl-validation

# Don't echo password
set +x
echo "Logging in to PCF as $CF_USER (org: $CF_ORG, space: $CF_SPACE)"
cf login -u $CF_USER -p $CF_PWD -o "$CF_ORG" -s "$CF_SPACE"
set -x

cf apps

set +e

cf routes

# Map route to "next" app
export NEXT_APP_COLOR=$(cat ./app-colour/next-deployment.txt)
echo "Mapping main app route to point to $NEXT_APP_COLOR instance"
cf map-route $CF_APP-$NEXT_APP_COLOR $CF_APP_DOMAIN --hostname $CF_APP

if [ $? = 0 ]; then
	# Delete old App
	export OLD_APP_COLOR=$(cat ./app-colour/current-app.txt)
	cf delete $CF_APP-$OLD_APP_COLOR -f
	echo "Apps and Routes updated"
	cf apps
	cf routes
else
	exit 1
fi


