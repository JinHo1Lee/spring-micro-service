#!/bin/sh
DOCKER_REGISTRY_URL="172.16.3.4:5000"
SERVICE_NAME="eureka-server"
VERSION="0.0.1"

docker build . -t ${SERVICE_NAME}
docker tag ${SERVICE_NAME} ${DOCKER_REGISTRY_URL}/jino/${SERVICE_NAME}:${VERSION}
docker push ${DOCKER_REGISTRY_URL}/jino/${SERVICE_NAME}:${VERSION}