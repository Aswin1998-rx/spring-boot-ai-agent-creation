# 🤖 Spring Boot AI Agent Creation

A sophisticated AI-powered chat application built with **Spring Boot**, **LangChain4j**, and **Llama 3** that demonstrates advanced AI agent capabilities with tool integration and multi-session support.

## ✨ Features

- 🧠 **AI Chat Interface** - Interactive chat powered by Llama 3 via Ollama
- 🔧 **Tool Integration** - Custom tools for weather, calculator, and datetime operations
- 🔄 **Multi-Session Support** - Persistent conversation management
- 📊 **OpenAPI Documentation** - Auto-generated API docs with Swagger UI
- 🗄️ **Database Integration** - JPA with H2 for data persistence
- 🎯 **ReAct Agent Pattern** - Reasoning and Acting agent implementation

## 🛠️ Technology Stack

### Core Frameworks
- **Spring Boot 4.0.5** - Modern Java application framework
- **Spring Web MVC** - RESTful API development
- **Spring Data JPA** - Database abstraction layer
- **H2 Database** - In-memory database for development

### AI & Machine Learning
- **LangChain4j 0.36.2** - Java framework for AI/LLM applications
- **Ollama Integration** - Local Llama 3 model hosting
- **ReAct Agent Pattern** - Reasoning and Acting methodology

### API & Documentation
- **OpenAPI 3.0** - API specification and documentation
- **SpringDoc OpenAPI** - Automatic Swagger UI generation
- **OpenAPI Diff** - API change detection and validation

### Development Tools
- **Lombok** - Reduce boilerplate code
- **Maven** - Build and dependency management
- **Java 17** - Modern Java features

## 🚀 Quick Start

### Prerequisites
- Java 17 or higher
- Maven 3.6+
- Ollama installed with Llama 3 model

### Installation

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd spring-boot-ai-agent-creation
   ```

2. **Install Ollama and pull Llama 3**
   ```bash
   # Install Ollama (if not already installed)
   curl -fsSL https://ollama.ai/install.sh | sh
   
   # Pull Llama 3 model
   ollama pull llama3
   ```

3. **Run the application**
   ```bash
   ./mvnw spring-boot:run
   ```

4. **Access the application**
   - API Base URL: `http://localhost:8080`
   - Swagger UI: `http://localhost:8080/swagger-ui.html`
   - OpenAPI Spec: `http://localhost:8080/v3/api-docs`

## 📡 API Usage

### Chat Endpoint
```bash
curl -X POST http://localhost:8080/chat \
  -H "Content-Type: application/json" \
  -d '{"message": "What is the weather in New York?"}'
```

### Example Responses
- **Weather Query**: Returns weather information for specified cities
- **Calculations**: Performs mathematical operations
- **Date/Time**: Provides current date and time information
- **General Conversation**: Engages in natural language dialogue

## 🧰 Available Tools

### Weather Tool
- **Purpose**: Get current weather information for any city
- **Usage**: "What's the weather in London?"
- **Response**: Weather conditions and promotional content

### Calculator Tool
- **Purpose**: Perform mathematical calculations
- **Usage**: "Calculate 25 * 4 + 10"
- **Response**: Accurate mathematical results

### DateTime Tool
- **Purpose**: Get current date and time
- **Usage**: "What time is it now?"
- **Response**: Current timestamp information

## 🏗️ Architecture

```
src/main/java/com/example/demo/
├── controller/          # REST API endpoints
│   └── ChatController.java
├── service/            # Business logic layer
│   ├── student/        # Domain-specific services
│   └── ai/            # AI agent implementations
│       ├── AiService.java
│       ├── AssistantAgent.java
│       ├── MultiSessionAgent.java
│       └── AgentFactory.java
├── component/          # AI tools and agents
│   ├── ReactAgent.java
│   ├── WeatherTool.java
│   ├── CalculatorTool.java
│   └── DateTimeTool.java
├── config/            # Configuration classes
│   ├── LlmConfig.java
│   ├── MultiSessionAgentConfig.java
│   └── HibernateConfig.java
├── model/             # Data models
│   └── Student.java
└── repository/        # Data access layer
    └── StudentRepository.java
```

## 🔧 Configuration

### Application Properties
Configure the following in `application.properties`:

```properties
# Ollama Configuration
ollama.base-url=http://localhost:11434
ollama.model=llama3

# Database Configuration
spring.datasource.url=jdbc:h2:mem:testdb
spring.h2.console.enabled=true
```

## 🧪 Testing

Run the test suite:
```bash
./mvnw test
```

## 📚 Key Concepts

### LangChain4j Integration
- **Chat Models**: Integration with Ollama for Llama 3
- **Tools**: Custom function calling capabilities
- **Agents**: ReAct pattern implementation
- **Memory**: Conversation context management

### ReAct Agent Pattern
The application implements the **Reasoning and Acting** pattern:
1. **Reason**: Analyze the user's request
2. **Act**: Choose and execute appropriate tools
3. **Observe**: Process tool results
4. **Reason**: Formulate final response

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Add tests if applicable
5. Submit a pull request

## 📄 License

This project is licensed under the MIT License.

## 🔗 Related Resources

- [LangChain4j Documentation](https://docs.langchain4j.dev/)
- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Ollama Documentation](https://ollama.ai/docs)
- [OpenAPI Specification](https://swagger.io/specification/)

---

**Built with ❤️ using Spring Boot, LangChain4j, and Llama 3**
