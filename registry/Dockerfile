FROM maven:3.8.3-jdk-11 as build
COPY pom.xml pom.xml
RUN mkdir app
COPY registry/mvnw app/mvnw
COPY registry/.mvn app/.mvn
COPY registry/pom.xml app/pom.xml
COPY registry/src app/src
WORKDIR /app
RUN mvn clean package -DskipTests


FROM adoptopenjdk:11-jre-hotspot
COPY --from=build app/target/registry-*.jar /app/app.jar
CMD ["java", "-jar", "/app/app.jar"]
EXPOSE 8761