FROM maven:3-openjdk-11-slim AS build

WORKDIR /temp/backend

ADD pom.xml .

RUN ["mvn", "verify", "clean", "--fail-never"]

COPY . .

RUN ["mvn", "clean", "install", "-DskipTests=true"]

FROM openjdk:11-jre-slim-buster

WORKDIR /app/backend

COPY --from=build /temp/backend/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-Dspring.profiles.active=production", "-jar", "app.jar"]