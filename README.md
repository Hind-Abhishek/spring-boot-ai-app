# Spring Boot AI Question & Answer Application

A simple and elegant Spring Boot web application with Thymeleaf UI that provides AI-powered question and answer functionality using mock data loaded from a JSON file.

## 📋 Features

- ✅ Web-based UI with Thymeleaf templates
- ✅ Question & Answer functionality
- ✅ 100+ mock Q&A pairs from JSON file
- ✅ Input validation with error messages
- ✅ Global exception handling
- ✅ Simple and clean code structure
- ✅ MVC architecture pattern
- ✅ Easy to extend and customize

## 🛠️ Tech Stack

- **Framework**: Spring Boot 3.2.0
- **Template Engine**: Thymeleaf
- **Build Tool**: Maven
- **Language**: Java 17
- **JSON Processing**: Jackson

## 📦 Prerequisites

- Java 17 or higher
- Maven 3.8.0 or higher
- Git (for cloning)

## 📂 Project Structure
ai/
├── src/
│   ├── main/
│   │   ├── java/com/abhishek/ai/
│   │   │   ├── AiAppApplication.java
│   │   │   ├── controller/
│   │   │   │   └── AiController.java
│   │   │   ├── service/
│   │   │   │   ├── AiService.java
│   │   │   │   └── AiServiceImpl.java
│   │   │   ├── dto/
│   │   │   │   ├── AiRequest.java
│   │   │   │   └── AiResponse.java
│   │   │   ├── util/
│   │   │   │   └── AiDataLoader.java
│   │   │   └── exception/
│   │   │       └── GlobalExceptionHandler.java
│   │   └── resources/
│   │       ├── application.properties
│   │       ├── qa_data.json
│   │       └── templates/
│   │           └── home.html
│   └── test/
├── pom.xml
└── README.md

## 🚀 Getting Started

## Step 1: Clone or Download the Project
git clone https://github.com/Hind-Abhishek/spring-boot-ai-app.git

cd ai

## Step 2: Build the Project
mvn clean install

## Step 3: Run the Application
Using Maven:
mvn spring-boot:run

## Step 4: Access the Application
Open your browser and navigate to:
http://localhost:8282/api

## Application Usage
How to Use
1. Open the Application: Navigate to http://localhost:8282/api in your web browser

2. Enter a Question: Type your question in the textarea
   Example: "What is Spring?"
   Example: "What is Java?"

3. Click "Ask AI": Submit the form

4. View the Answer: The AI response will be displayed below the form

## Sample Questions
What is Spring Framework?
What is Spring Boot?
What is Java?
What is Artificial Intelligence?
What is REST API?
What is Thymeleaf?

## Data Flow
User Access (Browser)
    ↓
GET /api → AiController.showPage()
    ↓
Display home.html with form
    ↓
User enters question
    ↓
POST /api/ask → AiController.askQuestion()
    ↓
AiServiceImpl.askQuestion()
    ↓
AiDataLoader.findAnswer(question)
    ↓
Search in qa_data.json
    ↓
Return matching answer
    ↓
AiResponse object created
    ↓
Thymeleaf renders answer in view
    ↓
Display to user

## Project Architecture
## Controller Layer
AiController: Handles HTTP requests and responses
GET /api: Display the Q&A form
POST /api/ask: Process user question and return answer

## Service Layer
AiService: Interface defining service contract
AiServiceImpl: Implementation that uses AiDataLoader to find answers

## Utility Layer
AiDataLoader: Loads Q&A data from JSON file and provides search functionality

## Data Transfer Objects
AiRequest: DTO for incoming question request with validation
AiResponse: DTO for outgoing question-answer pair

## Exception Handling
GlobalExceptionHandler: Catches all exceptions and displays user-friendly error messages

## Input Validation
Question Field Validation
Required: Question must not be empty
Error Message: "Question must not be empty"
Validation Framework: Jakarta Validation
Validation errors are displayed inline on the form.

## Error Handling
All exceptions are handled globally by GlobalExceptionHandler:
Error Scenarios:
Empty question ->	Show validation error message
No matching answer ->	Display default message
JSON file not found	-> Load empty list
Runtime exception	-> Display error message
