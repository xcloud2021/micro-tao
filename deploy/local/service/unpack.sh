#! /usr/bin/env bash

# 解压　images.tgz　中的镜像文件到本机
set -o errexit
set -o nounset
set -o pipefail

docker load -i images.tgz
