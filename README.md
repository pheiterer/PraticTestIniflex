# PraticTesteIniflex

## Overview

PraticTesteIniflex is a Java-based project that test the abilities of a developer to create a simple application
with all the basic concepts of Java programming language.

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
    git clone https://github.com/pheiterer/PraticTestIniflex
    cd PraticTesteIniflex
    ```

2. Build the project using Maven:
    ```sh
    mvn clean install
    ```