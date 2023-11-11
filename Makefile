# Squirrel Hunters Makefile
#
# @file
# @version 0.1

MVN=mvn

.PHONY: all build run test clean

all: build

build:
	cd ./SquirrelHunters && $(MVN) clean compile package

run:
	run:
	cd ./SquirrelHunters/SquirrelHunters && mvn clean compile package && cd ./target && java -jar SquirrelHunters-1.0-SNAPSHOT.jar


test:
	cd ./SquirrelHunters && $(MVN) clean test

clean:
	cd ./SquirrelHunters && $(MVN) clean
