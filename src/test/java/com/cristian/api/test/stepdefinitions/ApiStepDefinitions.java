package com.cristian.api.test.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static org.assertj.core.api.Assertions.assertThat;

public class ApiStepDefinitions {

    private String endpoint;
    private RequestSpecification request;
    private Response response;

    public ApiStepDefinitions() {
        RestAssured.baseURI = "";
    }

    @Given("the API endpoint is {string}")
    public void setApiEndpoint(String endpoint) {
        this.endpoint = endpoint;
        this.request = RestAssured.given()
                .contentType("application/json")
                .accept("application/json");
    }

    @Given("the request body is:")
    public void setRequestBody(String body) {
        this.request.body(body);
    }

    @When("I send a GET request")
    public void sendGetRequest() {
        response = request.when().get(endpoint);
    }

    @When("I send a POST request")
    public void sendPostRequest() {
        response = request.when().post(endpoint);
    }

    @When("I send a PUT request")
    public void sendPutRequest() {
        response = request.when().put(endpoint);
    }

    @When("I send a DELETE request")
    public void sendDeleteRequest() {
        response = request.when().delete(endpoint);
    }

    @Then("the response status code should be {int}")
    public void verifyStatusCode(int expectedStatusCode) {
        assertThat(response.getStatusCode())
                .as("Response status code")
                .isEqualTo(expectedStatusCode);
    }

    @And("the response should contain {string}")
    public void verifyResponseContainsField(String field) {
        String responseBody = response.getBody().asString();
        assertThat(responseBody)
                .as("Response body contains field: " + field)
                .contains("\"" + field + "\"");
    }

    @And("the response field {string} should be {string}")
    public void verifyResponseFieldValue(String field, String expectedValue) {
        String actualValue = response.jsonPath().getString(field);
        assertThat(actualValue)
                .as("Response field " + field + " value")
                .isEqualTo(expectedValue);
    }

    @And("the response should be a list with more than {int} items")
    public void verifyResponseIsList(int minItems) {
        int actualSize = response.jsonPath().getList("$").size();
        assertThat(actualSize)
                .as("Response list size")
                .isGreaterThan(minItems);
    }
}
