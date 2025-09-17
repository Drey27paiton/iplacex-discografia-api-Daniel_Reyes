FROM gradle:jdk21 AS builder
WORKDIR /app

COPY gradlew .
COPY gradle gradle

RUN chmod +x gradlew

COPY build.gradle .
COPY settings.gradle .
COPY src src

RUN ./gradlew build --no-daemon

FROM openjdk:21-jdk-slim
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar discografia.jar
EXPOSE 443
CMD ["java", "-jar", "discografia.jar"]
