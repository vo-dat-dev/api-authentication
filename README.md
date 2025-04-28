# Spring Boot Authentication Service

This project is a Spring Boot application that provides user authentication and management functionality.

## Project Structure

The project is organized as follows:

- **Main Application**: `service.market.authentication.AuthenticationApplication`
- **Controllers**: `UserController` (exposes REST endpoints for user management)
- **Services**: `UserService` and `UserServiceImpl` (business logic for user operations)
- **Entities**: `User` (JPA entity for user data)
- **DTOs**: `CreateUserDTO` and `UpdateUserDTO` (data transfer objects for user creation and updates)
- **Repositories**: `UserRepository` (Spring Data JPA repository for user persistence)
- **Configuration**: `SecurityConfig` (Spring Security configuration)

## Setup

1. **Prerequisites**:

   - Java 17
   - PostgreSQL database

2. **Database Configuration**:
   Update the following in `src/main/resources/application.yml`:

   ```yaml
   spring:
     datasource:
       url: jdbc:postgresql://localhost:5432/userdb
       username: postgres
       password: password
   ```

3. **Build and Run**:
   ```bash
   ./gradlew bootRun
   ```

## API Endpoints

The following endpoints are available:

- **GET /api/v1/user/{userId}**: Retrieve user details by ID
- **POST /api/v1/user/add**: Create a new user
- **PUT /api/v1/user/update**: Update an existing user
- **DELETE /api/v1/user/{userId}**: Delete a user by ID

## Security

The application uses Spring Security for authentication. By default, all endpoints require authentication. The security configuration can be found in `SecurityConfig.java`.

## Documentation

API documentation is available via Swagger UI at `http://localhost:8083/swagger-ui.html` when the application is running.

## Dependencies

- Spring Boot
- Spring Security
- Spring Data JPA
- PostgreSQL
- Lombok
- Swagger (OpenAPI 3.0)
