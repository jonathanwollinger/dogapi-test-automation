# Dog API Test Automation

Projeto de automação de testes para a API pública Dog API, desenvolvido com foco em boas práticas de engenharia de qualidade, validação de contrato e escalabilidade.

![CI](https://github.com/jonathanwollinger/dogapi-test-automation/actions/workflows/api-tests.yml/badge.svg)

---

## Objetivo

Validar os endpoints da Dog API garantindo:

- Confiabilidade das respostas
- Cobertura de cenários positivos e negativos
- Validação de contrato (JSON Schema)
- Estrutura escalável para automação

---

## Stack

- Java 17
- RestAssured
- JUnit 5
- Allure Reports

---

## Pré-requisitos

- Java 17 instalado
- Maven 3.9 ou superior
- Git

---

## Como clonar o projeto

```bash
git clone https://github.com/jonathanwollinger/dogapi-test-automation.git
cd dogapi-test-automation
```

---

## Estrutura do Projeto

```
src/test/java/com/dogapi
 ├── config        # Configuração base dos testes
 ├── client        # Camada de comunicação com a API
 ├── utils         # Utilitários (ex: endpoints)
 └── tests         # Casos de teste

src/test/resources
 ├── schemas       # JSON Schemas (validação de contrato)
```

---

## Cobertura de Testes

### Listagem de raças
`GET /breeds/list/all`

- Validação de contrato (schema)
- Validação de estrutura dinâmica
- Verificação de dados esperados

---

### Imagens por raça
`GET /breed/{breed}/images`

#### Sucesso
- Lista de imagens válida
- URLs consistentes

#### Erro
- Retorno estruturado com status error
- Validação de contrato

---

### Imagem aleatória
`GET /breeds/image/random`

- Validação de contrato via schema
- Verificação de URL válida

---

## Como executar os testes

```bash
mvn clean test
```

---

## Gerar relatório Allure

```bash
mvn allure:serve
```
---

## Relatório de Testes

O relatório Allure pode ser acessado em:

https://jonathanwollinger.github.io/dogapi-test-automation/

---

## CI/CD

Pipeline automatizado com GitHub Actions:

- Execução automática em push e pull request nas branches develop e main
- Pipeline multi-stage (build → test → report)
- Geração e upload de artefatos (Allure e relatórios de teste)

---

## Boas práticas aplicadas

- Separação de responsabilidades (config, client, tests)
- Client desacoplado
- Validação de contrato com JSON Schema
- Testes sem redundância
- Organização por domínio
- Pipeline CI/CD estruturado

---

## Autor

Jonathan Wollinger  
QA Automation Engineer  
