FROM maven:3.8.3-jdk-11 as build
COPY pom.xml pom.xml
RUN mkdir app
COPY reporting/mvnw app/mvnw
COPY reporting/.mvn app/.mvn
COPY reporting/pom.xml app/pom.xml
COPY reporting/src app/src
WORKDIR /app
RUN mvn clean package -DskipTests

FROM adoptopenjdk:11-jre-hotspot
COPY --from=build app/target/reporting-*.jar /app/app.jar
CMD ["java", "-jar", "/app/app.jar"]
EXPOSE 8764