# Stage 1: Build
FROM gradle:jdk21 AS builder
WORKDIR /app
# COPY ./build.gradle .
# COPY ./settings.gradle .
# COPY src ./src
# RUN chmod +x gradlew
COPY . .
RUN ./gradlew build --no-daemon

# Stage 2: Run
FROM openjdk:21-jdk-slim
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar discografia.jar
EXPOSE 443
CMD ["java", "-jar", "discografia.jar"]