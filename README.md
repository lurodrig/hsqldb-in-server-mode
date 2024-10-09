# HSQLDB in server mode spring-boot demo

## What?

Simple example on how to run hsqldb server in server mode from spring-boot. The application exposes a REST controller which invokes a JPA repository method. 

## Why?

After running my app I want to be able to connect to my db from a third party client like [squirrel](https://squirrel-sql.sourceforge.io/) 

## How?
```
$ java --version
java 21.0.2 2024-01-16 LTS

$ ./gradlew --version

------------------------------------------------------------
Gradle 8.10.2
------------------------------------------------------------

$ ./gradlew bootRun

$ curl http://localhost:8080/accounts
```
## Thanks

Model and SQL scripts taken from [spring academy labs](https://spring.academy/courses/spring-boot)

## References
- [How to correctly integrate HSQLDB with Spring Boot?](https://stackoverflow.com/questions/70006118/how-to-correctly-integrate-hsqldb-with-spring-boot)
- [Hyper SQL Server](https://hsqldb.org/doc/guide/listeners-chapt.html#lsc_hsql_server)

