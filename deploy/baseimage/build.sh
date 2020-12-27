#! /usr/bin/env bash
set -o errexit
set -o nounset
set -o pipefail

IMAGE='docker.io/konmyn/microservice:java-base'

docker build -t ${IMAGE} .
docker push ${IMAGE}
