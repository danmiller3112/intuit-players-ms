# Use the official OpenJDK image as the base image
FROM openjdk:11-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the application JAR file to the container
COPY target/players-0.0.1-SNAPSHOT.jar players-ms.jar

# Expose the port that the application will run on
EXPOSE 8080

# Set the command to run the application when the container starts
CMD ["java", "-jar", " players-ms.jar"]
