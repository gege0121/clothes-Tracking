# Customized Closet :womans_clothes: :shirt:
## :sunny:Idea:sunny:
**A back end project to manage your clothes in digital.**

## :cherry_blossom:Technical Skills :cherry_blossom: 
**This application is developed in Spring Framework by using Spring Boot, Hibernate, RESTful web services, Postman, Maven, PostgresSql, Docker, Amazon SQS, and Amazon S3.**

## :zap: Project Approach :zap:

1. Create model (package) classes;

2. Use flyway to perform database schema migration;

3. Use JDBC to interact with PostgresSQL server including CRUD operations;

4. Replace JDBC with Hibernate framework (Finish Persistent Layer);

5. Create repository and service packages, implement business logic (Finish Service Layer);

6. Add controller classes, achieve the goal of handling requests and responses of clients;

7. Test Restful APIs with Postman;

8. Add authentication and authorization;

9. Integrate third-party application AWS S3, SQS and do Mockito test;

10. Package project into a Docker image

```bash
mvn clean compile flyway:migrate -Ddatabase.url=jdbc:postgresql://${database_host}:5432/${database_name} 
-Ddatabase.user=${user_name} -Ddatabase.password=${password}
```
```bash
mvn test -Ddatabase.url=jdbc:postgresql://${database_url}:5432/${database_name} -Ddatabase.user=${user_name} 
-Ddatabase.password=${password}  
-Ddatabase.dialect=org.hibernate.dialect.PostgreSQL9Dialect -Ddatabase.driver=org.postgresql.Driver
```
