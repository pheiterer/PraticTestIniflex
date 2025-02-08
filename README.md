# PraticTesteIniflex

## Overview

PraticTesteIniflex is a Java-based project that demonstrates various operations on a list of `Person` and `Employee`
objects, such as filtering, sorting, and grouping. The project uses Maven for dependency management and build
automation.

## Prerequisites

- Java 22
- Maven 3.6.3 or higher

## Project Structure

- `src/main/java/org/main/Main.java`: Contains the main class with the application logic.
- `src/main/java/org/data/DbContext.java`: Manages the list of `Person` and `Employee` objects.
- `src/main/java/org/model/Person.java`: Represents a person with basic attributes.
- `src/main/java/org/model/Employee.java`: Extends `Person` and adds employee-specific attributes.
- `pom.xml`: Maven configuration file.
- `.idea/`: IntelliJ IDEA project configuration files.

## Dependencies

- `org.json:json:20231013`
- `org.junit.jupiter:junit-jupiter:5.8.1` (test scope)

## Setup

1. Clone the repository:
    ```sh
    git clone <repository-url>
    cd PraticTesteIniflex
    ```

2. Build the project using Maven:
    ```sh
    mvn clean install
    ```

3. Run the application:
    ```sh
    mvn exec:java -Dexec.mainClass="org.main.Main"
    ```

## Running Tests

To run the tests, use the following Maven command:

```sh
mvn test
```