# Use the official OpenJDK base image for Java 17
FROM openjdk:17-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the Spring Boot JAR file from your local machine to the container
COPY target/mapersive-0.0.1-SNAPSHOT.jar /app/app.jar

# Expose the port your Spring Boot app is listening on (change it if needed)
EXPOSE 8080

EXPOSE 5432

# Run the Spring Boot application
CMD ["java", "-jar", "app.jar"]
