# HSQLDB in server mode spring-boot demo

## What?

Simple example on how to run hsqldb server in server mode from spring-boot. The application exposes a REST controller which invokes a JPA repository method. 

## Why?

See [this question]() in StackOverflow.

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

