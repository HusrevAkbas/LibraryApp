FROM eclipse-temurin:17
MAINTAINER HusrevAkbas
CMD mvn clean package
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]