# Automation Task
 Automation Task
This project automates the User Registration and Login process using Selenium WebDriver and TestNG for testing on LetCode.

Tools & Frameworks
Java
Selenium WebDriver
TestNG
WebDriverManager for managing browser drivers
Prerequisites
JDK 17 or higher
Maven
Chrome Browser
Setup & Run
Clone the repo:
git clone https://github.com/your-repo/automation-task.git
Install dependencies:
mvn clean install
Run the tests:
mvn test
Features
Tests user registration with valid and invalid data
Tests login functionality with valid credentials
Data-driven testing using TestNG's DataProvider
Parallel test execution through TestNG suite
Test Structure
configDriver: WebDriver setup and teardown
login: Test for login functionality
registration: Test for user registration
loginPage & registrationPage: Page Object Model for login and registration elements
Future Enhancements
Integrate with CI/CD
Add load and performance testing
