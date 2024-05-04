FROM eclipse-temurin:17
MAINTAINER HusrevAkbas
RUN mvn clean package
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]