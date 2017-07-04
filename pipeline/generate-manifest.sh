#!/bin/sh

set -xe
cp git-assets/manifest.yml manifest-output/manifest.yml
echo '  path: '$APP_PACKAGE >> ./manifest-output/manifest.yml
cat ./manifest-output/manifest.yml
ls
