FROM openjdk:17-jdk-slim
EXPOSE 8761
VOLUME /tmp
COPY target/registry-service-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]