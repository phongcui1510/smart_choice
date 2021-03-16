# SMART CHOICE
A website that can compare the price of a product from different resources (Tiki, Lazada, Shopee...)

- High Level Design
- Software Principle
- Project structure & application configuration
- ERD Diagram
- How to run application
- API Document

## High Level Architecture

![alt text](https://github.com/phongcui1510/smart_choice/blob/main/external-file/high-level-architect.png?raw=true)

##### Discovery Service
The service is a database populated with information on how to dispatch requests to microservice instances.

##### Gateway Service
The service encapsulates the internal system architecture and provides an API that is tailored to each client. 

##### Product Service
This is core business of Smart Choice system. It call to Crawler service when client search for product by using name and store these searching informations.
When client get detail information of specific product, this service will retrieve from Redis database to avoid make a request to Crawler Service.

##### Crawler Service
This service will responsible for searching product on external resources(Tiki,Lazada,Shopee,...) and store these product in database.

##### Audit Service
logging all client activities.

##### Config Service
Hold the configuration file, e.g product-service.properties, audit-service.yml, product-service-dev.properties

##### Identity Provider
An identity provider is a service that stores and verifies user identity. (In this project, we will use Okta)

##### Common Jar Project
Use to build some common POJO class, Util class, ... so that all services can use.

## Technologies
- Spring Boot
- Spring Cloud
- Spring Gateway + Zuul
- Spring OAuth2 + Okta
- Spring AMQP RabbitMQ + CloudAMQP
- Spring Data

## Software development principles
### KISS (Keep It Simple Stupid)
- Most systems work best if they are kept simple rather than made complex.
- Less code takes less time to write, has less bugs, and is easier to modify.
- > The best design is the simplest one that works - Albert Einstein.

**What applied:** Keep system design and the implementation code simple

### YAGNI (You aren't gonna need it)
- Don't implement something until it is necessary.
- Any work that's only used for a feature that's needed tomorrow, means losing effort from features that need to be done for the current iteration.

**What applied:** Always implement things when we actually need them, never when we just foresee that we need them.

### Separation of Concerns
- Separating a system into multiple distinct microservices, such that each service addresses a separate concern (product, order, shopping cart...).
- In each service, break program functionality into separate layers (as show in [Project folder structure](#project-folder-structure)).
- AOP to separate of cross-cutting concerns.

### DRY
- Put business rules, long expressions, if statements, math formulas, metadata, etc. in only one place.

### Code For The Maintainer
- Maintenance is by far the most expensive phase of any project.
- Always code as if the person who ends up maintaining your code is a violent psychopath who knows where you live.
- Always code and comment in such a way that if someone a few notches junior picks up the code, they will take pleasure in reading and learning from it.

**What applied:** Comprehensive documentation, make the code clean, add comment for some special intentions.

### Avoid Premature Optimization
- It is unknown upfront where the bottlenecks will be.
- After optimization, it might be harder to read and thus maintain.

**What applied:** Don't optimize until we need to, and only after profiling we discover a bottleneck optimise that.

### Minimise Coupling
- Eliminate, minimise, and reduce complexity of necessary relationships.
- By hiding implementation details, coupling is reduced.

**What applied:** Encapsulation in OOP, DI in Spring.

### Inversion of Control
IoC inverts the flow of control as compared to traditional control flow (Don't call us, we'll call you).
- In traditional programming: our custom code makes calls to a library.
- IoC: framework make calls to our custom code.

**What applied:** Spring IoC container with Constructor-Based Dependency Injection for main code and Field-Based Dependency Injection for test code.

### Single Responsibility Principle
Every class should have a single responsibility, and that responsibility should be entirely encapsulated by the class. Responsibility can be defined as a reason to change, so a class or module should have one, and only one, reason to change.

**What applied:** break system into multiple services, each services has only one responsibility. In each services, break into multiple layers, each layers were broken into multiple classes, each class has only one reason to change.

## Design Patterns
- **Object Mother:** pattern is essentially a special case of the Factory pattern used for creating test objects. It provides one or more factory methods that each create an object in a specific, meaningful configuration ([ProductMother.java](product-service/src/test/java/com/nthieu/productservice/helper/ProductMother.java))
- **Builder**: provide a flexible solution to object creation. ([Product.java](product-service/src/main/java/com/nthieu/productservice/entity/Product.java))

## Project structure & application configuration
| application       | Port          |
| ------------------| ------------- |
| audit-service     | 8082          |
| crawler-service   | 8083          |
| discovery-service | 8761          |
| gateway-service   | 8080          |
| product-service   | 8081          |
| config-service    | 8888          |
| rabbitmq          | 15672         |

## ERD Diagram
![alt text](https://github.com/tintin0122/smart_choice/blob/main/images/smart_choice_class.jpg?raw=true)

*Note: For this assignment, I simplify the schema to one table(Product table) in product-service.

## How to run the application
- Install [JDK 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- Install [Docker](https://www.docker.com/products/docker-desktop)
- Install [Maven](https://maven.apache.org/download.cgi?Preferred=ftp://mirror.reverse.net/pub/apache/)
- Clone the smart_choice repository
- Get token:
  - Using Postman to get token
  ![alt text](https://github.com/phongcui1510/smart_choice/blob/main/external-file/get-token.PNG?raw=true)
  - Token Name: okta-token
  - Callback URL: http://localhost:8080/
  - Auth URL: https://dev-53338529.okta.com/oauth2/default/v1/authorize
  - Access Token URL: https://dev-53338529.okta.com/oauth2/default/v1/token
  - Client ID: 0oaboywweOUSXhBUV5d6
  - Client Secret: XZfe1eznxMIskaMupa63PuKLjQ7VXK5Q3e3iOtev
  - Scope: openid
  - State: 123456
  - Or you can import /external-files/assignment.postman_collection.json

- Run services: (note: make sure starting discovery-service at first)
  - common: mvn clean install
  - discovery-service, audit-service, gateway-service, config-service: mvn clean install && java -jar target/<service-name>-1.0.0.jar
  - product-service, crawler-service: mvn clean install && java -jar configuration/target/configuration-1.0.0.jar
- Test services using postman:
  ![alt text](https://github.com/phongcui1510/smart_choice/blob/main/external-file/product-service-ping.PNG?raw=true)
  ![alt text](https://github.com/phongcui1510/smart_choice/blob/main/external-file/product-service-findbykeyword.PNG?raw=true)

## API Document
- Searching product by name: (iphone, vinfast, shoe) http://localhost:8080/customers/{customer-id}/products/search?product-name={search-keyword}
  - example: curl --location --request GET 'http://localhost:8080/customers/user001/products/search?product-name=iphone' \
--header 'x-user: user001'
- Go to product detail: http://localhost:8080/customers/{customer-id}/products/{product-id}
  - example: curl --location --request GET 'http://localhost:8080/customers/user001/products/1202' \
--header 'x-user: user001' 
- Get user activities:
  - curl --location --request GET 'http://localhost:8080/audit/customer-activity'
