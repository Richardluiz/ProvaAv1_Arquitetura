# 🎓 API REST de Gerenciamento de Alunos e Cursos

Este projeto consiste em uma API RESTful desenvolvida com **Spring Boot**, utilizando banco de dados **MariaDB**, para realizar o gerenciamento completo (CRUD) de duas entidades principais: **Aluno** e **Curso**. O sistema foi desenvolvido como parte de uma **avaliação prática** para aplicação dos conhecimentos em desenvolvimento backend com Java e arquitetura MVC.

---

## 📌 Funcionalidades

- [x] Criar, listar, atualizar e deletar **Alunos**
- [x] Criar, listar, atualizar e deletar **Cursos**
- [x] Persistência de dados com **Spring Data JPA** e **Hibernate**
- [x] Testes de requisição utilizando **Postman**

---

## 🧪 Tecnologias Utilizadas

- Java 17
- Spring Boot (Web, Data JPA, DevTools)
- Lombok
- MariaDB
- Maven
- Postman (testes)
- IDE: VS Code ou IntelliJ

---

## 🧱 Estrutura do Projeto

- `model`: Contém as classes de entidades (Aluno, Curso)
- `repository`: Interfaces para acesso ao banco com Spring Data JPA
- `service`: Contém as regras de negócio
- `controller`: Define os endpoints e lógica REST
- `resources/application.properties`: Configurações do banco de dados

---

## 📂 Entidades

### 👤 Aluno
```java
private Long id;
private String nome;
private Integer idade;
private String email;
```

### 📘 Curso
```java
private Long id;
private String nome;
private Integer cargaHoraria;
```

---

## 🌐 Endpoints da API

### 🔹 Alunos
| Método | Endpoint       | Descrição                    |
|--------|----------------|------------------------------|
| GET    | /alunos        | Retorna todos os alunos      |
| GET    | /alunos/{id}   | Retorna um aluno por ID      |
| POST   | /alunos        | Cria um novo aluno           |
| PUT    | /alunos/{id}   | Atualiza um aluno existente  |
| DELETE | /alunos/{id}   | Remove um aluno              |

#### 📅 Exemplo POST - Aluno
```json
{
  "nome": "João da Silva",
  "idade": 25,
  "email": "joao@email.com"
}
```

#### 📅 Exemplo PUT - Aluno
```json
{
  "nome": "João Atualizado",
  "idade": 26,
  "email": "joaoatualizado@email.com"
}
```

---

### 🔹 Cursos
| Método | Endpoint       | Descrição                      |
|--------|----------------|--------------------------------|
| GET    | /cursos        | Retorna todos os cursos        |
| GET    | /cursos/{id}   | Retorna um curso por ID        |
| POST   | /cursos        | Cria um novo curso             |
| PUT    | /cursos/{id}   | Atualiza um curso existente    |
| DELETE | /cursos/{id}   | Remove um curso                |

#### 📅 Exemplo POST - Curso
```json
{
  "nome": "Java Avançado",
  "cargaHoraria": 60
}
```

#### 📅 Exemplo PUT - Curso
```json
{
  "nome": "Spring Boot Completo",
  "cargaHoraria": 80
}
```

---

## ⚙️ Configuração do Banco de Dados

No arquivo `application.properties`:
```properties
spring.datasource.url=jdbc:mariadb://localhost:3306/db_escola
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## 🧬 Testando com Postman

1. Abra o **Postman**
2. Escolha o método (GET, POST, PUT, DELETE)
3. Use o endpoint correspondente (ex: `http://localhost:8080/alunos`)
4. Para POST/PUT:
   - Aba **Body** > selecione **raw** > formato **JSON**
   - Insira os dados do exemplo
5. Clique em **Send** e visualize a resposta da API

---

## 💡 Melhorias Futuras

- Relacionamento entre Aluno e Curso (Many-to-Many)
- Validações com Bean Validation (ex: `@NotNull`, `@Email`)
- Documentação com Swagger
- Integração com frontend (React, Angular)

---

## 🤖 Autor
Desenvolvido por **Richard Luiz**

Projeto realizado para fins educacionais e prática de desenvolvimento backend com Java e Spring Boot.

---

## 📄 Licença
Este projeto está licenciado sob os termos da **MIT License**. Livre para uso acadêmico e pessoal.

