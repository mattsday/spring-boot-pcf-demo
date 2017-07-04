#!/bin/bash

set -xe

# Login to PCF
cf api $CF_API --skip-ssl-validation
cf login -u $CF_USER -p $CF_PWD -o "$CF_ORG" -s "$CF_SPACE"
cf apps

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


