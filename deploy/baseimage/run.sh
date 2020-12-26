#! /usr/bin/env bash
set -o errexit
set -o nounset
set -o pipefail

APP_JAR=$(find . -name '*.jar' -type f)

exec java ${JAVA_OPTS} -jar ${APP_JAR}
