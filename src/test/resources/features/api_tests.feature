Feature: API Testing with RestAssured
  As a tester
  I want to test REST APIs
  So that I can verify API functionality

  @smoke @get
  Scenario: Verify GET request returns successful response
    Given the API endpoint is "https://jsonplaceholder.typicode.com/posts/1"
    When I send a GET request
    Then the response status code should be 200
    And the response should contain "userId"
    And the response should contain "id"
    And the response should contain "title"

  @smoke @get
  Scenario: Verify GET request for all posts
    Given the API endpoint is "https://jsonplaceholder.typicode.com/posts"
    When I send a GET request
    Then the response status code should be 200
    And the response should be a list with more than 0 items

  @post
  Scenario: Verify POST request creates a new resource
    Given the API endpoint is "https://jsonplaceholder.typicode.com/posts"
    And the request body is:
      """
      {
        "title": "Test Post",
        "body": "This is a test post",
        "userId": 1
      }
      """
    When I send a POST request
    Then the response status code should be 201
    And the response should contain "id"
    And the response field "title" should be "Test Post"

  @put
  Scenario: Verify PUT request updates a resource
    Given the API endpoint is "https://jsonplaceholder.typicode.com/posts/1"
    And the request body is:
      """
      {
        "id": 1,
        "title": "Updated Title",
        "body": "Updated body",
        "userId": 1
      }
      """
    When I send a PUT request
    Then the response status code should be 200
    And the response field "title" should be "Updated Title"

  @delete
  Scenario: Verify DELETE request removes a resource
    Given the API endpoint is "https://jsonplaceholder.typicode.com/posts/1"
    When I send a DELETE request
    Then the response status code should be 200

  @validation
  Scenario: Verify response contains expected fields
    Given the API endpoint is "https://jsonplaceholder.typicode.com/users/1"
    When I send a GET request
    Then the response status code should be 200
    And the response should contain "id"
    And the response should contain "name"
    And the response should contain "email"
    And the response should contain "address"
