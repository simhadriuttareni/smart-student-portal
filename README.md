# Smart Student Portal Backend

This is a Spring Boot REST API backend project for managing student data. It provides full CRUD (Create, Read, Update, Delete) operations connected to a PostgreSQL database.

## Features

- RESTful API endpoints for students management
- PostgreSQL integration with JPA/Hibernate
- Exception handling with custom exceptions
- Validations and error responses
- Fully tested with Postman and curl

## Technologies Used

- Java 17 (or your Java version)
- Spring Boot 3.x
- Spring Data JPA
- PostgreSQL
- Maven
- Postman (for API testing)

## Getting Started

### Prerequisites

- Java JDK 11 or higher installed
- PostgreSQL installed and running
- Maven installed (or use IDE built-in Maven)

### Setup PostgreSQL Database

1. Create database named `studentsdb`.
2. Use username: `postgres` and password: `1234` (update in `application.properties` if needed).

### Running the Project

Clone the repo:

```bash
git clone https://github.com/<your-github-username>/smart-student-portal.git
cd smart-student-portal
