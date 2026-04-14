package com.dogapi.utils;

import io.qameta.allure.Allure;
import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

import java.nio.charset.StandardCharsets;

public class AllureRestAssuredFilter implements Filter {

    @Override
    public Response filter(FilterableRequestSpecification requestSpec,
                           FilterableResponseSpecification responseSpec,
                           FilterContext ctx) {

        String request = requestSpec.getMethod() + " " + requestSpec.getURI();

        Allure.addAttachment(
                "Request",
                "text/plain",
                request,
                ".txt"
        );

        Response response = ctx.next(requestSpec, responseSpec);

        String responseBody = response.getBody().asPrettyString();

        Allure.addAttachment(
                "Response",
                "application/json",
                responseBody,
                ".json"
        );

        return response;
    }
}