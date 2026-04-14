package com.dogapi.client;

import com.dogapi.utils.Endpoints;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class DogApiClient {

    private final RequestSpecification request;

    public DogApiClient(RequestSpecification request) {
        this.request = request;
    }

    public Response getAllBreeds() {
        return given()
                .spec(request)
                .when()
                .get(Endpoints.LIST_ALL_BREEDS);
    }

    public Response getBreedImages(String breed) {
        return given()
                .spec(request)
                .pathParam("breed", breed)
                .when()
                .get(Endpoints.BREED_IMAGES);
    }

    public Response getRandomImage() {
        return given()
                .spec(request)
                .when()
                .get(Endpoints.RANDOM_IMAGE);
    }
}