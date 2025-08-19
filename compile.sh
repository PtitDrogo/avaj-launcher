#!/bin/bash
# javac -d build -g ./src/*.java

#Uncomment below before pushing to 42 - subject command
find * -name "*.java" > sources.txt
javac -d build @sources.txt


echo "Compilation complete - Now running programm\n"

java -cp build avajlauncher.Main "$@"