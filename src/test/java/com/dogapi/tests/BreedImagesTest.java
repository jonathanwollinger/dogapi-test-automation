package com.dogapi.tests;

import com.dogapi.config.ApiResponseSpecs;
import com.dogapi.config.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.junit.jupiter.api.Assertions.*;

@Epic("Dog API")
@Feature("Imagens por raça")
public class BreedImagesTest extends BaseTest {

    @Test
    @Story("Raça válida")
    @DisplayName("Deve retornar imagens para uma raça válida com contrato válido")
    void shouldReturnImagesForValidBreed() {

        Response response = dogApiClient
                .getBreedImages("hound")
                .then()
                .spec(ApiResponseSpecs.success200())
                .body(matchesJsonSchemaInClasspath("schemas/breed-images-success.json"))
                .extract()
                .response();

        List<String> images = response.jsonPath().getList("message");

        assertNotNull(images);
        assertFalse(images.isEmpty());

        images.forEach(url ->
                assertTrue(url.contains("dog.ceo"))
        );
    }

    @Test
    @Story("Raça inválida")
    @DisplayName("Deve retornar erro para raça inexistente com contrato válido")
    void shouldReturnErrorForInvalidBreed() {

        dogApiClient.getBreedImages("raca-invalida")
                .then()
                .spec(ApiResponseSpecs.error404())
                .body(matchesJsonSchemaInClasspath("schemas/breed-images-error.json"));
    }
}
