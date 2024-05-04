FROM FROM maven:3.9.3-eclipse-temurin-17-alpine AS builder
WORKDIR build
COPY . .
RUN mvn clean install -DskipTests

FROM eclipse-temurin:17-jre-alpine
COPY --from=builder target/*.jar app.jar
EXPOSE 8080
CMD ["java","-jar","app.jar"]