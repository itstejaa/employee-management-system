# Employee Management System

A Java 17 / Spring Boot REST API backed by MySQL. This is the application-developer handoff for Project 2 in our DevOps learning track.

## API endpoints

Base URL: `http://localhost:8082`

| Method | Endpoint | Purpose |
|---|---|---|
| GET | `/api/employees` | List all employees |
| GET | `/api/employees/{id}` | Get one employee |
| POST | `/api/employees` | Create an employee |
| PUT | `/api/employees/{id}` | Update an employee |
| DELETE | `/api/employees/{id}` | Delete an employee |
| GET | `/actuator/health` | Application health |

## Example request body

```json
{
  "firstName": "Teja",
  "lastName": "Kumar",
  "email": "teja@example.com",
  "department": "DevOps",
  "salary": 45000
}
```

## Runtime configuration

The app reads these environment variables:
- `DB_URL` — JDBC URL (default points to localhost:3306/employee_db)
- `DB_USERNAME` — default `employee_user`
- `DB_PASSWORD` — default `employee_pass`
- `SERVER_PORT` — default `8082`

The default credentials are for local learning only. Use secret management for real deployments and never commit production passwords.

## Developer handoff

This repository intentionally does not include a Dockerfile, Docker Compose file, Jenkinsfile, or cloud deployment configuration. Those are DevOps tasks for this project.
