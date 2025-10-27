# Task Manager Backend

## What Does This System Do?
The Task Manager Backend is a robust Spring Boot REST API that powers the Task Manager Pro application. It provides complete backend functionality for task management, including data persistence, business logic, and secure API endpoints for the frontend interface.

## Demo Video
*[Add your demo video link here]*

## Deployed 
This application is deployed on Render and is live for testing and demonstration purposes. The backend service is running continuously and can be accessed via the deployed API endpoints.



## Key Features
- **RESTful API** - Complete CRUD operations for task management
- **Database Integration** - H2 in-memory database with web console
- **Advanced Filtering** - Search tasks by status, priority, date ranges, and keywords
- **Data Persistence** - JPA/Hibernate for efficient data management
- **CORS Configuration** - Secure cross-origin resource sharing for frontend integration
- **Error Handling** - Comprehensive exception handling and validation

## Technologies Used
- **Spring Boot** - Application framework
- **H2 Database** - In-memory database for development
- **JPA/Hibernate** - Object-relational mapping and data persistence
- **Maven** - Dependency management and build automation
- **RESTful Web Services** - API design and implementation

## Project Structure
```
TASK_PROJECT_BACKEND/
├── .mvn/
├── .vscode/
├── src/
│   ├── main/
│   │   ├── java/com/task/task_project/
│   │   │   ├── controller/
│   │   │   │   └── TaskController.java
│   │   │   ├── model/
│   │   │   │   └── Task.java
│   │   │   ├── repository/
│   │   │   │   └── TaskRepository.java
│   │   │   └── service/
│   │   │       └── TaskService.java
│   │   │
│   │   └── TaskApplication.java
│   │
│   └── resources/
│
├── test/
├── target/
│
├── .gitattributes
├── .gitignore
├── HELP.md
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```

## Who Is This System For?
- **Backend Developers** looking for Spring Boot reference implementation
- **Full-stack Developers** building task management applications
- **Students** learning Spring Boot and REST API development
- **Teams** requiring a scalable backend for task management solutions

## 👥 Developed By
**Marlon Pérez R.**

- 🌐 Portfolio: https://portfolio-mu-fawn-47.vercel.app/
- 💻 GitHub: https://github.com/MarlonPerezR
- 💼 LinkedIn: https://www.linkedin.com/in/marlonpérez/

## 📄 License
This project is for personal use. © 2025 Marlon Pérez - All rights reserved.