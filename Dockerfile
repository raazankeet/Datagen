# Use an official OpenJDK 8 runtime as the base image
FROM openjdk:8-jre-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the Spring Boot jar into the container
COPY target/datagen-0.0.3.jar app.jar

# Expose the port on which the application is running (change it if your application uses a different port)
EXPOSE 9094

# Run the Spring Boot application when the container starts
CMD ["java", "-jar", "app.jar"]
