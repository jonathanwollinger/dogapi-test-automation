package com.dogapi.tests;

import com.dogapi.config.ApiResponseSpecs;
import com.dogapi.config.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;

public class ListBreedsTest extends BaseTest {

    @Test
    @DisplayName("Deve retornar todas as racas com status de sucesso")
    void deveListarTodasAsRacasComSucesso() {

        dogApiClient.getAllBreeds()
                .then()
                .spec(ApiResponseSpecs.success200())
                .body("status", equalTo("success"))
                .body("message", not(empty()));
    }
}