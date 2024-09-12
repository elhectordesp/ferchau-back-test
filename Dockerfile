FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/ferchau-app-0.0.1-SNAPSHOT.jar /app/ferchau-app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/ferchau-app.jar"]

