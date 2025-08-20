#!/bin/bash
find * -name "*.java" > sources.txt
javac -d build @sources.txt


echo "Compilation complete - Now running programm\n"
java -cp build avajlauncher.Main "$@"