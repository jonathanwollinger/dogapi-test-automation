# Dog API Test Automation

Projeto de automação de testes para a API pública Dog API, desenvolvido com foco em boas práticas de engenharia de qualidade, organização em camadas e escalabilidade.

---

## Objetivo

Validar os endpoints da Dog API garantindo:

- Confiabilidade das respostas
- Cobertura de cenários positivos e negativos
- Validação de contrato (JSON Schema)
- Estrutura escalável para automação de testes

---

## 🧰 Stack

- Java 17  
- RestAssured  
- JUnit 5  
- Allure Reports  

---

## Estrutura do Projeto

```text
src/test/java/com/dogapi
 ├── config        # Configuração base dos testes (BaseTest)
 ├── client        # Camada de comunicação com a API (DogApiClient)
 ├── utils         # Utilitários (ex: Endpoints)
 ├── tests         # Casos de teste
 └── models        # (futuro) DTOs

src/test/resources
 ├── schemas       # JSON Schemas para validação de contrato
 └── environments  # Configuração de ambientes
```

---

## Como executar os testes

```bash
mvn clean test
```

---

## Relatórios com Allure

```bash
mvn allure:serve
```

---

## Boas práticas aplicadas

- Separação de responsabilidades (config, client, tests)
- Reutilização de RequestSpecification
- Encapsulamento de chamadas HTTP (Client)
- Remoção de hardcoded (Endpoints)
- Estrutura preparada para escalabilidade

---

## Autor

Projeto desenvolvido como parte de preparação e demonstração técnica para vaga de QA Sênior.
