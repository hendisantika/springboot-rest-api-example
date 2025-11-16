# Spring Boot REST API Example

A multi-module Spring Boot REST API project demonstrating modern Java development practices.

## Technology Stack

- **Java 21**
- **Spring Boot 3.5.7**
- **Spring Security 6.x**
- **Spring Data JPA**
- **Hibernate 6.x**
- **H2 Database** (for development/testing)
- **Flyway** (database migrations)
- **SpringDoc OpenAPI 2.7.0** (API documentation)
- **Lombok**
- **JUnit 5** (testing)
- **Mockito** (mocking)

## Project Structure

This is a multi-module Maven project with the following modules:

```
springboot-rest-api-example/
├── hendisantika-parent/     # Parent module with common configuration
├── hendisantika-api/        # REST API module with controllers, models, repositories
└── hendisantika-auth/       # Authentication and user management module
```

### hendisantika-api Module

Main REST API module containing:

- **Models**: Person, Ensemble, Event, Venue, Audition, Skill
- **Repositories**: JPA repositories for data access
- **Services**: Business logic layer
- **Controllers**: REST endpoints
- **Config**: Security and Swagger/OpenAPI configuration

### hendisantika-auth Module

Authentication module containing:

- **User management**
- **Registration with email confirmation**
- **Spring Security configuration**

## Features

- RESTful API design
- Database migration management with Flyway
- API documentation with OpenAPI/Swagger UI
- Spring Security integration
- JPA entity relationships (One-to-Many, Many-to-Many)
- Pagination support for REST endpoints
- Unit and integration testing

## Getting Started

### Prerequisites

- Java 21 or higher
- Maven 3.6+

### Build

```bash
mvn clean install
```

### Run Tests

```bash
mvn test
```

### Run Application

```bash
# Run the API module
cd hendisantika-api
mvn spring-boot:run

# Or run the Auth module
cd hendisantika-auth
mvn spring-boot:run
```

### API Documentation

After starting the application, access the Swagger UI at:

- http://localhost:8080/swagger-ui.html

OpenAPI JSON specification:

- http://localhost:8080/v3/api-docs

## Configuration

Application properties can be configured in:

- `hendisantika-api/src/main/resources/application.yml`
- `hendisantika-auth/src/main/resources/application.yml`

## Database

The project uses H2 in-memory database by default. Database schema is managed by Flyway migrations located in:

- `hendisantika-api/src/main/resources/db/migration/`
- `hendisantika-auth/src/main/resources/db/migration/`

Access H2 console at: http://localhost:8080/h2-console

## Docker Support

Docker configuration is available in the project. Refer to Docker files for containerization.

## Author

**Hendi Santika**

- Email: hendisantika@gmail.com
- Telegram: @hendisantika34

## License

This project is open source.

## Recent Updates

- Upgraded to Spring Boot 3.5.7
- Migrated to Jakarta EE 9+ namespace
- Updated to Spring Security 6.x
- Replaced Springfox Swagger with SpringDoc OpenAPI
- Upgraded to JUnit 5
- Hibernate 6.x with identity generation strategy
- Updated all repositories to use JpaRepository
