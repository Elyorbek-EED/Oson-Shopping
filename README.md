# Online-Shop
Online Shopping Example with Microservices Using Spring

## Architecture
All the Microservices are developed using spring boot. This spring boot applications will be registered with eureka discovery server.
Zuul will route the requests to microservice based on the url route. Zuul also registers with eureka and gets the ip/domain from eureka for microservice while routing the request.

## Requiremenent

### Micro Services:

- order-service
  - hostname: ORDER-SERVICE
  - Ports: 18383:8383
  - URL: http://localhost:8083
  
- account-service
  - hostname: ACCOUNT-SERVICE
  - Ports: 18383:8383
  - URL: http://localhost:8081
  
- billing-service
  - hostname: BILLING-SERVICE
  - Ports: 18383:8383
  - URL: http://localhost:8084  
  
- product-service
  - hostname: PRODUCT-SERVICE
  - Ports: 18383:8383
  - URL: http://localhost:8082  
