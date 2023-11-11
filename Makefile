# Squirrel Hunters Makefile
#
# @file
# @version 0.1

CC=mvn

all: build

build:
	cd ./SquirrelHunters/phase2-module && $(CC) clean compile package

run:
	cd ./SquirrelHunters/phase2-module/target && java -jar SquirrelHunters-1.0-SNAPSHOT.jar

test:
	cd ./SquirrelHunters/phase2-module && $(CC) clean test

