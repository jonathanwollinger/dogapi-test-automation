package com.dogapi.config;

import com.dogapi.client.DogApiClient;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

    protected DogApiClient dogApiClient;

    private static final String BASE_URI = "https://dog.ceo/api";

    @BeforeEach
    protected void setup() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        dogApiClient = new DogApiClient(buildRequest());
    }

    private RequestSpecification buildRequest() {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .addFilter(new AllureRestAssured())
                .build();
    }
}
