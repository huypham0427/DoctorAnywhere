
# DoctorAnywhere - Freshers Take Home Assignment

A simple RESTful API with Java project created with https://start.spring.io/

## Getting Started

This project is a starting point for a Spring Boot application.

Dependencies to get you started if this is your first Spring Boot project:

- Spring Web
- Spring Data JPA
- MySQL Driver

## Getting Started: 

1. Create a new Spring Boot project using your IntelliJ IDE. Use Maven to manage dependencies.
2. Define a simple data model for a "Task" object that includes the following properties:
  - id: Long (a unique identifier for the task)
      - @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY
      (Set id as a primary key and automatically increase)
  - title: String (title of the task)
  - description: String (description of the task)
  - completed: Boolean (flag indicating whether the task has been completed)
3. Create the database and table to connect between Spring Boot and backend 
4. Implement the following RESTful endpoints
  - GET /tasks: Get a list of all tasks
  - POST /tasks: Create a new task
  - GET /tasks/{id} : Get a single task by ID
      - Having an error handler for an unknown ID while testing API and displaying the error message.
      - Creating an error handler with a connection from the database. 
  - PUT /tasks/{id} : Update a task by ID
      - Having an error handler for an unknown ID while testing API and displaying the error message.
      - Creating an error handler with a connection from the database. 
  - DELETE /tasks/{id} : Delete a task by ID
      - Having an error handler for an unknown ID while testing API and displaying the error message.
      - Creating an error handler with a connection from the database. 
5. Use MySQL for persistence.
6. Tested APIs using Postman.
7. Use git as the version control for your project.

## Bonus points
- [x] Implement error handling for each endpoint.
- [x] Use Spring Data JPA to store the task data in a MySQL database.
- [] Use Spring Security to add authentication and authorization to the API.
- [] Can run the application in a container.

## Video Walkthrough
Here's a walkthrough of the implemented app:

![ezgif com-optimize](https://github.com/huypham0427/Grocery-List-App-FLutter/assets/59068418/0f2f4cd8-f5b6-4ebb-8aa3-7daf0cbd416e)




