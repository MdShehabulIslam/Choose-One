# Overview

This project integrates a Java backend, a Scala backend, and a modern frontend using PostgreSQL. It demonstrates data fetching from both backend services and displays the results in a user-friendly web interface.

## Backend (Java)

The Java backend is built using Spring Boot and provides a REST API to fetch data from a PostgreSQL database.

- Dependencies: Spring Boot, PostgreSQL Driver, SLF4J
- Port: 8080
- Endpoint: /data

## Backend (Scala)

The Scala backend is built using Akka HTTP and serves data via a REST API.

- Dependencies: Akka HTTP
- Port: 8081
- Endpoint: /data

## Frontend

The frontend is a simple web interface that uses HTML, CSS, and JavaScript to interact with both backend services.

- Styling: Bootstrap 4, custom CSS
- Functionality: Fetches and displays data from Java and Scala backends

# Setup

## Prerequisites

- Java 11 or higher
- Scala 2.13 or higher
- PostgreSQL
- sbt (for Scala build tool)
- Maven (for Java build tool)

## Running the Java Backend

1. Navigate to the backend directory:

```
cd backend
```

2. Run the application

```
mvn spring-boot:run
```

## Running the Scala Backend

1. Navigate to the backend directory:

```
cd scala
```

2. Run the application

```
sbt run
```

## Setting Up the Database

1. Ensure PostgreSQL is running.
2. Create a database named postgres (or update the backend configuration to match your database name).

## Running the Frontend

1. Open frontend/index.html in your web browser.
