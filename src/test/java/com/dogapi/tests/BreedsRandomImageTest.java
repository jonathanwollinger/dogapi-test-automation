package com.dogapi.tests;

import com.dogapi.config.ApiResponseSpecs;
import com.dogapi.config.BaseTest;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Epic("Dog API")
@Feature("Imagem Aleatória")
public class BreedsRandomImageTest extends BaseTest {

    @Test
    @Story("Obter imagem aleatória")
    @Description("Valida que a API retorna uma imagem aleatória com contrato válido")
    @DisplayName("Deve retornar uma imagem aleatória com contrato válido")
    void shouldReturnRandomImageWithValidContract() {

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
