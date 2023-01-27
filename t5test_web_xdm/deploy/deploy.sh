#!/usr/bin/env bash

sudo chmod 775 -R /home/centos

STDOUT=/home/centos/deploy/stdout.log
STDERR=/home/centos/deploy/stderr.log
DIR=/home/centos/deploy/deploy.jar

sudo fuser -k 8081/tcp
sudo sleep 20s # Waits  seconds.
sudo nohup java -jar Dserver.port=8081 $DIR 1>>$STDOUT 2>> $STDERR &
sudo sleep 60s

sudo fuser -k 8082/tcp
sudo sleep 20s # Waits  seconds.
sudo nohup java -jar Dserver.port=8082 $DIR 1>>$STDOUT 2>> $STDERR &
sudo sleep 60s

exit 0

