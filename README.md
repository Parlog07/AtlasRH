# AtlasRH — Week 1 REST API

Java 17, Spring Boot 4.1.1, PostgreSQL, Liquibase, MapStruct, OpenAPI.

## Setup

1. Create PostgreSQL database `atlasrh_db` owned by `atlasrh_user`.
2. Set `DB_PASSWORD` in your shell. Do not commit passwords.
3. Run `./mvnw clean compile` (or `mvn clean compile` if wrapper absent).
4. Run `./mvnw spring-boot:run`.
5. Open `http://localhost:8080/swagger-ui/index.html`.

## Architecture

- `controller`: HTTP and request validation
- `dto`: request/response contracts
- `mapper`: MapStruct entity/DTO conversion
- `service`: business rules and transactions
- `repository`: JPA persistence
- `entity`: database model
- `exception`: centralized HTTP error mapping
- `enums`: contract and leave statuses

## Week 1 endpoints

- `POST/GET /api/departments`, `GET/PUT/DELETE /api/departments/{id}`
- `POST/GET /api/employees`, `GET/PUT /api/employees/{id}`, `GET /api/employees/{id}/team`
- `POST /api/contracts`, `PATCH /api/contracts/{id}/terminate`, `GET /api/employees/{id}/contracts`

### Example create department

POST /api/departments

```json
{"name":"Finance","description":"Finance operations"}
```

Response: 201 with `id`, `name`, `description`.

### Example create employee

POST /api/employees

```json
{"matricule":"AT-001","firstName":"Malenia","lastName":"Demo","email":"malenia@example.test","position":"Developer","hireDate":"2026-10-01","departmentId":1,"managerId":null}
```

### Example create contract

POST /api/contracts

```json
{"employeeId":1,"type":"CDI","startDate":"2026-10-01","endDate":null,"grossSalary":12000.00}
```

### Example terminate contract

PATCH /api/contracts/1/terminate

```json
{"endDate":"2026-10-25"}
```

## Notes

- The demo leave allowances (22 annual / 5 exceptional) are examples, not values specified by the brief.
- Contract activity is modeled as not terminated with an overlapping validity period. Review this business interpretation with your teacher.
- Week 2 leave workflows are not yet implemented.
- No authentication, as requested in the brief.
