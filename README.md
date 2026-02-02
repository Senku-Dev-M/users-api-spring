# Users API (Spring Boot)

A simple REST API for managing users, built with Spring Boot and MySQL. It follows a Clean/Hexagonal architecture with use cases and ports, and exposes OpenAPI/Swagger documentation.

## Features
- Create a user
- List all users
- Get a user by id
- Delete a user

## Tech Stack
- Java 17
- Spring Boot
- Spring Web MVC
- Spring Data JPA (Hibernate)
- MySQL 8
- Springdoc OpenAPI (Swagger UI)

## Architecture
This project follows a layered, Clean/Hexagonal style structure:

- `domain`: Core business model and validations (`User`, `Email`, domain exceptions).
- `application`: Use cases and ports (`UserRepository`).
- `interfaces`: REST controllers and DTOs.
- `infrastructure`: Persistence adapters, JPA entities, and Spring configuration.

High-level flow:

```
HTTP (Controller) -> Use Case -> Port (UserRepository) -> JPA Adapter -> MySQL
```

## API Endpoints
Base URL: `http://localhost:8080`

| Method | Path            | Description             | Responses |
|-------:|-----------------|-------------------------|-----------|
| POST   | `/users`        | Create a new user       | 201, 400  |
| GET    | `/users`        | List all users          | 200       |
| GET    | `/users/{id}`   | Get user by id          | 200, 404  |
| DELETE | `/users/{id}`   | Delete user by id       | 204       |

### Data Model
```
User
- id: UUID
- name: string (not blank)
- email: string (valid email format)
```

Validation is enforced via Bean Validation (`@NotBlank`, `@Email`) and domain rules.

## Swagger / OpenAPI
- Swagger UI: `http://localhost:8080/swagger-ui/index.html`
- OpenAPI JSON: `http://localhost:8080/v3/api-docs`

## Run Locally
### Prerequisites
- Java 17
- Docker (for MySQL)

### 1) Start MySQL with Docker
```
docker compose up -d
```
This starts a MySQL 8 container with:
- Database: `users_db`
- User: `appuser`
- Password: `apppass`

### 2) Run the API
On Windows (PowerShell):
```
.\mvnw.cmd spring-boot:run
```

On macOS/Linux:
```
./mvnw spring-boot:run
```

The API will run on `http://localhost:8080`.

### 3) Build a JAR (optional)
```
./mvnw clean package
```
Then run:
```
java -jar target/api-users-0.0.1-SNAPSHOT.jar
```

## Configuration
Default configuration is in `src/main/resources/application.properties`.

Main settings:
- `server.port=8080`
- `spring.datasource.url=jdbc:mysql://localhost:3306/users_db`
- `spring.datasource.username=appuser`
- `spring.datasource.password=apppass`

Update these values to match your environment if needed.

## cURL Examples
### Create a user
```
curl -X POST http://localhost:8080/users \
  -H "Content-Type: application/json" \
  -d "{\"name\":\"Alice\",\"email\":\"alice@example.com\"}"
```

### List users
```
curl http://localhost:8080/users
```

### Get user by id
```
curl http://localhost:8080/users/<uuid>
```

### Delete user by id
```
curl -X DELETE http://localhost:8080/users/<uuid>
```

## Contact
Rodrigo Machaca
- Email: Rodrigo.Machaca@jala.university
