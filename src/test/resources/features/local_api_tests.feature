@wip
Feature: Local API Testing Examples
  These tests are marked as @wip to show framework structure
  They would normally connect to real APIs when network is available

  @smoke @example
  Scenario: Example GET request test structure
    Given the API endpoint is "https://api.example.com/data"
    When I send a GET request
    Then the response status code should be 200
    And the response should contain "data"

  @example
  Scenario: Example POST request test structure  
    Given the API endpoint is "https://api.example.com/create"
    And the request body is:
      """
      {
        "name": "Test Item",
        "value": "Test Value"
      }
      """
    When I send a POST request
    Then the response status code should be 201
