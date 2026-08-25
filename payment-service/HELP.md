# Getting Started with Payment Service

This is a Spring Boot microservice module for handling payment operations in the patient management system.

## Technology Stack
- Java 17
- Spring Boot 3.3.2
- Spring Data JPA
- PostgreSQL / SQL Server
- Maven
- OpenAPI/Swagger for API documentation

## Building the Project

From the payment-service directory:

```bash
./mvnw clean package
```

## Running the Service

```bash
./mvnw spring-boot:run
```

Or with a specific profile:

```bash
./mvnw spring-boot:run -Dspring-boot.run.arguments="--spring.profiles.active=dev"
```

The service will start on port 8082 by default.

## API Documentation

Once the service is running, access the Swagger UI at:
- http://localhost:8082/payment/swagger-ui.html

## Project Structure

- `Controllers/` - REST Controllers
- `model/` - Entity classes
- `repository/` - Data access layer
- `service/` - Business logic
- `dto/` - Data Transfer Objects
- `mapper/` - Object mappers
- `securityConfig/` - Security configuration

## Environment Variables

Configure the following in your `.env` file or system environment:

- `DB_URL` - Database connection URL
- `DB_USERNAME` - Database username
- `DB_PASSWORD` - Database password
- `DB_DRIVER` - JDBC driver class name

## Additional Resources

- Spring Boot Documentation: https://spring.io/projects/spring-boot
- Spring Data JPA: https://spring.io/projects/spring-data-jpa
- SpringDoc OpenAPI: https://springdoc.org/
