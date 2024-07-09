# Use the official Maven image to build the application
FROM maven:3.9.8-amazoncorretto-17 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml file and the source code into the container
COPY pom.xml .
COPY src ./src

# Package the application into a JAR file
RUN mvn clean package -DskipTests

# Use the Amazon Corretto 17 runtime image to run the application
FROM amazoncorretto:17

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the build stage into the runtime stage
COPY --from=build /app/target/checkout-1.0.0.jar /app/checkout.jar

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "/app/checkout.jar"]