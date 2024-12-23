# TackBoard's Springboot Backend (WiP)
Handles user login for secured API endpoints and database operations

## Dependencies Used:
- Lombok
- Spring Web
- Spring Data JPA/Hibernate ORM
- Spring Security
- Spring PostgreSQL Driver

## Setup:
Configure .env file:
```
POSTGRES_HOST=<postgres ip>
POSTGRES_DATABASE=<database name>
POSTGRES_USER=<postgres username>
POSTGRES_PASSWORD=<postgres password>
JWT_SECRET_KEY=<base64 key>
```