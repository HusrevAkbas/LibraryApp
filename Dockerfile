FROM maven:3.8.4:eclipse-temurin:17-jdk AS builder
MAINTAINER HusrevAkbas
WORKDIR /app
COPY pom.xml .
RUN mvn -B -f pom.xml dependency:go-offline
COPY src ./src
RUN mvn -B package -DskipTests


FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=build /app/target/*.jar .
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "your-application-name.jar"]