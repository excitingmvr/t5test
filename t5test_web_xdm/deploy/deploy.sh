#!/usr/bin/env bash

STDOUT=/logs/stdout.log
STDERR=/logs/stderr.log

sudo fuser -k 8081/tcp
sudo nohup java -jar 1>>$STDOUT 2>> $STDERR &
