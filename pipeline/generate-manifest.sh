#!/bin/sh

set -xe
cp ./git-assets/pipeline/manifest.yml ./manifest-output/manifest.yml
sed -i "s%APPNAME%$CF_APP-$(cat ./app-colour/next-deployment.txt)%" ./manifest-output/manifest.yml
sed -i "s%APPPATH%$APP_PACKAGE%" ./manifest-output/manifest.yml
cat ./manifest-output/manifest.yml
ls