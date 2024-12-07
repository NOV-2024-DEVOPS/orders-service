FROM maven:3.9.5-eclipse-temurin-11 AS build

WORKDIR /app
COPY pom.xml ./
COPY src ./src
RUN mvn clean package -DskipTests

FROM openjdk:11-jre-slim

WORKDIR /app
COPY --from=build /app/target/orders-service-example-0.0.1-SNAPSHOT.jar /app/orders-service-example-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["sh", "-c", "java -jar orders-service-example-0.0.1-SNAPSHOT.jar $APP_ARGS"]
#ENTRYPOINT ["sh", "-c", "java -jar products-service-example-0.0.1-SNAPSHOT.jar $APP_ARGS > /app/application.log 2>&1"]
#
#CMD ["java", "-jar", "orders-service-example-0.0.1-SNAPSHOT.jar"]
#CMD ["sh", "-c", "java -jar orders-service-example-0.0.1-SNAPSHOT.jar $APP_ARGS"]