package com.dogapi.tests;

import com.dogapi.config.ApiResponseSpecs;
import com.dogapi.config.BaseTest;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.junit.jupiter.api.Assertions.*;

@Epic("Dog API")
@Feature("Lista de Raças")
public class BreedsListTest extends BaseTest {

    @Test
    @Story("Listar todas as raças")
    @Description("Valida que a API retorna todas as raças com contrato e estrutura válidos")
    @DisplayName("Deve retornar todas as raças com contrato e estrutura válidos")
    void shouldReturnAllBreedsWithValidContractAndStructure() {

        Response response = dogApiClient
                .getAllBreeds()
                .then()
                .spec(ApiResponseSpecs.success200())
                .body(matchesJsonSchemaInClasspath("schemas/breeds-list-success.json"))
                .extract()
                .response();

        Map<String, List<String>> breeds = response.jsonPath().getMap("message");

        assertNotNull(breeds, "Esperado que o objeto de raças não seja nulo");
        assertTrue(breeds.containsKey("hound"), "Esperado que a raça 'hound' exista na resposta");

        breeds.values().forEach(subBreeds ->
                assertNotNull(subBreeds, "A lista de sub-raças não deve ser nula")
        );
    }
}
