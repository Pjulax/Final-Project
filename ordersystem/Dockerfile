FROM maven:3.8.3-jdk-11 as build
COPY pom.xml pom.xml
RUN mkdir app
COPY ordersystem/mvnw app/mvnw
COPY ordersystem/.mvn app/.mvn
COPY ordersystem/pom.xml app/pom.xml
COPY ordersystem/src app/src
WORKDIR /app
RUN mvn clean package -DskipTests

FROM adoptopenjdk:11-jre-hotspot
COPY --from=build app/target/ordersystem-*.jar /app/app.jar
CMD ["java", "-jar", "/app/app.jar"]
EXPOSE 8762