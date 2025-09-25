# Spring Boot JPA MySQL Demo Application

A comprehensive Spring Boot application demonstrating JPA (Java Persistence API) integration with both H2 (in-memory) and MySQL databases. This project showcases CRUD operations through RESTful APIs using Spring Data JPA.

## 📋 Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Technology Stack](#technology-stack)
- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Installation & Setup](#installation--setup)
- [Database Configuration](#database-configuration)
- [API Endpoints](#api-endpoints)
- [Docker Support](#docker-support)
- [Usage Examples](#usage-examples)
- [Contributing](#contributing)

## 🎯 Overview

This Spring Boot application provides a RESTful API for managing "Alien" entities, demonstrating:
- Spring Boot framework implementation
- JPA/Hibernate ORM mapping
- Database connectivity (H2 and MySQL)
- CRUD operations via REST endpoints
- Docker containerization
- Maven build configuration

## ✨ Features

- **RESTful API**: Complete CRUD operations for Alien entities
- **Dual Database Support**: Configured for both H2 (development) and MySQL (production)
- **JPA Integration**: Uses Spring Data JPA for database operations
- **Docker Ready**: Includes Dockerfile and Docker Compose setup
- **Auto-Configuration**: Spring Boot auto-configuration for rapid development
- **Data Initialization**: Pre-populated sample data via `data.sql`

## 🛠 Technology Stack

- **Framework**: Spring Boot 2.4.5
- **Language**: Java 8
- **Database**: H2 (in-memory), MySQL 5.6
- **ORM**: Hibernate/JPA
- **Build Tool**: Maven
- **Containerization**: Docker
- **Server**: Embedded Tomcat (Port 8086)

## 📁 Project Structure

```
springbootjpa-mysql/
├── src/
│   ├── main/
│   │   ├── java/com/example/demo/
│   │   │   ├── SpringBootJPAApplication.java    # Main application class
│   │   │   ├── controller/
│   │   │   │   └── AlienController.java         # REST controller
│   │   │   ├── model/
│   │   │   │   └── Alien.java                   # JPA entity
│   │   │   └── repo/
│   │   │       └── AlienRepository.java         # JPA repository
│   │   ├── resources/
│   │   │   ├── application.properties           # Configuration
│   │   │   └── data.sql                        # Sample data
│   │   └── webapp/                             # JSP views
│   └── test/                                   # Test classes
├── Dockerfile                                  # Docker configuration
├── DockerHelp.txt                             # Docker commands reference
├── pom.xml                                     # Maven dependencies
└── README.md                                   # Project documentation
```

## 📋 Prerequisites

- Java 8 or higher
- Maven 3.6+
- Docker (optional, for containerization)
- MySQL 5.6+ (for production database)

## 🚀 Installation & Setup

### 1. Clone the Repository
```bash
git clone <repository-url>
cd springbootjpa-mysql
```

### 2. Build the Application
```bash
mvn clean install
```

### 3. Run the Application
```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8086`

## 🗄 Database Configuration

### H2 Database (Default - Development)
The application is configured to use H2 in-memory database by default:
- **URL**: `jdbc:h2:mem:alien`
- **Username**: `sa`
- **Password**: (empty)
- **Console**: Available at `http://localhost:8086/h2-console`

### MySQL Database (Production)
To switch to MySQL, uncomment the MySQL properties in `application.properties`:

```properties
# Uncomment these lines for MySQL
spring.datasource.url=jdbc:mysql://localhost:3306/springjpatest
spring.datasource.username=sa
spring.datasource.password=1234
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5InnoDBDialect
```

## 🔗 API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/aliens` | Retrieve all aliens |
| GET | `/aliens/{id}` | Retrieve alien by ID |
| POST | `/aliens` | Create new alien |
| PUT | `/aliens` | Update existing alien |
| DELETE | `/aliens/{id}` | Delete alien by ID |

### Entity Structure
```json
{
  "aid": 1,
  "aname": "John Doe"
}
```

## 🐳 Docker Support

### Build Docker Image
```bash
docker build -t springbootjpawebapp .
```

### Run MySQL Container
```bash
docker run --name connect-mysql \
  -e MYSQL_ROOT_PASSWORD=1234 \
  -e MYSQL_USER=sa \
  -e MYSQL_PASSWORD=1234 \
  -e MYSQL_DATABASE=springjpatest \
  -d mysql:5.6
```

### Run Application Container
```bash
docker container run -p 8086:8086 \
  --name springbootjpawebapp \
  --link connect-mysql:mysql \
  -d springbootjpawebapp
```

## 📝 Usage Examples

### Create a New Alien
```bash
curl -X POST http://localhost:8086/aliens \
  -H "Content-Type: application/json" \
  -d '{"aid": 6, "aname": "New Alien"}'
```

### Get All Aliens
```bash
curl http://localhost:8086/aliens
```

### Get Alien by ID
```bash
curl http://localhost:8086/aliens/1
```

### Update an Alien
```bash
curl -X PUT http://localhost:8086/aliens \
  -H "Content-Type: application/json" \
  -d '{"aid": 1, "aname": "Updated Name"}'
```

### Delete an Alien
```bash
curl -X DELETE http://localhost:8086/aliens/1
```

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 👨‍💻 Author

Created as a demonstration project for Spring Boot JPA integration with MySQL database.

---

**Note**: This is a demo application for learning purposes. For production use, consider implementing proper security, validation, and error handling mechanisms.