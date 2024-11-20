# API de Agenda de Endereços

## Descrição

Esta API é uma simples API de agenda de endereços que permite armazenar, recuperar, atualizar e excluir endereços. A API
utiliza o OpenFeign para obter dados de endereços de uma API externa (ViaCep).

## Endpoints

### GET /addresses

Este endpoint retorna uma lista de todos os endereços na agenda.

### GET /addresses/{id}

Este endpoint retorna um único endereço pelo seu ID.

### POST /addresses

Este endpoint cria um novo endereço.

### PUT /addresses/{id}

Este endpoint atualiza um endereço existente.

### DELETE /addresses/{id}

Este endpoint exclui um endereço pelo seu ID.

## Execução com Dockerfile e docker-compose

Para executar a aplicação usando Docker e Docker Compose, siga os passos abaixo:

1. Crie a imagem Docker:
   ```sh
   docker build -t address-api .
   ```

2. Inicie os containers com Docker Compose:
   ```sh
   docker-compose up
   ```

A API estará disponível em [http://localhost:8080](http://localhost:8080).

## Utilização de OpenFeign para obter os dados do endereço

A API utiliza o OpenFeign para se comunicar com a API externa ViaCep e obter dados de endereços. O OpenFeign facilita a
integração com serviços RESTful externos.

## Utilização de API externa (ViaCep)

A API utiliza a API externa ViaCep para obter informações de endereços com base no CEP fornecido. Para mais informações
sobre a API ViaCep, visite [https://viacep.com.br](https://viacep.com.br).

## Documentação da API

A documentação da API está disponível em [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html).

## Tecnologias

- Java 21
- Spring Boot
- OpenFeign
- Spring Data JPA
- MySQL Database
- Docker
- Docker Compose
- Swagger
- JUnit
- Mockito
- Lombok
- MapStruct
- Maven

## Perfis

### Ativando Perfil `local`

```sh
java -jar your-application.jar --spring.profiles.active=local
```

### Ativando Perfil `prod`

```sh
java -jar your-application.jar --spring.profiles.active=prod
```


## Autor

- [Juliane Maran](mailto:julianemaran@gmail.com)

## Licença

Este projeto está licenciado sob a licença MIT - consulte o arquivo [LICENSE](LICENSE) para obter detalhes.

