package com.cristian.api.test.utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class ApiUtils {

    /**
     * Creates a basic request specification with common headers
     */
    public static RequestSpecification createRequestSpec() {
        return RestAssured.given()
                .contentType("application/json")
                .accept("application/json");
    }

    /**
     * Creates a request specification with custom headers
     */
    public static RequestSpecification createRequestSpecWithHeaders(Map<String, String> headers) {
        RequestSpecification spec = createRequestSpec();
        headers.forEach(spec::header);
        return spec;
    }

    /**
     * Logs request and response details
     */
    public static void logRequestResponse(Response response) {
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response Time: " + response.getTime() + "ms");
        System.out.println("Response Body: " + response.getBody().asString());
    }

    /**
     * Validates response time is within acceptable limit
     */
    public static boolean isResponseTimeAcceptable(Response response, long maxTimeInMs) {
        return response.getTime() <= maxTimeInMs;
    }
}
