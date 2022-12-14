# Online-Shop
Online Shopping Example with Microservices Using Spring

## Architecture
All the Microservices are developed using spring boot. This spring boot applications will be registered with eureka discovery server.
Zuul will route the requests to microservice based on the url route. Zuul also registers with eureka and gets the ip/domain from eureka for microservice while routing the request.

### Run this project in Local Machine
>Using Intellij idea or Command Line

Import this project into IDE and run all Spring boot projects or build all the jars running mvn clean install command in root parent pom, which builds all jars. All services will be up in the below mentioned ports.

But running this way we wont get monitoring of microservices. So if monitoring needed to see metrics like jvm memory, tomcat error count and other metrics.

Use below method to deploy all the services and monitoring setup in docker.

>Using Docker(Recommended)

Start Docker Engine in your machine.

Run mvn clean install at root of project to build all the microservices jars.

Run docker-compose up --build to start all the containers.

Services will be exposed in this ports

   - Api Gateway Service       : 9091
   - Eureka Discovery Service  : 9092
   - Consul Discovery          : 9093

## Requiremenent

### Micro Services:

- order-service
  - hostname: ORDER-SERVICE
  - URL: http://localhost:8083
  
- account-service
  - hostname: ACCOUNT-SERVICE
  - URL: http://localhost:8081
  
- billing-service
  - hostname: BILLING-SERVICE
  - URL: http://localhost:8084  
  
- product-service
  - hostname: PRODUCT-SERVICE
  - URL: http://localhost:8082  
