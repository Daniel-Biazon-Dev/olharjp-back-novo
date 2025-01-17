FROM ubuntu:latest AS BUILD

RUN apt-get update
RUN apt-get install openjdk-17-jdk -y

COPY . .

RUN apt-get install maven -y
RUN mvn clean
RUN mvn install

FROM openjdk:17-jdk-slim

EXPOSE 8080

COPY --from=BUILD /target/olhar-joaopessoa-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT [ "java", "-jar", "app.jar" ]