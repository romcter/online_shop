#!/bin/sh

# generate jar file for each service

cd ./parent-service/ && mvn clean install && cd ../
cd ./dto-service/ && mvn clean install && cd ../
cd ./media-service/ && mvn clean install && cd ../
cd ./order-service/ && mvn clean install && cd ../
cd ./product-service/ && mvn clean install && cd ../
cd ./user-service/ && mvn clean install && cd ../

# run all jar services in docker

docker compose up