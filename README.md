# Stock Trading Application

## Overview
This is a Spring Boot-powered Stock Trading application that supports order matching, real-time data processing, and scheduled tasks. The project is structured to be clean, modular, and easy to extend.

## Features
- REST API for stock trading operations
- Scheduled tasks for order matching
- Real-time logging using SLF4J
- Unit and integration tests with Spring Boot Test
- Hot reload during development with Spring Boot DevTools

## Technologies Used
- **Java 17**
- **Spring Boot** (Web, Scheduling, DevTools)
- **Maven**


## Prerequisites
Ensure you have the following installed:
- Java 17
- Maven 3.8+
- Git

## Setup Instructions

1. **Clone the repository:**
```bash
git clone https://github.com/maheshmolabanti/StockTrading.git
cd StockTrading
```

2. **Build the project:**
```bash
mvn clean install
```

3. **Run the application:**
```bash
mvn spring-boot:run
```

## API Endpoints

- **Place an order:**
```http
POST /api/orders
```
**Request Body:**
```json
{
  "stockSymbol": "AAPL",
  "orderType": "BUY",
  "quantity": 100,
  "price": 150.00
}
```

- **Get all orders:**
```http
GET /api/orders
```

## Testing
Run tests using:
```bash
mvn test
```

## Contributing
1. Fork the repository.
2. Create a new branch (`git checkout -b feature-branch`).
3. Commit your changes (`git commit -m 'Add new feature'`).
4. Push to the branch (`git push origin feature-branch`).
5. Open a Pull Request.

## License
This project is licensed under the MIT License - see the LICENSE file for details.

---

**Author:** Mahesh Molabanti

