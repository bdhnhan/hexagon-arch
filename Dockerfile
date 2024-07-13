# Use an official Java runtime as a parent image
FROM openjdk:17-oracle

# Set the working directory in the container
WORKDIR /app

# Copy the current directory contents into the container at /app
COPY infrastructure/target/ /app
COPY config /app

# Make port 8080 available to the world outside this container
EXPOSE 8080

ENV JAVA_OPTS="-Dspring.profiles.active=local -Dspring.config.location=local.yaml"

# Run the application
#CMD ["java $JAVA_OPTS", "-jar", "infrastructure-0.0.1.jar"]
CMD ["sh", "-c", "java $JAVA_OPTS -jar infrastructure-0.0.1.jar"]