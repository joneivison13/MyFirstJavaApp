# Joneivison13/MyFirstJavaApp

This project is a sample application that implements a CRUD (Create, Read, Update, Delete) for users. It was developed using Spring Boot and follows the best practices of development and architecture.

## Features

- Creating users
- Reading user data
- Updating user data
- Deleting users

## Technologies Used

- Spring Boot
- JPA / Hibernate
- H2 Database (For examples and testing)
- Maven

## Requirements

To run this project, you will need to have installed on your machine:

- JDK 11 or higher
- Maven

## How to Execute

1. **Clone the Repository**

   ```bash
   git clone https://github.com/joneivison13/MyFirstJavaApp
   cd MyFirstJavaApp
   ```

2. **Run the Project with Maven**

   In the project directory, execute:

   ```bash
   mvn spring-boot:run
   ```

   This command will start the application on the default port `8080`. If necessary, you can change the port in the `src/main/resources/application.properties` file.

3. **Accessing the Application**

   After starting the application, you can access the API via `http://localhost:8080`.

## Endpoints

The application defines the following endpoints for user management:

- `POST /users` - Creates a new user
- `GET /users` - Lists all users
- `GET /users/{id}` - Searches for a user by their ID
- `PUT /users/{id}` - Updates a user's data
- `DELETE /users/{id}` - Removes a user by their ID

## Testing the Application

You can test the application and the endpoints using tools like Postman or cURL. Here are some examples of how you can do it:

**Creating a New User**

```bash
curl -X POST http://localhost:3333/user/create -H 'Content-Type: application/json' -d '{"name": "John Doe", "email": "john.doe@example.com", "password": "password"}'
```

## Contributions

Contributions are very welcome! If you have any suggestions for improving this project, feel free to create a pull request.

## License

This project is under the MIT license. See the [LICENSE](LICENSE) file for more details.
