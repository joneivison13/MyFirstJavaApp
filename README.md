# <NOME_DO_SEU_PROJETO>

Este projeto é uma aplicação de exemplo que implementa um CRUD (Create, Read, Update, Delete) de usuários. Foi desenvolvido utilizando Spring Boot e segue as melhores práticas de desenvolvimento e arquitetura.

## Funcionalidades

- Criação de usuários
- Leitura de dados de usuários
- Atualização de dados de usuários
- Exclusão de usuários

## Tecnologias Utilizadas

- Spring Boot
- JPA / Hibernate
- H2 Database (Para exemplos e testes)
- Maven

## Requisitos

Para rodar este projeto, você precisará ter instalado em sua máquina:

- JDK 11 ou superior
- Maven

## Como Executar

1. **Clone o Repositório**

   ```bash
   git clone https://github.com/seu-usuario/<NOME_DO_SEU_PROJETO>.git
   cd <NOME_DO_SEU_PROJETO>
   ```

2. **Execute o Projeto com Maven**

   No diretório do projeto, execute:

   ```bash
   mvn spring-boot:run
   ```

   Esse comando irá iniciar a aplicação na porta padrão `8080`. Se necessário, você pode alterar a porta no arquivo `src/main/resources/application.properties`.

3. **Acessando a Aplicação**

   Após iniciar a aplicação, você pode acessar a API através de `http://localhost:8080`.

## Endpoints

A aplicação define os seguintes endpoints para gerenciamento de usuários:

- `POST /users` - Cria um novo usuário
- `GET /users` - Lista todos os usuários
- `GET /users/{id}` - Busca um usuário pelo seu ID
- `PUT /users/{id}` - Atualiza os dados de um usuário
- `DELETE /users/{id}` - Remove um usuário pelo seu ID

## Testando a Aplicação

Você pode testar a aplicação e os endpoints utilizando ferramentas como Postman ou cURL. Aqui estão alguns exemplos de como você pode fazer isso:

**Criando um Novo Usuário**

```bash
curl -X POST http://localhost:8080/users -H 'Content-Type: application/json' -d '{"name": "John Doe", "email": "john.doe@example.com", "password": "password"}'
```

## Contribuições

Contribuições são muito bem-vindas! Se você tiver alguma sugestão para melhorar este projeto, sinta-se à vontade para criar um pull request.

## Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.
