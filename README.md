API da DearPet -
A DearPet é uma API RESTful para gerenciar animais de estimação e seus proprietários, desenvolvida com o Spring Boot. Essa API permite que você gerencie animais de estimação, proprietários de animais de estimação (pessoas físicas e jurídicas) e profissionais que prestam serviços para animais de estimação.

Tecnologias usadas:

Java 21
Spring Boot 3.4.4
Spring Data JPA
Spring HATEOAS
Spring Boot DevTools
MySQL (Produção)
Flyway (Migração de banco de dados)
SpringDoc OpenAPI (Documentação da API)
Hibernate Validator
Documentação da API: Quando o aplicativo estiver em execução, você poderá acessar a documentação da API em:

Swagger UI: - OpenAPI JSON: http://localhost:8080/v1/swagger-ui/index.html
Produção (MySQL) Para usar o MySQL na produção, atualize o arquivo application.properties ou application.yml com suas credenciais do MySQL:

spring.datasource.url=jdbc:mysql://localhost:3306/dearpet
spring.datasource.username=seu_nome_de_usuário
spring.datasource.password=sua_senha
spring.datasource.driver-class-name=com.mysql.cj.jdbc. Driver
Endpoints da API:

Pets:

GET /api/pets - Lista todos os pets
GET /api/pets/{id} - Obtém o pet por ID
POST /api/pets - Cria um novo pet
PUT /api/pets/{id} - Atualiza um pet
DELETE /api/pets/{id} - Delete a pet
Pessoas:

GET /api/pessoas - Lista todas as pessoas
GET /api/pessoas/{id} - Obtém o pessoa por ID
POST /api/pessoas - Cria uma nova pessoa
PUT /api/pessoas/{id} - Atualiza uma pessoa
DELETE /api/pessoas/{id} - Deleta uma pessoa
Pessoas-Físicas

GET /api/pessoas-fisicas - Lista todas as pessoas-fisicas
GET /api/pessoas-fisicas/{id} - Obter a pessoa-física por ID
POST /api/pessoas-fisicas - Criar uma nova pessoa-física
PUT /api/pessoas-fisicas/{id} - Atualiza uma pessoa-física
DELETE /api/pessoas-fisicas/{id} - Deleta uma pessoa-fisica
Pessoas-Jurídicas

GET /api/pessoas-juridicas - Lista todas as pessoas-juridicas
GET /api/pessoas-juridicas/{id} - Obter a pessoa-juridica por ID
POST /api/pessoas-juridicas - Criar uma nova entidade jurídica
PUT /api/pessoas-juridicas/{id} - Atualizar uma entidade jurídica
DELETE /api/pessoas-juridicas/{id} - Deleta uma pessoa-juridica
Profissionais

GET /api/profissionais - Listar todos os profissionais
GET /api/profissionais/{id} - Obter profissional por ID
POST /api/profissionais - Criar um novo profissional
PUT /api/profissionais/{id} - Atualizar um profissional
DELETE /api/profissionais/{id} - Excluir um profissional
