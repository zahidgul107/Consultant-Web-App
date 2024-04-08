# Consultant Web Application Documentation



## Technologies Used:

### Backend (Java Spring Boot):
- Spring Boot
- Spring Security
- Spring Data JPA
- MySQL (Database)
- Maven (Build Tool)

## How to Run Locally:
1. Clone the repository:
   ```bash
   git clone https://github.com/zahidgul107/Consultant-Web-App.git
   cd your-repository

## Backend Setup:

### 1. Database Setup:
- Install MySQL and create a database named `consultantWebApp`.
- Run the following SQL script to create the `consultantWebApp` database:
  ```sql
  CREATE DATABASE `consultantWebApp`

### 2. Spring Boot Configuration:
- Open the src/main/resources/application.properties file.
- Configure the database connection:
```bash
spring.application.name=consultant-web-app

spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://localhost:3306/consultantWebApp
spring.datasource.username=your-mysql-username
spring.datasource.password=your-mysql-password

server.port=8086

spring.jackson.serialization.WRITE_DATES_AS_TIMESTAMPS=false
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
spring.jpa.generate-ddl=true 
spring.jpa.show-sql=true
```

### 3. Run the Spring Boot Application:
- Open the project in your favorite IDE (e.g., STS).
- Run the ConsultantWebAppApplication class.

## Application Functionality:

## 1. Add Consultant Request:

- Endpoint: POST `/consultantReq/addConsultantReq`
- Description: Adds a consultant request to the system.
- Request Body: ConsultantRequestDTO
- ConsultantRequestDTO Json
```bash
{
  "name": "zahid gul",
  "email": "test123@gmail.com"
}
```
- Response: ConsultantReqResponse
- HTTP Status Codes:
  - 201 Created - Consultant request successfully added.
  - 400 Bad Request - If the request body is invalid.
    
## 2. Get All Consultant Requests:
- Endpoint: GET `/consultantReq/getAllConsultantReq`
- Description: Retrieves all consultant requests.
- Query Parameters
  - `page` (optional, default: 1) - Page number.
  - `pageSize` (optional, default: 10) - Number of items per page.
- Response: List of ConsultantReqResponse objects.
- HTTP Status Code:
  - 200 OK - Successfully retrieved the consultant requests.
    
## 3. Update Consultant Request Status:

- Endpoint: PUT `/consultantReq/{requestId}`
- Description: Updates the status of a consultant request by ID.
- Path Parameters:
- requestId - ID of the consultant request.
- Request Parameter:
  - status
  - New status for the consultant request.
-HTTP Status Codes:
  - 200 OK
  - Consultant request status successfully updated.
  - 404 Not Found - If the consultant request with the specified ID is not found.

## 4. Update Consultant Details:

- Endpoint: PUT `/consultant/updateConsultant`
- Description: Updates the details of a consultant.
- Request Body: ConsultantDTO
- ConsultantDTO Json
```bash
{
  "consultantId": 2,
  "name": "zahid gul",
  "age": 23,
  "phoneNo": "43434343",
  "cv": "dv",
  "email": "zahidgul107@gmail.com",
  "jobRole": "Java Developer"
}
```
- Response: Updated ConsultantDTO
- HTTP Status Codes:
  - 200 OK - Consultant details successfully updated.
  - 404 Not Found - If the consultant with the specified ID is not found.
    
## 5. Get All Consultants:

- Endpoint: GET `/consultant/getAllConsultant`
- Description: Retrieves all consultants in a paginated manner.
- Query Parameters:
  - page (optional, default: 1) - Page number.
  - pageSize (optional, default: 10) - Number of items per page.
- Response: List of ConsultantResponse objects.
- HTTP Status Code:
  - 200 OK - Successfully retrieved the consultants.
    
## 6. Get Consultant Details by Name or Job Role:

- Endpoint: GET `/consultant/{search}`
- Description: Retrieves details of consultants by name or job role.
- Path Parameter:
  - search
  - Name or job role of the consultant.
- Query Parameters:
  - page (optional, default: 1) - Page number.
  - pageSize (optional, default: 10) - Number of items per page.
- Response: List of ConsultantResponse objects.
- HTTP Status Code:
  - 200 OK
  - Successfully retrieved the consultants.

