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

## Funcionalidades

- CRUD de endereços
- Integração com a API ViaCep para busca de endereços por CEP

## Endpoints

- **Listar Endereços**: `GET /api/v1/address`
- **Buscar Endereço por ID**: `GET /api/v1/address/{id}`
- **Salvar Endereço**: `POST /api/v1/address`
- **Atualizar Endereço por ID**: `PUT /api/v1/address/{id}`
- **Excluir Endereço por ID**: `DELETE /api/v1/address/{id}`

## Configuração do Banco de Dados

Certifique-se de que você tem o MySQL instalado e configurado. Atualize as configurações de banco de dados no arquivo
`application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/address_db
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.flyway.enabled=true
```

## Executando a Aplicação

1. Clone o repositório:
   ```bash
   git clone https://github.com/JulianeMaran32/my-projects.git
   ```

2. Navegue até o diretório do projeto:
   ```bash
   cd my-projects/address-api
   ```

3. Compile e execute o projeto:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

4. Acesse a aplicação em `http://localhost:8081/api/v1/address`.

## Docker

Para construir e executar a aplicação usando Docker, siga os passos abaixo:

1. Construa a imagem Docker:
   ```bash
   docker build -t address-api .
   ```

2. Execute o container Docker:
   ```bash
   docker run -p 8081:8081 address-api
   ```

## Importando a Biblioteca de Exception Handling

Certifique-se de importar o jar da biblioteca de Exception Handling no seu projeto. Adicione a dependência no `pom.xml`:

```xml

<dependency>
    <groupId>br.com.juhmaran</groupId>
    <artifactId>exception-handling</artifactId>
    <version>1.0.0</version>
</dependency>
```

## Licença

Este projeto está licenciado sob a [MIT License](LICENSE).

## Autora

Juliane Maran

## Contato

- **Email**: [Juliane](mailto:julianemaran@gmail.com)
- **LinkedIn**: [Juliane Maran](https://www.linkedin.com/in/juliane-maran-168b73133)
- **GitHub**: [JulianeMaran32](https://github.com/JulianeMaran32)
