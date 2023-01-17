#!/usr/bin/env bash

sudo chmod 775 -R /home/centos

STDOUT=/home/centos/stdout.log
STDERR=/home/centos/stderr.log

sudo fuser -k 8081/tcp
sudo sleep 20s # Waits  seconds.
sudo nohup java -jar 1>>$STDOUT 2>> $STDERR &
sudo sleep 60s

exit 1