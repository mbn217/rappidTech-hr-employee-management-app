# Description: Dockerfile for Spring Boot Application
FROM openjdk:8-jdk-alpine
# Add Maintainer Info
LABEL authors="MohamedNheri"
# Path to jar file
ARG JAR_FILE=target/*.jar
# Add the application's jar to the container
COPY ${JAR_FILE} app.jar
# Run the jar file
ENTRYPOINT ["java","-jar","/app.jar"]


