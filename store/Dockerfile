FROM maven:3.8.3-jdk-11 as build
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src
RUN mvn clean package -DskipTests

FROM adoptopenjdk:11-jre-hotspot
COPY --from=build target/store-*.jar /app/app.jar
CMD ["java", "-jar", "/app/app.jar"]
EXPOSE 8763