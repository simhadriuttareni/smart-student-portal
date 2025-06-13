# 🎓 Smart Student Portal – Backend API

A Spring Boot-based RESTful API to manage students and their data efficiently. This is part of a complete student management system.

---

## 🚀 Features

- RESTful API endpoints for student management
- PostgreSQL integration with JPA/Hibernate
- Custom exception handling for better error management
- Validations and detailed error responses
- Fully tested with Postman and curl
- Add, update, delete, and fetch students
- REST API with proper HTTP responses
- Layered architecture (Controller, Service, Repository)

---

## 📦 Tech Stack

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- PostgreSQL
- Maven

---

## 🔧 API Endpoints

| Method | Endpoint             | Description         |
|--------|----------------------|---------------------|
| GET    | `/api/students`      | Fetch all students  |
| GET    | `/api/students/{id}` | Get student by ID   |
| POST   | `/api/students`      | Add new student     |
| PUT    | `/api/students/{id}` | Update student by ID|
| DELETE | `/api/students/{id}` | Delete student by ID|

---

## 🛠️ Setup Instructions

1. Create a database named `studentsdb`.
2. Use username: `postgres` and password: `1234` (make sure this matches your `application.properties`).

### Clone and Run the Project

```bash
git clone https://github.com/simhadriuttareni/smart-student-portal.git
cd smart-student-portal
mvn clean install
mvn spring-boot:run
