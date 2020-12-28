#! /usr/bin/env bash

# 打包docker-compose中的镜像文件
set -o errexit
set -o nounset
set -o pipefail

docker save $( fgrep image docker-compose.yaml | awk '{print $2}' ) | gzip -c > images.tgz
