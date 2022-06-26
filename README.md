# JDBC_Pooling
Java Connection Pooling demo

## Description

Connection pooling is a mechanism to create and maintain a collection of JDBC connection objects. The primary objective of maintaining the pool of connection object is to leverage re-usability and improve the overall performance of the application.

## Getting Started

### Tools Used

* IntelliJ IDEA
* JDK 18
* Maven (to download the MySQL connector jar and Connection Pool libraries)
* MySQL database

### Dependencies

* mysql-connector-java
* commons-dbcp

### Setup

* Import the database in `src/main/java/test/jdbc_pool/db/jdbc_pool.sql`
* Change the database credentials in `src/main/java/test/jdbc_pool/utils/ConnectionPoolConst.java`
```
static final String JDBC_USER = "root";
static final String JDBC_PASSWORD = "";
```

## Acknowledgments

Inspiration, code snippets, etc.
* [Java Code Geeks](https://examples.javacodegeeks.com/core-java/sql/jdbc-connection-pool-example/)
