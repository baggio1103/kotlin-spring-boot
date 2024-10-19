# Use a base image that has OpenJDK 19 installed
FROM openjdk:19-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the jar file to the container
COPY build/libs/dockerize-user-service-0.0.1-SNAPSHOT.jar app.jar

# Specify the command to run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]

# Expose the port your Spring Boot app runs on
EXPOSE 8080
