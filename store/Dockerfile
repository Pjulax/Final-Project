FROM maven:3.8.3-jdk-11 as build
COPY pom.xml pom.xml
RUN mkdir app
COPY store/mvnw app/mvnw
COPY store/.mvn app/.mvn
COPY store/pom.xml app/pom.xml
COPY store/src app/src
WORKDIR /app
RUN mvn clean package -DskipTests

FROM adoptopenjdk:11-jre-hotspot
COPY --from=build app/target/store-*.jar /app/app.jar
CMD ["java", "-jar", "/app/app.jar"]
EXPOSE 8763