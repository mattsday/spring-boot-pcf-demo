#!/bin/sh

set -xe
cp git-assets/manifest.yml manifest-output/manifest.yml
echo '  path: '$APP_PACKAGE/demo-0.0.1-SNAPSHOT.jar >> ./manifest-output/manifest.yml
cat ./manifest-output/manifest.yml
ls ..
