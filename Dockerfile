FROM maven:3-jdk-11 AS MAVEN_BUILD
MAINTAINER Tarun Dhraik
COPY pom.xml /build/
COPY src /build/src/
WORKDIR /build/
RUN mvn package
FROM openjdk:11-jdk
WORKDIR /app
COPY --from=MAVEN_BUILD /build/target/team-admin-service-1.0-SNAPSHOT.jar /app/
ENTRYPOINT ["java", "-jar", "team-admin-service-1.0-SNAPSHOT.jar"]