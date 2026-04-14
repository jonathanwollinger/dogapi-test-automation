package com.dogapi.config;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.Matchers.*;

public final class ApiResponseSpecs {

    public static ResponseSpecification success200() {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .expectResponseTime(lessThan(3000L))
                .expectBody("message", notNullValue())
                .build();
    }

    private ApiResponseSpecs() {}
}