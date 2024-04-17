# Project Title

This is a Spring Boot application developed in Java, using Maven as a build tool. The application is designed to manage employees in an organization for Human Resources.

## Authors
- [mbn217](https://github.com/mbn217)
## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

- Java 8 or higher
- Maven
- IntelliJ IDEA 2024.1 or any other IDE that supports Spring Boot

### Installing

1. Clone the repository
2. Open the project in your IDE
3. Run the main application class to start the application

## Features

- Employee Management: The application provides endpoints to create, read, update, and delete employees.
- Response Time Logging: The application logs the response time for each request.

## Built With

- [Java](https://www.java.com) - The programming language used
- [Spring Boot](https://spring.io/projects/spring-boot) - The framework used
- [Maven](https://maven.apache.org/) - Dependency Management


## Docker

This application can be run using Docker. Here are the steps to do so:

### Prerequisites

- Docker installed on your machine. You can download it [here](https://www.docker.com/products/docker-desktop).

### Building the Docker Image

In the root directory of the project, run the following command to build the Docker image:
##### Build the Docker image for your application. In the root directory of your project, run the following command:
```bash
docker build -t employee-management .
```
This will create a Docker image named employee-management.
##### Run the Docker container for your database. Use the following command:
```bash
docker run -p 3307:3306 --name hr -e MYSQL_ROOT_PASSWORD=root -dt mbn217/hr-employee-db:final
```
This will start a Docker container with the name hr, running the mbn217/hr-employee-db:final image. The database will be accessible at localhost:3307.
##### Run the Docker container for your application. Use the following command:
```bash
docker run -p 8080:8080 --link hr:db -e SPRING_DATASOURCE_URL=jdbc:mysql://db:3306/hr -e SPRING_DATASOURCE_USERNAME=root -e SPRING_DATASOURCE_PASSWORD=root employee-management
```
- This will start a Docker container running your application, which will be accessible at localhost:8080. 
- The --link option links your application container to the database container, allowing them to communicate.  Please note that you need to replace root with your actual MySQL username and password in the SPRING_DATASOURCE_USERNAME and SPRING_DATASOURCE_PASSWORD environment variables.