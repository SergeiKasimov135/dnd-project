FROM openjdk:17-jdk-slim
EXPOSE 8081
VOLUME /tmp
COPY target/playableCharacter-service-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar", "--spring.profiles.active=native"]