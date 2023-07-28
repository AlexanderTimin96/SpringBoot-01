
FROM openjdk:17-jdk-slim-buster

EXPOSE 8080

COPY target/SpringBootHomework1-0.0.1-SNAPSHOT.jar myapp.jar

CMD ["java","-jar","myapp.jar"]