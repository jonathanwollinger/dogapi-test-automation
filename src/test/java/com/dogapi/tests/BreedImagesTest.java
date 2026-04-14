package com.dogapi.tests;

import com.dogapi.config.ApiResponseSpecs;
import com.dogapi.config.BaseTest;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.junit.jupiter.api.Assertions.*;

public class BreedImagesTest extends BaseTest {

    @Test
    @DisplayName("Deve retornar imagens para uma raça válida com contrato válido")
    void deveRetornarImagensParaRacaValida() {

        Response response = dogApiClient
                .getBreedImages("hound")
                .then()
                .spec(ApiResponseSpecs.success200())
                .body(matchesJsonSchemaInClasspath("schemas/breed-images-success.json"))
                .extract()
                .response();

        List<String> images = response.jsonPath().getList("message");

        assertNotNull(images, "Esperado que a lista de imagens não seja nula");
        assertFalse(images.isEmpty(), "Esperado que a lista de imagens contenha ao menos um item");

        images.forEach(url ->
                assertTrue(url.contains("dog.ceo"), "Esperado que a URL contenha o domínio dog.ceo")
        );
    }

    @Test
    @DisplayName("Deve retornar erro para raça inexistente com contrato válido")
    void deveRetornarErroParaRacaInvalida() {

        dogApiClient.getBreedImages("raca-invalida")
                .then()
                .spec(ApiResponseSpecs.error404())
                .body(matchesJsonSchemaInClasspath("schemas/breed-images-error.json"));
    }
}