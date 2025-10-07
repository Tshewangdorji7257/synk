# CI/CD Demo with Snyk Security Scanning

This is a Spring Boot demo application for demonstrating CI/CD practices with integrated security scanning using Snyk.

## Project Overview

- **Framework**: Spring Boot 3.1.2
- **Java Version**: 17
- **Build Tool**: Maven
- **Security Scanning**: Snyk

## Dependencies

- Spring Web
- JavaFaker (for generating random data)
- JaCoCo (for code coverage)

## Features

- REST API endpoints for generating fake data
- Health check endpoint
- Automated testing
- Security vulnerability scanning
- Code coverage reporting

## API Endpoints

- `GET /` - Welcome message
- `GET /user` - Generate random user data
- `GET /quote` - Generate random quote
- `GET /health` - Health check status

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.6+
- Git

### Running Locally

1. Clone the repository
2. Navigate to project directory
3. Run the application:

```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

### Testing

Run the test suite:

```bash
mvn test
```

### Building

Build the application:

```bash
mvn clean compile
```

## Security Scanning

This project uses **Snyk** for automated security vulnerability scanning in the CI/CD pipeline.

### Setup Snyk Integration

1. **Create a Snyk Account**: Visit [https://snyk.io](https://snyk.io) and sign up
2. **Generate API Token**: 
   - Go to Account Settings → Auth Token
   - Copy your API token
3. **Add GitHub Secret**:
   - In your repository, go to Settings → Secrets and Variables → Actions
   - Create a new secret named `SNYK_TOKEN`
   - Paste your Snyk API token as the value

### Security Features

- **Dependency Scanning**: Scans all Maven dependencies for known vulnerabilities
- **Code Scanning**: Analyzes source code for security issues
- **SARIF Integration**: Results appear in GitHub Security tab
- **Scheduled Scans**: Weekly automated security reviews
- **Vulnerability Monitoring**: Continuous monitoring of deployed applications

### Snyk Workflows

1. **Basic Security Scan** (`maven.yml`): Runs on every push/PR
2. **Comprehensive Security** (`comprehensive-security.yml`): Advanced scanning with multiple scan types

### Security Configuration

- **Severity Threshold**: Medium and above
- **Ignore Policies**: Configured in `.snyk` file
- **SARIF Upload**: Results integrated with GitHub Security
- **Monitoring**: Production dependencies tracked in Snyk dashboard

### Vulnerability Management

To ignore specific vulnerabilities, update the `.snyk` file:

```yaml
ignore:
  'SNYK-JAVA-EXAMPLE-1234567':
    - '*':
        reason: 'False positive - not exploitable in our context'
        expires: '2024-12-31T23:59:59.999Z'
```

### Security Badge

![Snyk Vulnerabilities](https://img.shields.io/snyk/vulnerabilities/github/yourusername/cicd-demo)

## Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Run tests and security scans
5. Submit a pull request

## License

This project is licensed under the MIT License.