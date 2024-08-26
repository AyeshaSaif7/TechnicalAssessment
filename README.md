# Technical Assessment - Ayesha Saif

## Overview
This project is a technical assessment designed to demonstrate automated testing skills using Java, Selenium WebDriver, and the Cucumber framework. The tests cover various scenarios, including verifying elements on a login page, validating list items, checking dropdown selections, and more.

## Project Structure
- **src/test/java**: Contains the Java code for step definitions, utilities, and page objects.
    - **myapps.runners**: Manages the test runners for executing Cucumber tests.
    - **myapps.steps**: Includes the step definitions corresponding to the Gherkin scenarios.
    - **myapps.utils**: Utility classes for common methods used across tests.
    - **myapps.pages**: Page Object Model (POM) classes representing the web pages under test.

- **src/test/resources**: Contains the Cucumber feature files and configuration files.
    - **features**: The directory where `.feature` files are located. These files describe the test scenarios in Gherkin syntax.
    - **config**: Configuration properties used in the tests.

## Prerequisites
Before running the tests, ensure you have the following installed:
- **Java Development Kit (JDK)**
- **Maven**
- **An IDE (e.g., IntelliJ IDEA, Eclipse)**
- **Git (optional, if you want to clone the repository)**

## Setup Instructions
1. **Clone the Repository:**
   ```bash
   git clone https://github.com/yourusername/TechnicalAssessmentAyeshaSaif.git