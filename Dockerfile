FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ./target/*.jar ps-inventory-app.jar
ENTRYPOINT ["java","-jar","ps-inventory-app.jar"]