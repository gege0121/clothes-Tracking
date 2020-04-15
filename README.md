# clothes-Tracking :womans_clothes: :shirt:



```bash
mvn clean compile flyway:migrate -Ddatabase.url=jdbc:postgresql://${database_host}:5432/${database_name} 
-Ddatabase.user=${user_name} -Ddatabase.password=${password}
```
```bash
mvn test -Ddatabase.url=jdbc:postgresql://${database_url}:5432/${database_name} -Ddatabase.user=${user_name} 
-Ddatabase.password=${password}  
-Ddatabase.dialect=org.hibernate.dialect.PostgreSQL9Dialect -Ddatabase.driver=org.postgresql.Driver
```
