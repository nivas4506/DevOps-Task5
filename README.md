# Java Code Duplication & Maintainability Demo (DevOps Task 5)

A Java project designed to demonstrate **code duplication**, **high cognitive complexity**, and **maintainability code smells** for static analysis using **SonarQube** and **Apache Maven**.

---

## 📌 Overview

This repository showcases real-world Java code quality anti-patterns to test and evaluate static code analysis tools (such as SonarQube Scanner). It includes intentional code smells across multiple services:

- **Internal Duplication**: Repeated validation, calculation, and formatting logic within the same class.
- **Cross-File Duplication**: Identical business logic replicated across independent classes (`OrderProcessor` and `InvoiceProcessor`).
- **Maintainability Smells**: High cognitive complexity (deeply nested `if` statements), swallowed exceptions (empty catch blocks), string concatenation in loops, magic numbers, and unencapsulated public fields.

---

## 📁 Repository Structure

```
DevOps-Task5/
├── pom.xml                        # Maven configuration & SonarQube plugin setup
├── sonar-project.properties       # SonarQube scanner properties
├── gen_token.ps1                  # PowerShell script to generate SonarQube API user token
├── test_auth.ps1                   # PowerShell script to verify SonarQube authentication
├── config_and_logic.txt           # Detailed project configuration and business logic reference
└── src/
    └── main/
        └── java/
            └── com/
                └── example/
                    └── duplication/
                        ├── MainApp.java                # Main entry point / driver class
                        ├── OrderProcessor.java         # Class with internal code duplication
                        ├── InvoiceProcessor.java       # Class with cross-file code duplication
                        └── CustomerReportService.java  # Class with maintainability code smells
```

---

## 🛠️ Code Quality Issues Demonstrated

### 1. Internal Code Duplication (`OrderProcessor.java`)
- `processOrder()` and `processPriorityOrder()` contain identical blocks of input validation, discount calculations (VIP, Premium, Regular), tax logic, shipping rules, and output logging.

### 2. Cross-File Code Duplication (`InvoiceProcessor.java`)
- Replicates the exact validation, discount, tax, shipping, and console formatting logic from `OrderProcessor.java` in `generateInvoice()`.

### 3. Maintainability & Complexity Smells (`CustomerReportService.java`)
- **High Cognitive Complexity**: 7 levels of nested `if` conditions.
- **Swallowed Exceptions**: Empty `catch (IOException e)` and `catch (NullPointerException e)` blocks.
- **Performance Smells**: String concatenation (`line + " - PROCESSED"`) inside a file reading loop instead of using `StringBuilder`.
- **Poor Encapsulation**: Unencapsulated `public String serviceName = "ReportService";`.
- **Magic Numbers**: Unexplained numeric constants (`86400`, `3600`, `500.0`, `0.075`, `0.025`).

---

## 🚀 Prerequisites

Ensure you have the following installed on your environment:

- **Java Development Kit (JDK)**: Version 17 or higher
- **Apache Maven**: Version 3.8+
- **SonarQube Server**: Running locally at `http://localhost:9000` (optional, for running scans)
- **PowerShell**: For executing token generation & authentication helper scripts (Windows)

---

## ⚙️ Building & Running

### 1. Build the Project
Compile the Java source files using Maven:
```bash
mvn clean compile
```

### 2. Run the Main Application
Execute the application entry point:
```bash
mvn exec:java -Dexec.mainClass="com.example.duplication.MainApp"
```
Or package and run the JAR file:
```bash
mvn clean package
java -cp target/java-duplication-demo-1.0.0-SNAPSHOT.jar com.example.duplication.MainApp
```

---

## 🔍 SonarQube Integration

### 1. Configure SonarQube Server
Ensure your local SonarQube instance is active at `http://localhost:9000`.

### 2. Generate User Token (PowerShell)
To generate an authentication token from SonarQube:
```powershell
.\gen_token.ps1
```

To verify authentication:
```powershell
.\test_auth.ps1
```

### 3. Run Static Code Analysis
Trigger a SonarQube scan via the Maven plugin:
```bash
mvn sonar:sonar \
  -Dsonar.host.url=http://localhost:9000 \
  -Dsonar.login=<YOUR_SONAR_TOKEN>
```
Or run using standalone `sonar-scanner`:
```bash
sonar-scanner
```

---

## 📄 Documentation

For full details on the configuration files, API endpoints, business logic rules, and calculation formulas, refer to:
- 📖 [config_and_logic.txt](config_and_logic.txt)
- ⚙️ [pom.xml](pom.xml)
- 🔧 [sonar-project.properties](sonar-project.properties)
