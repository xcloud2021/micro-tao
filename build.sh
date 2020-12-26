#! /usr/bin/env bash
set -o errexit
set -o nounset
set -o pipefail

LOCATION='microservice-01-base'
pushd ${LOCATION}
mvn clean package
popd

LOCATION='microservice-03-product-provider/target/'
IMAGE='harbor.beautytiger.com/docker.io/microservice-product:1.0.0'
cp Dockerfile ${LOCATION}
pushd ${LOCATION}
docker build -t ${IMAGE} .
popd

LOCATION='microservice-04-product-consumer/target/'
IMAGE='harbor.beautytiger.com/docker.io/microservice-product-consumer:1.0.0'
cp Dockerfile ${LOCATION}
pushd ${LOCATION}
docker build -t ${IMAGE} .
popd

LOCATION='microservice-05-eureka/target/'
IMAGE='harbor.beautytiger.com/docker.io/microservice-eureka:1.0.0'
cp Dockerfile ${LOCATION}
pushd ${LOCATION}
docker build -t ${IMAGE} .
popd

LOCATION='microservice-06-hystrix-dashboard/target/'
IMAGE='harbor.beautytiger.com/docker.io/microservice-hystrix-dashboard:1.0.0'
cp Dockerfile ${LOCATION}
pushd ${LOCATION}
docker build -t ${IMAGE} .
popd

LOCATION='microservice-07-zuul-gateway/target/'
IMAGE='harbor.beautytiger.com/docker.io/microservice-zuul:1.0.0'
cp Dockerfile ${LOCATION}
pushd ${LOCATION}
docker build -t ${IMAGE} .
popd

LOCATION='microservice-08-config-server/target/'
IMAGE='harbor.beautytiger.com/docker.io/microservice-config:1.0.0'
cp Dockerfile ${LOCATION}
pushd ${LOCATION}
docker build -t ${IMAGE} .
popd

LOCATION='microservice-09-user/target/'
IMAGE='harbor.beautytiger.com/docker.io/microservice-user:1.0.0'
cp Dockerfile ${LOCATION}
pushd ${LOCATION}
docker build -t ${IMAGE} .
popd

LOCATION='microservice-10-cart/target/'
IMAGE='harbor.beautytiger.com/docker.io/microservice-cart:1.0.0'
cp Dockerfile ${LOCATION}
pushd ${LOCATION}
docker build -t ${IMAGE} .
popd

LOCATION='microservice-11-order/target/'
IMAGE='harbor.beautytiger.com/docker.io/microservice-order:1.0.0'
cp Dockerfile ${LOCATION}
pushd ${LOCATION}
docker build -t ${IMAGE} .
popd
