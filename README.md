<img src="./img/banner github.png"/> <br><br>

# BookStore Management API

Este projeto é uma API para gerenciamento de livros, autores, editoras e reviews. Foi construída usando **Java 21**, **Spring Data JPA**, **Spring Web**, **Lombok**, **PostgreSQL** e **Docker**.

## Tecnologias Utilizadas
<br>
<div align="center">
  <img width="50" />
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" height="50" alt="java logo"  />
  <img width="50" />
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original.svg" height="50" alt="spring logo"  />
  <img width="50" />
 <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/postgresql/postgresql-original.svg" height="50" alt="postgresql logo"  />
 <img width="50" />
 <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/docker/docker-original-wordmark.svg" height="60" alt="postgresql logo" />
          
</div>
<br>

- **Java 21**: Linguagem principal da aplicação.
- **Spring Boot**: Framework que facilita a criação da API REST.
  - **Spring Data JPA**: Para o mapeamento objeto-relacional com o JPA.
  - **Spring Web**: Para exposição dos endpoints REST.
- **Lombok**: Para reduzir o código boilerplate, como getters e setters.
- **PostgreSQL**: Banco de dados relacional utilizado.
- **Docker**: Para containerização da aplicação e do banco de dados.
  - **Docker Compose**: Para orquestração dos containers.

## Diagrama Entidade-Relacionamento (ERD)
![image](https://github.com/user-attachments/assets/41026058-f7a8-4c8f-8e3b-81e0f9213e65)

### O diagrama acima descreve o relacionamento entre as seguintes entidades:
- **Book** (Livro) possui uma relação *many-to-many* com **Author** (Autor), *one-to-many* com **Publisher** (Editora), e uma relação *one-to-one* com **Review** (Avaliação).

## Pré-requisitos

- **Docker** e **Docker Compose** instalados.
- **Java 21** (se não usar o Docker).
- **PostgreSQL** (se não usar o Docker).

## Como executar a aplicação

### Usando Docker Compose

Com o Docker Compose, a aplicação e o banco de dados serão configurados automaticamente.

1. Clone o repositório:
   ```bash
   git clone https://github.com/gabriellglrs/ebookstore.git
   cd ebookstore
   ````
 2. Execute o seguinte comando para iniciar a aplicação e o banco de dados:
````bash
docker-compose up --build
````
3. A API estará disponível em:
 ````
    http://localhost:8080/
````

### Executando localmente
- Instale o Java JDK 21
- Instale o PostgreSQL e configure o banco de dados conforme especificado no arquivo application.properties.

Compile e rode a aplicação usando Maven:


### Endpoints Principais
- GET /books: Retorna todos os livros.
- POST /books: Adiciona um novo livro.
- GET /authors: Retorna todos os autores.
- POST /authors: Adiciona um novo autor.
- GET /publishers: Retorna todas as editoras.
- POST /publishers: Adiciona uma nova editora.
- GET /reviews: Retorna todas as avaliações.
- POST /reviews: Adiciona uma nova avaliação.
Configuração do Banco de Dados
### A aplicação utiliza PostgreSQL para o armazenamento de dados. Se você estiver usando Docker, as credenciais e informações do banco de dados serão configuradas automaticamente.
````
Nome do Banco: ebookstore
Usuário: root
Senha: root
Host: localhost
Porta: 5433
````
### Configurações no Docker Compose
- Aqui está a configuração usada no arquivo docker-compose.yml:

````yaml
Copiar código
version: '3.8'

services:
  app:
    build: .
    container_name: java_app
    ports:
      - "8080:8080"
    environment:
      SPRING_DATASOURCE_URL: jdbc:postgresql://db:5432/ebookstore
      SPRING_DATASOURCE_USERNAME: root
      SPRING_DATASOURCE_PASSWORD: root
      SPRING_JPA_HIBERNATE_DDL_AUTO: update
      SPRING_JPA_PROPERTIES_HIBERNATE_DIALECT: org.hibernate.dialect.PostgreSQLDialect
    depends_on:
      - db

  db:
    image: postgres:latest
    container_name: postgres_db
    environment:
      POSTGRES_DB: ebookstore
      POSTGRES_USER: root
      POSTGRES_PASSWORD: root
    ports:
      - "5433:5432"
    volumes:
      - pgdata:/var/lib/postgresql/data

volumes:
  pgdata:
````

### Aqui está o Dockerfile utilizado para criar o contêiner da aplicação:

````dockerfile
Copiar código
# Use uma imagem base do OpenJDK
FROM openjdk:21-jdk

# Defina o diretório de trabalho
WORKDIR /app

# Copie o JAR da aplicação para o contêiner
COPY target/ebookstore-0.0.1-SNAPSHOT.jar app.jar

# Exponha a porta em que a aplicação estará rodando
EXPOSE 8080

# Comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
````
### Futuras Melhorias
- Implementar autenticação com JWT.
- Adicionar paginação e ordenação aos endpoints.
- Escrever testes unitários e de integração.
 ## Autor: 
 - Gabriel Lucas Rodrigues Souza
### Licença
- Este projeto está licenciado sob a licença MIT. Consulte o arquivo LICENSE para mais detalhes.
<img width=100% src="https://capsule-render.vercel.app/api?type=waving&color=4C89F8&height=120&section=footer"/>
