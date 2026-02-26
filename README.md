# jobportal-backend-

A secure, role-based Job Portal REST API built using Spring Boot, Spring Security, JWT Authentication, and PostgreSQL.

This project implements a complete backend system with authentication, authorization, business logic validation, and relational database modeling.

🚀 Features
🔐 Authentication & Security

JWT-based stateless authentication

Password hashing using BCrypt

Role-based access control (USER / EMPLOYER)

Protected API endpoints

Custom UserDetailsService implementation

👤 User Management

Register new users

Login with JWT token generation

Update user profile

Delete user

Get user details

💼 Job Management

Only EMPLOYER can create jobs

View all jobs

View job by ID

Update job

Delete job

View jobs posted by a specific employer

📄 Application Management

USER can apply to jobs

Prevent duplicate applications

Employer can view applications for a job

User can view applied jobs

Employer can update application status

Application statuses:

APPLIED

SHORTLISTED

REJECTED

ACCEPTED

🛠 Tech Stack

Java 17+

Spring Boot

Spring Security

JWT (jjwt)

Hibernate / JPA

PostgreSQL

Maven

Postman (for API testing)

🏗 Project Architecture
src/main/java/com/example/jobportal
│
├── controller
│     ├── AuthController
│     ├── UserController
│     ├── JobController
│     └── ApplicationController
│
├── service
│     ├── UserService / UserServiceImpl
│     ├── JobService / JobServiceImpl
│     └── ApplicationService / ApplicationServiceImpl
│
├── repo
│     ├── UserRepository
│     ├── JobRepository
│     └── ApplicationRepository
│
├── model
│     ├── User
│     ├── Job
│     ├── Application
│     └── ApplicationStatus (Enum)
│
├── security
│     ├── JwtUtil
│     ├── JwtFilter
│     ├── CustomUserDetailsService
│     └── SecurityConfig
🔑 Authentication Flow

User registers (/auth/register)

Password is hashed using BCrypt

User logs in (/auth/login)

JWT token is generated

Token must be sent in headers:

Authorization: Bearer <your_token>

JWT filter validates token for protected endpoints

📡 API Endpoints
🔐 Auth
Method	Endpoint	Description
POST	/auth/register	Register new user
POST	/auth/login	Login and receive JWT
👤 Users
Method	Endpoint	Description
GET	/users/{id}	Get user by ID
PATCH	/users/{id}	Update user
DELETE	/users/{id}	Delete user
💼 Jobs
Method	Endpoint	Description
POST	/jobs	Create job (EMPLOYER only)
GET	/jobs	Get all jobs
GET	/jobs/{id}	Get job by ID
PATCH	/jobs/{id}	Update job
DELETE	/jobs/{id}	Delete job
GET	/jobs/employer/{id}	Get jobs by employer
📄 Applications
Method	Endpoint	Description
POST	/applications/apply	Apply to job
GET	/applications/job/{jobId}	View applications for a job
GET	/applications/user/{userId}	View applications by user
PATCH	/applications/{id}/status	Update application status
🗄 Database Design
Relationships

One User (EMPLOYER) → Many Jobs

One User (USER) → Many Applications

One Job → Many Applications

Application links User and Job (Many-to-One)

⚙️ How To Run
1️⃣ Clone Repository
git clone <your-repo-url>
2️⃣ Configure Database

Update application.properties:

spring.datasource.url=jdbc:postgresql://localhost:5432/jobportal
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
server.port=8081
3️⃣ Run Application
mvn spring-boot:run

Application runs on:

http://localhost:8081
🧪 Testing

This backend is tested using Postman.

Steps:

Register user

Login to receive JWT

Add JWT in Authorization header

Test protected endpoints

🔒 Security Highlights

Passwords stored in hashed format (BCrypt)

JWT token expiration enabled

Stateless session management

Role-based access restrictions

Unauthorized access returns 401

📈 Possible Improvements

DTO layer for response abstraction

Global exception handler

Pagination for job listings

Search and filtering functionality

Refresh token mechanism

Swagger/OpenAPI documentation

🎯 Project Goal

This project demonstrates:

Clean layered architecture

Secure REST API design

Authentication and authorization implementation

Business logic validation

Proper relational database modeling

Designed as a backend-focused project for learning and interview preparation.

👨‍💻 Author

Varun U
