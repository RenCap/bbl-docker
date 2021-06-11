# Builder
FROM openjdk:11.0.11-jdk-slim as builder
WORKDIR /usr/src/app
COPY gradle gradle
COPY build.gradle.kts .
COPY gradlew .
COPY gradlew.bat .
COPY settings.gradle.kts .
COPY src src
RUN ./gradlew build

# Runner
FROM openjdk:11.0.11-jre-slim

ENV DS_HOST localhost
ENV DS_PORT 5432
ENV DS_BASE bbl
ENV DS_USER bbl
ENV DS_PWD bbl
ENV SMTP_HOST localhost
ENV SMTP_PORT 1025

COPY --from=builder /usr/src/app/build/libs/bbl-docker-api-0.0.1-SNAPSHOT.jar api.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dds.host=${DS_HOST}","-Dds.port=${DS_PORT}","-Dds.base=${DS_BASE}","-Dds.user=${DS_USER}","-Dds.pwd=${DS_PWD}","-Dsmtp.host=${SMTP_HOST}","-Dsmtp.port=${SMTP_PORT}","-jar","api.jar"]
