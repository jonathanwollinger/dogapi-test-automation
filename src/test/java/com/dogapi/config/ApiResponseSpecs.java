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

    public static ResponseSpecification error404() {
        return new ResponseSpecBuilder()
                .expectStatusCode(404)
                .expectContentType(ContentType.JSON)
                .expectBody("message", notNullValue())
                .build();
    }

    private ApiResponseSpecs() {}
}
