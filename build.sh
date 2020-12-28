#! /usr/bin/env bash
set -o errexit
set -o nounset
set -o pipefail

LOCATION='microservice-01-base'
pushd ${LOCATION}
mvn clean package
popd

VERSION='1.0.0'
PUSH_IMAGE=${1:-"false"}


LOCATION='microservice-03-product-provider/target/'
IMAGE="docker.io/konmyn/microservice:product-${VERSION}"
cp Dockerfile ${LOCATION}
pushd ${LOCATION}
docker build -t ${IMAGE} .
if [[ "${PUSH_IMAGE}" != "false" ]]; then
    docker push ${IMAGE}
fi
popd

LOCATION='microservice-04-product-consumer/target/'
IMAGE="docker.io/konmyn/microservice:product-consumer-${VERSION}"
cp Dockerfile ${LOCATION}
pushd ${LOCATION}
docker build -t ${IMAGE} .
if [[ "${PUSH_IMAGE}" != "false" ]]; then
    docker push ${IMAGE}
fi
popd

LOCATION='microservice-05-eureka/target/'
IMAGE="docker.io/konmyn/microservice:eureka-${VERSION}"
cp Dockerfile ${LOCATION}
pushd ${LOCATION}
docker build -t ${IMAGE} .
if [[ "${PUSH_IMAGE}" != "false" ]]; then
    docker push ${IMAGE}
fi
popd

LOCATION='microservice-06-hystrix-dashboard/target/'
IMAGE="docker.io/konmyn/microservice:hystrix-dashboard-${VERSION}"
cp Dockerfile ${LOCATION}
pushd ${LOCATION}
docker build -t ${IMAGE} .
if [[ "${PUSH_IMAGE}" != "false" ]]; then
    docker push ${IMAGE}
fi
popd

LOCATION='microservice-07-zuul-gateway/target/'
IMAGE="docker.io/konmyn/microservice:zuul-${VERSION}"
cp Dockerfile ${LOCATION}
pushd ${LOCATION}
docker build -t ${IMAGE} .
if [[ "${PUSH_IMAGE}" != "false" ]]; then
    docker push ${IMAGE}
fi
popd

LOCATION='microservice-08-config-server/target/'
IMAGE="docker.io/konmyn/microservice:config-${VERSION}"
cp Dockerfile ${LOCATION}
pushd ${LOCATION}
docker build -t ${IMAGE} .
if [[ "${PUSH_IMAGE}" != "false" ]]; then
    docker push ${IMAGE}
fi
popd

LOCATION='microservice-09-user/target/'
IMAGE="docker.io/konmyn/microservice:user-${VERSION}"
cp Dockerfile ${LOCATION}
pushd ${LOCATION}
docker build -t ${IMAGE} .
if [[ "${PUSH_IMAGE}" != "false" ]]; then
    docker push ${IMAGE}
fi
popd

LOCATION='microservice-10-cart/target/'
IMAGE="docker.io/konmyn/microservice:cart-${VERSION}"
cp Dockerfile ${LOCATION}
pushd ${LOCATION}
docker build -t ${IMAGE} .
if [[ "${PUSH_IMAGE}" != "false" ]]; then
    docker push ${IMAGE}
fi
popd

LOCATION='microservice-11-order/target/'
IMAGE="docker.io/konmyn/microservice:order-${VERSION}"
cp Dockerfile ${LOCATION}
pushd ${LOCATION}
docker build -t ${IMAGE} .
if [[ "${PUSH_IMAGE}" != "false" ]]; then
    docker push ${IMAGE}
fi
popd
