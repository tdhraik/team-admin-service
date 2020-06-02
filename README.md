# Team administration service

Service to manage team members data.

## Prerequisites

* Java 11

## Optional
* Docker

##Usage
1) Clone the repository at 
2) cd team-admin-service && ./mvnw clean install
3) Run application locally using ./mvnw spring-boot:run

Or Build it without maven: 
``` shell
./mvnw package
java -jar target/team-admin-service-1.0-SNAPSHOT.jar
```

## Usage(docker)
1) Clone the repository
2) cd team-admin-service
3) Run the following commands...
 ```
 docker image build -t team-admin-service .
 docker run -p 8080:8080 team-admin-service
 ```
 
 
 
Application should be up and running now.. 

## SWAGGER
1) Access the swagger documentation and access the end points [here](http://localhost:8091/swagger-ui.html) 

2) Access in-memory H2 database, [here](http://localhost:8091/h2) 


