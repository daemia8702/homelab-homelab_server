FROM maven:3.9.15-eclipse-temurin-25-alpine AS development
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean test


FROM maven:3.9.15-eclipse-temurin-25-alpine AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:25-jre-alpine
WORKDIR /app

ENV DB_DATASOURCE=""
ENV DB_USERNAME=""
ENV DB_PASSWORD=""

COPY --from=build /app/target/*.jar /app/app.jar
EXPOSE 8080
COPY entrypoint.sh .
RUN chmod +x entrypoint.sh
ENTRYPOINT ["./entrypoint.sh"]

