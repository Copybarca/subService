FROM openjdk:20-oracle
ARG JAR_FILE=target/*.jar
COPY ./target/calories-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080/tcp
ENTRYPOINT ["java","-jar","/app.jar"]