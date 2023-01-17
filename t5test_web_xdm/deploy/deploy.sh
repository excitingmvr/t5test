#!/usr/bin/env bash

STDOUT=/home/centos/stdout.log
STDERR=/home/centos/stderr.log

sudo fuser -k 8081/tcp
sudo nohup java -jar 1>>$STDOUT 2>> $STDERR &
