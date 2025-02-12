# E-Commerce API

This is a Spring Boot-based E-Commerce API that provides CRUD operations for managing users, products, cart items, inventory, and orders. The project follows clean code principles and includes exception handling, DTOs, and structured naming conventions.

## Features
- User management (Add, Delete, Update, Retrieve users)
- Product management (CRUD operations)
- Shopping cart functionality
- Inventory management
- Order processing and history
- Exception handling and structured API responses

## Technologies Used
- Java (Spring Boot)
- Maven
- SQL Server (Database)
- RESTful API design

## API Endpoints
- `POST /users` - Add a new user
- `GET /users/{id}` - Retrieve user details
- `DELETE /users/{id}` - Delete a user
- `POST /products` - Add a new product
- `GET /cart` - View cart items
- `POST /orders` - Place an order
