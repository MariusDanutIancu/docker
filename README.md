# Intro
This repository contains a basic spring boot application that can be run in a docker container.

# Tutorial

## Steps

Run the following commands to set up the container:

* mvnw clean install
* docker build --file=Dockerfile --tag=spring-docker:latest --rm=true .
* docker volume create --name=spring-docker-demo
* docker run -d --name=spring-docker-demo-1 --publish=8090:8080 --volume=spring-docker-demo spring-docker:latest
* docker run -ti --entrypoint /bin/sh spring-docker:latest
* docker stop spring-docker-demo-1
* docker rm spring-docker-demo-1

Access the api at localhost:8090