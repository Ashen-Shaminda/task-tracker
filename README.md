# Tasks Management API

A Spring Boot application for managing tasks and task lists. This API allows users to create, read, update, and delete
tasks and task lists, with support for task prioritization and status tracking.

## Features

- Create and manage task lists
- Create and manage tasks within task lists
- Set task priorities (HIGH, MEDIUM, LOW)
- Track task status (OPEN, CLOSED)
- Set due dates for tasks
- Track creation and update timestamps

## Technologies Used

- Java 21
- Spring Boot 3.4.5
- Spring Data JPA
- PostgreSQL
- Docker
- Lombok
- MapStruct
- Bean Validation

## Prerequisites

- Java 21 or higher
- Docker and Docker Compose
- Maven

## Getting Started

### Clone the Repository

```bash
git clone <repository-url>
cd tasks
```

### Start the Database

```bash
docker-compose up -d
```

This will start a PostgreSQL database container with the following configuration:

- Database name: tasks
- Username: root
- Password: changemeinprod
- Port: 5432

### Build and Run the Application

```bash
./mvnw clean install
./mvnw spring-boot:run
```

The application will be available at http://localhost:8080

## API Documentation

### Task Lists

#### List all Task Lists

```
GET /api/task-lists
```

#### Create a Task List

```
POST /api/task-lists
Content-Type: application/json

{
  "title": "Work Tasks",
  "description": "Tasks related to work projects"
}
```

#### Get a Task List by ID

```
GET /api/task-lists/{id}
```

#### Update a Task List

```
PUT /api/task-lists/{id}
Content-Type: application/json

{
  "title": "Updated Work Tasks",
  "description": "Updated tasks related to work projects"
}
```

#### Delete a Task List

```
DELETE /api/task-lists/{id}
```

### Tasks

#### List all Tasks in a Task List

```
GET /api/task-lists/{task_list_id}/tasks
```

#### Create a Task in a Task List

```
POST /api/task-lists/{task_list_id}/tasks
Content-Type: application/json

{
  "title": "Complete project documentation",
  "description": "Write comprehensive documentation for the project",
  "dueDate": "2025-08-01T12:00:00",
  "priority": "HIGH",
  "status": "OPEN"
}
```

#### Get a Task by ID

```
GET /api/task-lists/{task_list_id}/tasks/{task_id}
```

#### Update a Task

```
PUT /api/task-lists/{task_list_id}/tasks/{task_id}
Content-Type: application/json

{
  "title": "Complete project documentation",
  "description": "Write comprehensive documentation for the project",
  "dueDate": "2025-08-01T12:00:00",
  "priority": "MEDIUM",
  "status": "CLOSED"
}
```

#### Delete a Task

```
DELETE /api/task-lists/{task_list_id}/tasks/{task_id}
```

## Data Models

### Task List

- `id`: UUID (auto-generated)
- `title`: String (required)
- `description`: String (required)
- `count`: Integer (number of tasks in the list)
- `progress`: Double (completion percentage)
- `tasks`: List of Tasks
- `created`: Timestamp
- `updated`: Timestamp

### Task

- `id`: UUID (auto-generated)
- `title`: String (required)
- `description`: String (required)
- `dueDate`: DateTime (must be in the future)
- `status`: Enum (OPEN, CLOSED)
- `priority`: Enum (HIGH, MEDIUM, LOW)
- `created`: Timestamp
- `updated`: Timestamp

## Validation

The API includes validation for:

- Required fields (title, description)
- Due dates must be in the future
- Valid task status and priority values

## Error Handling

The API includes global exception handling for:

- Validation errors
- Resource not found errors
- General server errors

## Development

### Running Tests

```bash
./mvnw test
```

### Building for Production

```bash
./mvnw clean package
```