# Employee Management REST API

A lightweight, robust RESTful Web Service built with **Spring Boot** and **Java** to manage employee records. The application utilizes an in-memory `HashMap` data structure to perform CRUD operations without requiring any external database setup.

---

## 🛠️ Technologies Used

- **Language:** Java 17+
- **Framework:** Spring Boot (Spring MVC / REST API)
- **Build Tool:** Apache Maven
- **Storage:** In-memory collection (`java.util.HashMap`)

---

## 📁 Project Folder Structure

```text
EmployeeManagement/
├── .mvn/
│   └── wrapper/
│       └── maven-wrapper.properties
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── kiet/
│   │   │           └── sample2/
│   │   │               ├── Employee.java
│   │   │               ├── EmployeeController.java
│   │   │               └── EmployeemanagementApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/
│           └── com/
│               └── kiet/
│                   └── sample2/
│                       └── Sample2ApplicationTests.java
├── .gitignore
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```

---

## 🚀 Getting Started & Running the Application

### Prerequisites

- **Java Development Kit (JDK):** Version 17 or higher installed.
- **Maven:** Bundled via `mvnw` wrapper, or Maven 3.8+ installed globally.
- **cURL, Postman, or any REST Client** for testing endpoints.

### Run Instructions

1. **Clone the repository:**
   ```bash
   git clone https://github.com/<your-username>/EmployeeManagement.git
   cd EmployeeManagement
   ```

2. **Build the application:**
   - **Windows:**
     ```cmd
     mvnw.cmd clean package
     ```
   - **macOS / Linux:**
     ```bash
     ./mvnw clean package
     ```

3. **Run the application:**
   - **Windows:**
     ```cmd
     mvnw.cmd spring-boot:run
     ```
   - **macOS / Linux:**
     ```bash
     ./mvnw spring-boot:run
     ```
   *(Alternatively, run the `EmployeemanagementApplication` main class directly from IntelliJ IDEA)*

4. The server starts by default on port `8080`:
   ```
   http://localhost:8080
   ```

---

## 📡 API Endpoints Documentation

Base URL: `http://localhost:8080/employees`

| HTTP Method | Endpoint | Description | Request Body | Success Code | Error Codes |
| :--- | :--- | :--- | :--- | :--- | :--- |
| **POST** | `/employees` | Add a new employee | JSON (Employee object) | `201 Created` | `400 Bad Request` |
| **GET** | `/employees` | Retrieve all employees | None | `200 OK` | - |
| **GET** | `/employees/{id}` | Retrieve employee by ID | None | `200 OK` | `404 Not Found` |
| **PUT** | `/employees/{id}` | Update existing employee | JSON (Employee object) | `200 OK` | `404 Not Found` |
| **DELETE** | `/employees/{id}` | Delete employee by ID | None | `200 OK` | `404 Not Found` |

---

## 📝 Sample Requests & Responses

### 1. Add Employee (`POST /employees`)

- **URL:** `http://localhost:8080/employees`
- **Headers:** `Content-Type: application/json`
- **Request Body:**
  ```json
  {
    "id": 101,
    "name": "Jane Doe",
    "department": "Engineering",
    "salary": 85000.0
  }
  ```
- **Response:** `201 Created`
  ```json
  {
    "id": 101,
    "name": "Jane Doe",
    "department": "Engineering",
    "salary": 85000.0
  }
  ```

### 2. Get All Employees (`GET /employees`)

- **URL:** `http://localhost:8080/employees`
- **Response:** `200 OK`
  ```json
  [
    {
      "id": 101,
      "name": "Jane Doe",
      "department": "Engineering",
      "salary": 85000.0
    }
  ]
  ```

### 3. Get Employee By ID (`GET /employees/{id}`)

- **URL:** `http://localhost:8080/employees/101`
- **Response:** `200 OK`
  ```json
  {
    "id": 101,
    "name": "Jane Doe",
    "department": "Engineering",
    "salary": 85000.0
  }
  ```
- **If Not Found (e.g. `GET /employees/999`):**
  - **Response:** `404 Not Found`

### 4. Update Employee (`PUT /employees/{id}`)

- **URL:** `http://localhost:8080/employees/101`
- **Headers:** `Content-Type: application/json`
- **Request Body:**
  ```json
  {
    "name": "Jane Smith",
    "department": "Research & Development",
    "salary": 95000.0
  }
  ```
- **Response:** `200 OK`
  ```json
  {
    "id": 101,
    "name": "Jane Smith",
    "department": "Research & Development",
    "salary": 95000.0
  }
  ```
- **If Not Found:** `404 Not Found`

### 5. Delete Employee (`DELETE /employees/{id}`)

- **URL:** `http://localhost:8080/employees/101`
- **Response:** `200 OK`
  ```text
  Employee deleted successfully
  ```
- **If Not Found:** `404 Not Found`

---

## 🚦 HTTP Status Codes Summary

- `200 OK` – Request succeeded (retrieval, update, or deletion).
- `201 Created` – Resource successfully created.
- `404 Not Found` – Requested employee ID does not exist in memory.

---

## 📄 License

This project is open-source and available under the [MIT License](LICENSE).
