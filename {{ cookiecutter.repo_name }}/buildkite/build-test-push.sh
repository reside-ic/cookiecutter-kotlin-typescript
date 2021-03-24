#!/usr/bin/env bash
set -eEuo pipefail

HERE="$(dirname "${BASH_SOURCE[0]}")"

if [ "${BUILDKITE:-}" ]; then
  GIT_COMMIT=${BUILDKITE_COMMIT:0:7}
  GIT_BRANCH=$BUILDKITE_BRANCH
else
  GIT_COMMIT=$(git rev-parse --short=7 HEAD)
  GIT_BRANCH=$(git symbolic-ref --short HEAD)
fi

# Deal with dependabot tags incompatible with Docker e.g. `dependabot/npm_and_yarn/app/lodash-4.17.19`
GIT_BRANCH=${GIT_BRANCH//\//-}

IMAGE_NAME={{ cookiecutter.docker_image }}

docker build \
  --build-arg GIT_BRANCH --build-arg GIT_COMMIT --build-arg CI \
  --tag "$IMAGE_NAME:$GIT_BRANCH" --tag "$IMAGE_NAME:$GIT_COMMIT" \
  "$HERE"/../src/

if [ "${BUILDKITE:-}" ]; then
  docker push "$IMAGE_NAME:$GIT_BRANCH"
  docker push "$IMAGE_NAME:$GIT_COMMIT"
fi
