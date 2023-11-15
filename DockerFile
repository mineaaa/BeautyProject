FROM maven:3.8.6-eclipse-temurin-17-focal AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM eclipse-temurin:17-jre-focal

COPY --from=build /home/app/target/harjoitustyo-0.0.1-SNAPSHOT.jar /usr/local/lib/harjoitustyo.jar
EXPOSE 8080 
ENTRYPOINT ["java", "-jar", "/usr/local/lib/harjoitustyo.jar"]