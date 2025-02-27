# Squirrel Hunters Makefile
#
# @file
# @version 0.1

CC=mvn

all: build

build:
	cd ./MVN_PJ/phase2-module && $(CC) clean compile package

run:
	cd ./MVN_PJ/phase2-module && java -jar target/phase2-module-1.0-SNAPSHOT.jar

test:
	cd ./MVN_PJ/phase2-module && $(CC) clean test
