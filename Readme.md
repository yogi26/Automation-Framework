
## 🚀 About Me
I'm a Test Automation Engineer with a strong foundation in Java, Selenium, Playwright, and API testing tools like RestAssured. I believe in writing clean, scalable, and maintainable automation code that not only tests software but adds real value to the development lifecycle.


## Authors

- [@yogi26](https://github.com/yogi26)
- Email-Address: yogi.giri263@gmail.com



## 🔗 Links
[![portfolio](https://img.shields.io/badge/my_portfolio-000?style=for-the-badge&logo=ko-fi&logoColor=white)](https://github.com/yogi26)

[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/yogesh-giri-66b690193/)

## Pre-Requisites

Ensure you have the following installed:
1. **Java Development Kit (JDK 11)**
2. **Apache Maven**
3. An active **LambdaTest** account (for cloud execution)
4. IDE (e.g., IntelliJ IDEA, Eclipse) for development

## Project Structure

| Folder/File        | Description                                                                 |
|--------------------|-----------------------------------------------------------------------------|
| `src/test/java`    | Contains test scripts and page object model classes.                       |
| `src/main/resources`| Configuration files (e.g., test data, properties).                        |
| `logs/`            | Directory where logs generated by Log4j are stored.                       |
| `report.html`      | Extent report generated after test execution.                              |
| `pom.xml`          | Maven POM file to manage dependencies and build configuration.             |


## Setting Up the Framework

1. Clone or download the repository to your local system:
      git clone <repository-https://github.com/yogi26/Automation-Framework>
      
      cd test-automation-framework
2. Install dependencies:
      mvn clean install

# Running Tests
### Command Line Execution
To run the tests from the command line, use the following command:  
``` bash 
mvn test -Dbrowser=<browser_name> -DisHeadless=<true|false> -DisLambdaTest=<true|false>
```

### Example Command
``` bash
mvn test -Dbrowser=chrome -DisHeadless=true -DisLambdaTest=true
```

## Parameters  
1. **browser**: Specify the browser to run tests on (e.g., chrome, firefox). 
2. **isHeadless**: Set to true for running in headless mode; false for regular mode.
3. **isLambdaTest**: Set to true if you want to run tests on LambdaTest; otherwise set to false.

### Example Command
mvn test -Dbrowser=chrome -DisHeadless=true -DisLambdaTest=true

# Reports and Logs
1. **Extent Report**: The execution report will be generated as report.html in the project root folder.
2. **Log Files**: The logs will be created in the logs/ folder, managed by Log4j.

## Integrated the project with Github Actions
This automation framework is integrated with github actions.
 # Test Automation Framework

## Overview

This Java-based test automation framework is designed using **Page Object Model (POM)** and caters to data-driven testing needs. It integrates several libraries for functionalities and supports running tests locally or on the cloud via LambdaTest. Below, you'll find detailed instructions on setting up, running, and understanding the framework.

This is a comprehensive Java-based test automation framework built with the following features:

**Design Pattern**: Page Object Model

**Java Version**: Java 11

**Testing Framework**: TestNG

**Data-Driven Testing**: OpenCSV, Apache POI, Gson

**Test Data Generation**: Java Faker

**Execution Options**: Local (headed/headless) and Cloud (LambdaTest)

**Reporting**: Extent Reports

**Logging**: Log4j

**Build Tool**: Maven

---


