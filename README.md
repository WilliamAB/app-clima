
# WAB API Clima!
Projeto de uma API de consulta de previsões do tempo, consumindo a API de [previsão de 5 dias](https://openweathermap.org/forecast5) e a [Geocoding API](https://openweathermap.org/forecast5#geocoding) da [OpenWeather](https://openweathermap.org/).

## Sobre a API

A API foi desenvolvida com Java, Spring Boot e Spring Framework.
A documentação completa com os endpoints, parâmetros e métodos (GET, POST, DELETE) pode ser consultada no seguinte endereço [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html) com a aplicação rodando.

## Como rodar
- Instalar [PostgreSQL](https://www.postgresql.org/download/) ou um banco de dados de sua preferência;
- Criar uma `database`, por padrão o nome já configurado na aplicação é `app_clima`:
    - `CREATE DATABASE app_clima;`
- Clonar o projeto:
  `git clone https://github.com/WilliamAB/app-clima.git`
- Configurar o arquivo `application.resources` dentro de `src/main/resources`:
    - URL de acesso ao banco (conforme banco instalado e nome do schema criado): `spring.datasource.url=jdbc:postgresql://localhost:5432/app_clima`;
    - Usuário do banco de dados: `spring.datasource.username=postgres`
    - Senha do usuário do banco: `spring.datasource.password=senha`
    - Dialeto do banco de dados (conforme banco instalado): `spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect`
- Executar a aplicação a partir do seguinte comando dentro do diretório clonado:
  `mvnw spring-boot:run`
- Acesse [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html) para consultar a documentação da API e poder realizar os testes de requisições.

## Como testar
Recomendo o uso do [Postman](https://www.postman.com/downloads/) para testar as requisições da API.

[![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/5509632-03fbf9d7-000b-487c-bfb8-7a398daafedf?action=collection%2Ffork&collection-url=entityId%3D5509632-03fbf9d7-000b-487c-bfb8-7a398daafedf%26entityType%3Dcollection%26workspaceId%3D1ea55c7b-1bab-483b-8c3e-5b8f8d5aad28)