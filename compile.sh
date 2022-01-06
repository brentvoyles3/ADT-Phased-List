#!/usr/bin/bash
javac -d bin -cp phase1.jar src/cs1302/p2/BaseStringList.java
javac -d bin -cp bin:phase1.jar src/cs1302/p2/ArrayStringList.java
javac -d bin -cp bin:phase1.jar src/cs1302/p2/LinkedStringList.java
javac -d bin -cp bin:phase1.jar src/cs1302/p2/Driver.java
java -cp bin cs1302/p2/Driver
