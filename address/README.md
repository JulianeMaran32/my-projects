# REST API Address

Esta é uma API REST para gerenciamento de endereços, utilizando Spring Boot.

## Tecnologias Utilizadas

- **Java**
- **Spring Boot**
- **OpenFeign**: Para integração com a API ViaCep
- **ViaCep**: Para busca de endereços por CEP
- **Flyway**: Para migrações de banco de dados
- **MySQL**: Banco de dados relacional
- **Lombok**: Para reduzir o código boilerplate
- **MapStruct**: Para mapeamento de objetos
- **Docker**: Para containerização da aplicação
- **Docker Compose**: Para orquestração de containers

## Documentação

A documentação da API pode ser acessada através do Swagger, disponível em:
`http://localhost:8081/api/v1/swagger-ui/index.html`

## Execução

Para executar a aplicação, é necessário ter o Docker e o Docker Compose instalados.

1. Clone o repositório:

    ```bash
    git clone
    ```

2. Acesse o diretório do projeto:

    ```bash
    cd address
    ```

3. Execute o comando:

    ```bash
    docker-compose up
    ```

4. Acesse a documentação da API:

   `http://localhost:8081/api/v1/swagger-ui/index.html`

5. Para parar a execução, utilize o comando:

    ```bash
    docker-compose down
    ```

## Endpoints

### `GET /address/{id}`

Obter endereço por ID já cadastrado.

### `PUT /address/{id}`

Atualizar um endereço por ID já cadastrado.

### `DELETE /address/{id}`

Excluir um endereço por ID já cadastrado.

### `GET /address`

Listar todos os endereços cadastrados.

### `POST /address`

Cadastrar um novo endereço.

### `GET /address/user/{userId}`

Obter endereço por ID de Usuário.

### `GET /address/region`

Obter endereço por UF, Localidade e Logradouro.

## Autora

- **Juliane Maran**: [JulianeMaran32](https://github.com/JulianeMaran32/my-projects)

## Licença

Este projeto está licenciado sob a licença MIT - consulte o arquivo [LICENSE.md](LICENSE.md) para obter detalhes.
