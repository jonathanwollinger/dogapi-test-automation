package com.dogapi.tests;

import com.dogapi.config.ApiResponseSpecs;
import com.dogapi.config.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;

public class BreedsRandomImageTest extends BaseTest {

    @Test
    @DisplayName("Deve retornar uma imagem aleatoria de cachorro com sucesso")
    void deveRetornarImagemAleatoria() {

        dogApiClient.getRandomImage()
                .then()
                .spec(ApiResponseSpecs.success200())
                .body("status", equalTo("success"))
                .body("message", allOf(
                        not(blankOrNullString()),
                        startsWith("https://"),
                        containsString("dog.ceo"),
                        matchesRegex(".*\\.(jpg|jpeg|png)$")
                ));
    }
}