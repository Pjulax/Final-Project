FROM maven:3.8.3-jdk-11 as build
COPY pom.xml pom.xml
RUN mkdir app
COPY gateway/mvnw app/mvnw
COPY gateway/.mvn app/.mvn
COPY gateway/pom.xml app/pom.xml
COPY gateway/src app/src
WORKDIR /app
RUN mvn clean package -DskipTests

FROM adoptopenjdk:11-jre-hotspot
COPY --from=build app/target/gateway-*.jar /app/app.jar
CMD ["java", "-jar", "/app/app.jar"]
EXPOSE 8760