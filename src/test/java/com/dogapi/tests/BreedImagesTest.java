package com.dogapi.tests;

import com.dogapi.config.ApiResponseSpecs;
import com.dogapi.config.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;

public class BreedImagesTest extends BaseTest {

    @Test
    @DisplayName("Deve retornar imagens para uma raca valida")
    void deveRetornarImagensParaRacaValida() {

        dogApiClient.getBreedImages("hound")
                .then()
                .spec(ApiResponseSpecs.success200())
                .body("status", equalTo("success"))
                .body("message", not(empty()))
                .body("message", instanceOf(java.util.List.class));
    }
}
