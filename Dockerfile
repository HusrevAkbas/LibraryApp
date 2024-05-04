FROM eclipse-temurin:17-jdk AS builder
WORKDIR /app
RUN apt-get update && \
    apt-get install -y maven && \
    rm -rf /var/lib/apt/lists/*
COPY pom.xml .
RUN mvn -B -f pom.xml dependency:go-offline
COPY src ./src
RUN mvn -B package -DskipTests


FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=builder /app/target/*.jar .
EXPOSE 8080
MAINTAINER HusrevAkbas
ENTRYPOINT ["java", "-jar", "your-application-name.jar"]