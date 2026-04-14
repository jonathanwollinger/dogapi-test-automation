package com.dogapi.tests;

import com.dogapi.config.ApiResponseSpecs;
import com.dogapi.config.BaseTest;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.junit.jupiter.api.Assertions.*;

public class BreedsRandomImageTest extends BaseTest {

    @Test
    @DisplayName("Deve retornar uma imagem aleatória com contrato válido")
    void deveRetornarImagemAleatoriaComContratoValido() {

        Response response = dogApiClient
                .getRandomImage()
                .then()
                .spec(ApiResponseSpecs.success200())
                .body(matchesJsonSchemaInClasspath("schemas/breeds-random-image-success.json"))
                .extract()
                .response();

        String imageUrl = response.jsonPath().getString("message");

        assertNotNull(imageUrl, "Esperado que a URL da imagem não seja nula");
    }
}