# Use a Java image
FROM openjdk:21-jdk

# Set the working directory
WORKDIR /app

# Copy the jar file
COPY target/*.jar app.jar

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]
