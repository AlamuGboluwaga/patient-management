# Payment Service Module

A Spring Boot microservice designed to handle payment operations within the patient management system.

## Overview

The Payment Service is responsible for:
- Processing payments from patients
- Managing payment records and history
- Tracking payment status (PENDING, COMPLETED, FAILED)
- Supporting multiple payment methods
- Integration with the patient management system

## Architecture

### Project Structure

```
payment-service/
├── src/
│   ├── main/
│   │   ├── java/com/elroi/paymentservice/
│   │   │   ├── Controllers/          # REST API endpoints
│   │   │   ├── model/                # JPA Entity classes
│   │   │   ├── repository/           # Data access layer
│   │   │   ├── service/              # Business logic layer
│   │   │   ├── dto/                  # Data transfer objects
│   │   │   ├── mapper/               # Object mapping utilities
│   │   │   ├── securityConfig/       # Security configuration
│   │   │   └── PaymentServiceApplication.java
│   │   └── resources/
│   │       ├── application.yml       # Main configuration
│   │       └── application-dev.yml   # Development configuration
│   └── test/
├── pom.xml                            # Maven configuration
├── mvnw & mvnw.cmd                   # Maven wrapper
└── HELP.md                            # Quick start guide
```

## Technologies

- **Java 17** - Latest LTS version
- **Spring Boot 3.3.2** - Framework foundation
- **Spring Data JPA** - ORM and database access
- **Spring Security** - Security framework
- **Spring Actuator** - Health checks and monitoring
- **PostgreSQL/SQL Server** - Supported databases
- **Lombok** - Reduce boilerplate code
- **SpringDoc OpenAPI** - API documentation (Swagger)
- **Maven** - Build tool

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.6+ (or use the included Maven wrapper)
- PostgreSQL or SQL Server (or H2 for development)

### Build

```bash
cd payment-service
./mvnw clean package
```

Or on Windows:
```bash
mvnw.cmd clean package
```

### Run

```bash
./mvnw spring-boot:run
```

Or with environment profile:
```bash
./mvnw spring-boot:run -Dspring-boot.run.arguments="--spring.profiles.active=dev"
```

The service will start on **http://localhost:8082**

## API Endpoints

### Base URL
```
http://localhost:8082/payment/api/payment
```

### Available Endpoints

- `GET /health` - Service health check
- `POST /` - Create a new payment
- `GET /{id}` - Get payment by ID
- `PUT /{id}` - Update payment
- `DELETE /{id}` - Delete payment
- `GET /patient/{patientId}` - Get payments by patient
- `GET /status/{status}` - Get payments by status

### Swagger UI

Access the interactive API documentation at:
```
http://localhost:8082/payment/swagger-ui.html
```

OpenAPI spec:
```
http://localhost:8082/payment/v3/api-docs
```

## Configuration

### Environment Variables

```bash
# Database Configuration
DB_URL=jdbc:postgresql://localhost:5432/payment_db
DB_USERNAME=postgres
DB_PASSWORD=your_password
DB_DRIVER=org.postgresql.Driver

# Server Configuration
SERVER_PORT=8082
```

### application.yml

```yaml
spring:
  application:
    name: payment-service
  jpa:
    hibernate:
      ddl-auto: update
  datasource:
    url: ${DB_URL}
    username: ${DB_USERNAME}
    password: ${DB_PASSWORD}

server:
  port: 8082
  servlet:
    context-path: /payment
```

## Database Schema

### Payments Table

```sql
CREATE TABLE payments (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    patient_id BIGINT NOT NULL,
    amount DECIMAL(19, 2) NOT NULL,
    status VARCHAR(50) NOT NULL,
    payment_method VARCHAR(50),
    transaction_reference VARCHAR(255) UNIQUE,
    description TEXT,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    INDEX (patient_id),
    INDEX (status),
    INDEX (transaction_reference)
);
```

## Core Components

### Payment Model
- Represents a payment transaction
- Stores payment details and status
- Auto-tracks creation and update timestamps

### PaymentService
- Core business logic for payment operations
- CRUD operations on payments
- Query payments by patient or status

### PaymentRepository
- Spring Data JPA interface
- Database access for payment entities
- Custom query methods

### PaymentMapper
- Converts between Payment entities and DTOs
- Encapsulates data transformation logic

### SecurityConfig
- Configures Spring Security
- Manages API security and authentication
- Exempts health and Swagger endpoints

## Development Workflow

1. **Setup Database**
   ```bash
   # For PostgreSQL
   createdb payment_db
   ```

2. **Configure Environment**
   - Create `.env` file in the root directory
   - Set database connection details

3. **Run in Development Mode**
   ```bash
   ./mvnw spring-boot:run -Dspring-boot.run.arguments="--spring.profiles.active=dev"
   ```

4. **Access Swagger UI**
   - Open http://localhost:8082/payment/swagger-ui.html
   - Test API endpoints interactively

## Testing

Run tests using Maven:

```bash
./mvnw test
```

Run with coverage:

```bash
./mvnw clean test jacoco:report
```

## Monitoring

The service includes Spring Boot Actuator endpoints for monitoring:

```
http://localhost:8082/payment/actuator/health
http://localhost:8082/payment/actuator/metrics
```

## Integration with Patient Service

The Payment Service is designed to work alongside the Patient Service:

- **Patient Service**: Port 8081
- **Payment Service**: Port 8082

Communication between services can be established via REST API calls or message queues.

## Common Issues

### Port Already in Use
```bash
# Change the port in application.yml or via environment
./mvnw spring-boot:run -Dspring-boot.run.arguments="--server.port=8083"
```

### Database Connection Failed
- Verify database is running
- Check DB_URL, DB_USERNAME, DB_PASSWORD environment variables
- Ensure database user has proper permissions

### CORS Issues
- Check security configuration in `SecurityConfig.java`
- Add CORS configuration if needed

## Deployment

### Docker Support

Create a `Dockerfile`:

```dockerfile
FROM eclipse-temurin:17-jre-slim
COPY target/payment-service-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
```

Build and run:

```bash
docker build -t payment-service .
docker run -p 8082:8082 payment-service
```

### Kubernetes

Deploy using Kubernetes manifests (to be created)

## Logging

Logging is configured in `application.yml`:

```yaml
logging:
  level:
    root: INFO
    com.elroi: DEBUG
  pattern:
    console: "%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n"
```

## Contributing

When contributing to this module:

1. Follow Java naming conventions
2. Add Javadoc for public methods
3. Write unit tests for new features
4. Update this README if adding new features
5. Ensure code compiles: `./mvnw clean compile`

## Resources

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [Spring Security](https://spring.io/projects/spring-security)
- [SpringDoc OpenAPI](https://springdoc.org/)
- [Maven Documentation](https://maven.apache.org/)

## Support

For issues or questions:
- Check existing documentation
- Review logs in the console
- Check health endpoint: `/payment/actuator/health`

## License

This project is part of the patient-management system.
