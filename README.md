# Seller and Department Management System

This project is a simple application for managing sellers and departments, developed in Java following instructions from Professor Nélio Alves. It demonstrates key concepts of Object-Oriented Programming (OOP), JDBC, and database operations, such as inserting, updating, deleting, and retrieving records from a MySQL database.

## Project Overview

The application allows the user to:

- Manage Sellers (insert, update, delete, find by ID, find by department, and list all).
- Manage Departments (insert, update, delete, find by ID, and list all).
- Interact with a MySQL database to perform CRUD operations.

## Features

- **Seller Operations**: You can perform CRUD (Create, Read, Update, Delete) operations on sellers. The sellers are linked to departments.
- **Department Operations**: CRUD operations on departments, which sellers are part of.
- **Data Persistence**: The application uses JDBC to connect to a MySQL database and manage data.
- **User Interaction**: The application uses a simple text-based interface to interact with the user.

## Technologies Used

- **Java**: Core programming language.
- **JDBC**: To connect and interact with the MySQL database.
- **MySQL**: Database used for storing seller and department information.
- **Maven**: Dependency management.

## How to Run the Project

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/your-repository.git
   ```

2. Import the project into your preferred IDE (Eclipse, IntelliJ, etc.).

3. Make sure to configure the database connection in the `db.properties` file:

   ```properties
   dburl=jdbc:mysql://localhost:3306/your-database
   dbuser=your-username
   dbpassword=your-password
   ```

4. Run the `Program.java` file as a Java application.

## Database Setup

To set up the MySQL database, run the following SQL script, or copy and paste database file on project:

```sql
CREATE DATABASE your-database;

USE your-database;

CREATE TABLE department (
    Id INT NOT NULL AUTO_INCREMENT,
    Name VARCHAR(30),
    PRIMARY KEY (Id)
);

CREATE TABLE seller (
    Id INT NOT NULL AUTO_INCREMENT,
    Name VARCHAR(60),
    Email VARCHAR(100),
    BirthDate DATE,
    BaseSalary DOUBLE,
    DepartmentId INT,
    PRIMARY KEY (Id),
    FOREIGN KEY (DepartmentId) REFERENCES department(Id)
);
```

## Usage

1. Run the application.
2. Choose between managing sellers or departments.
3. Select the operation you want to perform (insert, update, delete, find by ID, etc.).
4. Follow the on-screen prompts to complete your tasks.

## Credits

This project was developed as part of the Java course by **Professor Nélio Alves**, focusing on practical applications of Java and database integration.

## License

This project is licensed under the MIT License.
