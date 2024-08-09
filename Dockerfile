# Add Maintainer Info
LABEL authors="MohamedNheri"
# Use Maven to build the application
FROM maven:3.8.4-openjdk-11 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests
# Use a lightweight JDK image to run the application
FROM openjdk:11-jre-slim
WORKDIR /app
COPY --from=build /app/target/employee-management.jar employee-management.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "employee-management.jar"]

