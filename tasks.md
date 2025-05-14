# Improvement Tasks

## Code Quality and Bug Fixes

1. [ ] Fix duplicate `listAuthors()` method in `AuthorController` - one has path "/authors/{id}" but doesn't use the id parameter
2. [ ] Fix `BookRepository` ID type - currently uses `Long` but should be `String` to match the `isbn` field in `BookEntity`
3. [ ] Remove `@Id` annotation from `BookDto` - DTOs should not have JPA annotations
4. [ ] Fix incorrect field names in `AuthorControllerIntegrationTests` - has both `AuthorService` and `authorService`
5. [ ] Fix incorrect test method names in `BookControllerIntegrationTests` - references authors instead of books
6. [ ] Make dependency-injected fields final in all classes (controllers, services, mappers)
7. [ ] Fix package name typo: rename "imple" to "impl" in mapper implementations
8. [ ] Fix inconsistent field access modifiers - `authorRepository` is public in `AuthorServiceImpl` but `bookRepository` has default access in `BookServiceImpl`
9. [ ] Remove unused `ListableBeanFactory` in `AuthorServiceImpl`
10. [ ] Fix indentation in `AuthorMapperImpl` for the `modelMapper` field

## Architecture and Design Improvements

1. [ ] Implement proper exception handling with `@ControllerAdvice` and custom exceptions
2. [ ] Add validation for DTOs using Bean Validation (JSR-380)
3. [ ] Complete CRUD operations for both entities:
   - [ ] Add endpoints for getting author/book by ID
   - [ ] Add endpoints for updating author/book
   - [ ] Add endpoints for deleting author/book
4. [ ] Use `@PostMapping` instead of `@PutMapping` for creating books to follow REST conventions
5. [ ] Simplify `findAll()` methods in service implementations - replace complex StreamSupport with simpler alternatives
6. [ ] Add pagination support for listing authors and books
7. [ ] Reconsider cascade type in `BookEntity` - `CascadeType.ALL` could cause unintended deletions of authors
8. [ ] Resolve mapping strategy inconsistency - project uses both custom `Mapper` interface and `ModelMapper`
9. [ ] Add custom mapping configuration in mapper implementations for handling complex scenarios
10. [ ] Add proper logging throughout the application using SLF4J

## Security Improvements

1. [ ] Externalize database credentials using environment variables or Spring Cloud Config
2. [ ] Add input validation to prevent SQL injection and other attacks
3. [ ] Implement proper authentication and authorization (e.g., Spring Security)
4. [ ] Set appropriate CORS configuration
5. [ ] Add rate limiting for API endpoints

## Testing Improvements

1. [ ] Add unit tests for service and mapper implementations
2. [ ] Add tests for error scenarios in controller integration tests
3. [ ] Add tests for the endpoints that will be implemented (get by ID, update, delete)
4. [ ] Consider using test containers for integration tests instead of in-memory database
5. [ ] Add API contract tests (e.g., using Spring Cloud Contract)

## Documentation and API Improvements

1. [ ] Add Swagger/OpenAPI documentation for the API
2. [ ] Add proper JavaDoc comments to all classes and methods
3. [ ] Create README.md with project description, setup instructions, and API documentation
4. [ ] Add API versioning strategy

## Performance and Scalability Improvements

1. [ ] Configure connection pooling (e.g., HikariCP)
2. [ ] Add caching for frequently accessed data
3. [ ] Consider implementing asynchronous processing for time-consuming operations
4. [ ] Add health checks and metrics for monitoring

## DevOps and Infrastructure Improvements

1. [ ] Create separate application properties for different environments (dev, test, prod)
2. [ ] Set up CI/CD pipeline
3. [ ] Configure Docker and docker-compose for containerization
4. [ ] Add database migration tool (e.g., Flyway or Liquibase) instead of using hibernate.ddl-auto=update
5. [ ] Set up monitoring and alerting