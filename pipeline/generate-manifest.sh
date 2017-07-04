#!/bin/sh

set -xe
sed "s/APPNAME/$CF_APP-$(cat ./app-colour/next-deployment.txt)/" git-assets/pipeline/manifest.yml > ./manifest-output/manifest.yml
echo '  path: '$APP_PACKAGE >> ./manifest-output/manifest.yml
cat ./manifest-output/manifest.yml
ls