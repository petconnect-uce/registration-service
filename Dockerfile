FROM openjdk:21-jdk-slim

ARG JAR_FILE=target/registration-service-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} app.jar

EXPOSE 3002

ENTRYPOINT ["java", "-jar", "app.jar"]
