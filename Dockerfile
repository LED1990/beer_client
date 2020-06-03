FROM openjdk:11-jre-slim
WORKDIR /usr/local
COPY ./target/beer-client-0.0.1-SNAPSHOT.jar beer-client-0.0.1.jar
ENTRYPOINT ["java", "-jar", "beer-client-0.0.1.jar"]