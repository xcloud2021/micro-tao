#! /usr/bin/env bash
set -o errexit
set -o nounset
set -o pipefail

IMAGE='harbor.beautytiger.com/docker.io/microservice-java:base'

docker build -t ${IMAGE} .
docker push ${IMAGE}
