FROM maven:3.6.3-adoptopenjdk-11 AS MAVEN_BUILD
MAINTAINER Tarun Dhraik
COPY pom.xml /build/
COPY src /build/src/
WORKDIR /build/
RUN mvn package
FROM java:11
WORKDIR /app
COPY --from=MAVEN_BUILD /build/target/team-admin-service-1.0-SNAPSHOT.jar /app/
ENTRYPOINT ["java", "-jar", "team-admin-service-1.0-SNAPSHOT.jar"]