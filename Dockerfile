# Use OpenJDK 17 (or 20, depending on your project)
FROM eclipse-temurin:17-jdk-alpine

# Set working directory
WORKDIR /app

# Copy Maven wrapper and pom.xml
COPY mvnw pom.xml ./
COPY .mvn .mvn

# Download dependencies (cache them)
RUN ./mvnw dependency:go-offline

# Copy the rest of the code
COPY src ./src

# Build the project
RUN ./mvnw clean package -DskipTests

# Expose port 8080
EXPOSE 8080

# Run the JAR
CMD ["java", "-jar", "target/myproject1-1.0-SNAPSHOT.jar"]
