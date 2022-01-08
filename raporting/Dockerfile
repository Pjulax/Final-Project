FROM maven:3.8.3-jdk-11 as build
COPY pom.xml pom.xml
RUN mkdir app
COPY raporting/mvnw app/mvnw
COPY raporting/.mvn app/.mvn
COPY raporting/pom.xml app/pom.xml
COPY raporting/src app/src
WORKDIR /app
RUN mvn clean package -DskipTests

FROM adoptopenjdk:11-jre-hotspot
COPY --from=build app/target/raporting-*.jar /app/app.jar
CMD ["java", "-jar", "/app/app.jar"]
EXPOSE 8764