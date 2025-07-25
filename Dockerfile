FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR file from your target directory into the container
# Assuming your Spring Boot application builds to target/demo-0.0.1-SNAPSHOT.jar
# Adjust the JAR name if yours is different
COPY target/springbootjpa-mysql-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your Spring Boot application runs on (default is 8080)
EXPOSE 8086

# Command to run the Spring Boot application when the container starts
ENTRYPOINT ["java","-jar","app.jar"]