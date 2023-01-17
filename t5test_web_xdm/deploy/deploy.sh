#!/usr/bin/env bash

sudo chmod 775 -R /home/centos

STDOUT=/home/centos/stdout.log
STDERR=/home/centos/stderr.log
DIR=/home/centos/deploy.jar
sudo fuser -k 8081/tcp
sudo sleep 20s # Waits  seconds.
sudo nohup java -jar $DIR 1>>$STDOUT 2>> $STDERR &
sudo sleep 60s

exit 0