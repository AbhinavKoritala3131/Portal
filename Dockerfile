FROM maven:3.9.4-eclipse-temurin-17 AS build

WORKDIR /app

# Copy pom and source code
COPY pom.xml .
COPY src ./src

# Build the project
RUN mvn clean package -DskipTests

# Use lightweight JDK image for runtime
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

COPY --from=build /app/target/myproject1-1.0-SNAPSHOT.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
