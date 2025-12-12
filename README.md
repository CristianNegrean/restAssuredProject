# RestAssured + Cucumber API Test Framework

This is a comprehensive API testing framework that combines RestAssured for API testing and Cucumber for BDD-style test specifications.

## Features

- **RestAssured**: Powerful library for testing REST APIs
- **Cucumber**: BDD framework for writing human-readable test scenarios
- **JUnit 5**: Modern testing framework
- **Maven**: Dependency and build management
- **JSON Processing**: Support for JSON request/response handling
- **AssertJ**: Fluent assertions for better test readability

## Prerequisites

- Java 11 or higher
- Maven 3.6 or higher

## Project Structure

```
restAssuredProject/
├── src/
│   └── test/
│       ├── java/
│       │   └── com/
│       │       └── cristian/
│       │           └── api/
│       │               └── test/
│       │                   ├── runner/
│       │                   │   └── TestRunner.java
│       │                   ├── stepdefinitions/
│       │                   │   └── ApiStepDefinitions.java
│       │                   └── utils/
│       │                       └── ApiUtils.java
│       └── resources/
│           ├── features/
│           │   └── api_tests.feature
│           └── junit-platform.properties
├── pom.xml
└── README.md
```

## Setup

1. Clone the repository:
```bash
git clone https://github.com/CristianNegrean/restAssuredProject.git
cd restAssuredProject
```

2. Install dependencies:
```bash
mvn clean install -DskipTests
```

## Running Tests

### Run all tests:
```bash
mvn test
```

### Run tests with specific tags:
```bash
mvn test -Dcucumber.filter.tags="@smoke"
```

### Run only GET request tests:
```bash
mvn test -Dcucumber.filter.tags="@get"
```

### Run only POST request tests:
```bash
mvn test -Dcucumber.filter.tags="@post"
```

### Exclude work-in-progress tests:
```bash
mvn test -Dcucumber.filter.tags="not @wip"
```

**Note:** The sample tests use JSONPlaceholder (a free online REST API). Ensure you have internet connectivity when running tests.

## Test Reports

After running tests, you can find the reports in:
- HTML Report: `target/cucumber-reports/cucumber.html`
- JSON Report: `target/cucumber-reports/cucumber.json`

## Writing New Tests

### 1. Create a feature file in `src/test/resources/features/`:

```gherkin
Feature: My API Test
  Scenario: Test my API endpoint
    Given the API endpoint is "https://api.example.com/endpoint"
    When I send a GET request
    Then the response status code should be 200
```

### 2. Available Step Definitions:

- `Given the API endpoint is "URL"`
- `Given the request body is:` (followed by JSON in docstring)
- `When I send a GET request`
- `When I send a POST request`
- `When I send a PUT request`
- `When I send a DELETE request`
- `Then the response status code should be {int}`
- `And the response should contain "field"`
- `And the response field "field" should be "value"`
- `And the response should be a list with more than {int} items`

## Example API Tests

The project includes sample tests using JSONPlaceholder API (https://jsonplaceholder.typicode.com):

- **GET requests**: Retrieve posts and users
- **POST requests**: Create new posts
- **PUT requests**: Update existing posts
- **DELETE requests**: Delete posts
- **Field validation**: Verify response structure

## Technologies Used

| Technology | Version | Purpose |
|------------|---------|---------|
| RestAssured | 5.3.2 | API Testing |
| Cucumber | 7.14.0 | BDD Framework |
| JUnit 5 | 5.10.0 | Test Runner |
| AssertJ | 3.24.2 | Assertions |
| Gson | 2.10.1 | JSON Processing |

## Contributing

1. Fork the repository
2. Create your feature branch
3. Commit your changes
4. Push to the branch
5. Create a Pull Request

## License

This project is open source and available for learning purposes.