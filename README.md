# Employee Management Service

This is the backend service for the Employee Management Application, built using **Java Spring Boot** with **Hibernate** for ORM and **MySQL** as the database. It provides RESTful APIs to perform CRUD operations on employee data.

## 🚀 Features
- Create, Read, Update, and Delete (CRUD) employee records
- Employee details include ID, Name, Salary, Department, Designation, and Experience
- Pagination and search functionalities for efficient data handling
- Integrated with a Vue.js frontend

## 🛠️ Technologies Used
- Java Spring Boot
- Hibernate (JPA)
- MySQL
- Maven
- RESTful APIs

## ⚙️ Setup Instructions
1. Clone the repository:
   ```bash
   git clone https://github.com/SachinPulse-bit/employee-management-service.git
   ```
2. Import the project into **Eclipse** or your preferred IDE.
3. Configure the `application.properties` file with your MySQL credentials:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/employee_db
   spring.datasource.username=root
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   ```
4. Run the application:
   - Using IDE: Run the `EmployeeManagementApplication.java` class.
   - Using terminal:
     ```bash
     mvn clean install
     mvn spring-boot:run
     ```
5. Test the APIs using **Postman** or connect with the Vue.js frontend.

## 📬 API Endpoints
- `GET /employees` - List all employees (supports pagination & filters)
- `POST /employees` - Add a new employee
- `PUT /employees/{id}` - Update employee details
- `DELETE /employees/{id}` - Delete an employee

## 🔗 Related Repository
- [Employee Management Frontend](https://github.com/SachinPulse-bit/employee-management-frontend.git)
