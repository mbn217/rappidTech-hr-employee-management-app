#!/bin/sh
echo "Waiting for the database to be ready..."
sleep 60
echo "Starting the application..."
java -jar *.jar
