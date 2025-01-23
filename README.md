# Projeto-Java-Dslist

Este é um projeto de aprendizado para criar uma API RESTful utilizando o framework Spring Boot. O objetivo é explorar as ferramentas do ecossistema Spring e entender conceitos fundamentais para o desenvolvimento de APIs em Java.

# Ferramentas e Tecnologias Utilizadas 🛠️

•Java 17 e 21: Linguagem de programação utilizada no projeto.

•Spring Boot 3.4.1: Framework principal para a construção da aplicação.

•Maven: Ferramenta de gerenciamento de dependências e build.

•H2 Database: Banco de dados em memória para testes e desenvolvimento.

•PostgreSQL: Banco de dados relacional para o ambiente de produção.

•Spring Data JPA: Para abstração e manipulação de dados.

•Spring Web: Para criação de endpoints REST.

•Spring Boot Starter Test: Para testes unitários e de integração.

•Postman: Para testar os endpoints da API.

•Spring Tool Suite (STS): IDE recomendada para desenvolvimento.

•Docker: Utilizado para gerar banco de dados de homologação.

# Modelo de domínio DSList

![Modelo de domínio DSList](https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/dslist-model.png)

# Como Configurar e Executar o Projeto 🚀

Pré-requisitos
JDK 17 ou 21 instalado.
Maven instalado.
Uma IDE para Java, como Spring Tool Suite (STS) ou IntelliJ IDEA.
Postman para testar os endpoints.

Passo a Passo

1.Clone o Repositório
  `git clone https://github.com/seu-usuario/seu-repositorio.git
   cd seu-repositorio`

2.Por padrão, o projeto utiliza o H2 Database para testes. Para depois mudar para PostgreSQL:
  Configure as credenciais no arquivo application-test.properties
  
```
# H2 Connection
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.username=sa
spring.datasource.password=

# H2 Client
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# Show SQL
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

3. Configure também o arquivo application.properties
   
```
spring.profiles.active=${APP_PROFILE:test}
spring.jpa.open-in-view=false

cors.origins=${CORS_ORIGINS:http://localhost:5173,http://localhost:3000}
```


4. Acesse o H2 Console (opcional)

URL: http://localhost:8080/h2-console

  Configurações:
  
  •JDBC URL: jdbc:h2:mem:testdb
  
  •Usuário: sa
  
  •Senha: (deixe vazio)

Obs. Docker

Caso prefira utilizar o Docker com PostGres logo no início basta utilizar o arquivo `docker-compose.yml` dentro de `./docker`.

Acesse pelo navegador depois que gerar a imagem e criei o banco *dslist* troque no application.properties para dev no lugar de test.

No application-dev.properties descomente essa parte

```
#spring.jpa.properties.jakarta.persistence.schema-generation.create-source=metadata
#spring.jpa.properties.jakarta.persistence.schema-generation.scripts.action=create
#spring.jpa.properties.jakarta.persistence.schema-generation.scripts.create-target=create.sql
#spring.jpa.properties.hibernate.hbm2ddl.delimiter=;
```

Dessa forma, ira gerar o arquivo *create.sql* na raiz do projeto, importe ou utilize dentro do pgadmin ou em qualquer outro SGBD.

Se não possuir o docker instale em usa máquina

# Testando com Postman 🧪
Crie uma coleção no Postman para organizar os endpoints.

Configure as requisições para apontar para http://localhost:8080.

Endpoints Padrão
```
GET /games
GET /lists
GET /games/:id
GET /lists/:id/games
```

# Autor 👨‍💻

•Davi

Estudante de Análise e Desenvolvimento de Sistemas.
