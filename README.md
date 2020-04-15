# Customized Closet :womans_clothes: :shirt:
## :sunny:Idea
A back end project to manage your clothes in digital.

## :crescent_moon:Technical Skills 
This application is developed in Spring Framework by using Spring Boot, Hibernate, RESTful web services, Postman, Maven, PostgresSql, Docker, Amazon SQS, and Amazon S3.

## :zap: Project Approach

* Create model (package) classes;

* Use flyway to perform database schema migration;

* Use JDBC to interact with PostgresSQL server including CRUD operations;

* Replace JDBC with Hibernate framework (Finish Persistent Layer);

* Create repository and service packages, implement business logic (Finish Service Layer);

* Add controller classes, achieve the goal of handling requests and responses of clients;

* Test Restful APIs with Postman;

* Add authentication and authorization;

* Integrate third-party application AWS S3, SQS and do Mockito test;

* Package project into a Docker image.

## :cherry_blossom:Building Procedure

```bash
docker pull postgres
docker run --name ${PostgresContainerName} -e POSTGRES_USER=${username} -e POSTGRES_PASSWORD=${password} -e POSTGRES_DB=${databaseName} -p ${hostport}:${containerport} -d 
```

```bash
mvn clean compile flyway:migrate -Ddatabase.url=jdbc:postgresql://${database_host}:5432/${database_name} 
-Ddatabase.user=${user_name} -Ddatabase.password=${password}
```
```bash
mvn test -Ddatabase.url=jdbc:postgresql://${database_url}:5432/${database_name} -Ddatabase.user=${user_name} 
-Ddatabase.password=${password}  
-Ddatabase.dialect=org.hibernate.dialect.PostgreSQL9Dialect -Ddatabase.driver=org.postgresql.Driver
```
