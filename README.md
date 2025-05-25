# ResumeHub

ResumeHub is a Spring Boot application for uploading, parsing, and managing resumes. It supports file uploads (PDF, DOCX, etc.), extracts text using Apache Tika, and stores both the file and extracted content in a MySQL database.

## Features
- Upload resumes (PDF, DOCX, etc.)
- Extract and store text from resumes
- Store original file as binary (LONGBLOB)
- User management and LLM (Large Language Model) integration structure
- RESTful API endpoints

## Tech Stack
- Java 21
- Spring Boot 3.5+
- Spring Data JPA
- MySQL
- Apache Tika

## Getting Started

### Prerequisites
- Java 21+
- Maven
- MySQL

### Database Setup
Create a database named `resumehub` in MySQL:
```sql
CREATE DATABASE resumehub;
```

Update `src/main/resources/application.properties` with your MySQL credentials if needed.

### Build and Run
```sh
./mvnw clean install
./mvnw spring-boot:run
```

### API Endpoints
- `POST /api/resumes/upload` — Upload a resume file (form-data: `userName`, `file`)
- `POST /api/users/register` — Register a new user
- `POST /api/llm/analyze` — Analyze text with LLM (stub)

## Project Structure
- `resume/` — Resume upload, storage, and parsing
- `user/` — User management
- `llm/` — LLM integration (stub)

## License
MIT

---

For more details, see the source code or open an issue.
