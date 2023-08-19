# Custom Dictionary - Java Project

## Overview

The Custom Dictionary is a Java-based application designed to help users save and learn new words. It provides a user-friendly interface and includes various features, such as word saving, dictionary lookup, and additional functionalities to enhance the learning experience.

📚 **Word Saving:** The application allows users to save words they want to learn. Users can add words, provide definitions, and add additional notes for each entry.

🔍 **Dictionary Lookup:** Users can search for words in the built-in dictionary. The application retrieves word definitions and displays them to the user, helping them expand their vocabulary.

✏️ **Notes and Examples:** Users can add notes and examples for each word entry, which can be useful for memorization and contextual understanding.

🔖 **Word Categorization:** The Custom Dictionary allows users to categorize words into different groups or topics. This feature assists users in organizing their word entries based on their preferences.

🔥 **Flashcards:** The application provides a flashcard mode to aid in word memorization. Users can review saved words in a randomized order, test their knowledge, and mark their progress.

🌍 **Multi-language Support:** The Custom Dictionary supports multiple languages, enabling users to save and learn words from various linguistic backgrounds.

📊 **Progress Tracking:** The application tracks user progress, including the number of words learned and the overall learning curve. This feature motivates users and helps them monitor their language learning journey.

The Custom Dictionary API is a Java Spring Boot application that leverages various technologies to provide a secure and scalable API for managing word entries. The key technologies used in this project include:

Spring Boot: A framework that simplifies Java application development by providing a pre-configured environment and easy-to-use tools.
JPA (Java Persistence API): A Java specification that simplifies database interaction by mapping Java objects to database tables.
Java Security: The built-in security features provided by Java, including authentication, authorization, and encryption, to ensure secure access to the API endpoints.
MySQL: An open-source relational database management system used for storing and retrieving data.
Project Structure
The Custom Dictionary API follows a standard Spring Boot project structure, which organizes the codebase for maintainability and extensibility. The main directories and files include:

src/main/java: Contains the Java source code for the project.
com.example.customdictionary: The root package for the project.
CustomDictionaryApiApplication.java: The main entry point of the application.
config: Directory for configuration classes, including security configurations.
controller: Directory for API controllers that handle incoming requests and generate responses.
model: Directory for entity classes representing word entries and other related objects.
repository: Directory for JPA repositories, providing database access and CRUD operations.
security: Directory for security-related classes, including authentication and authorization filters.
service: Directory for service classes that handle business logic and interact with repositories.
Database Configuration
The Custom Dictionary API uses MySQL as the database backend. The database configuration can be found in the application properties file (application.properties). Here, you can specify the database URL, username, password, and other related settings. Make sure to configure this file according to your MySQL setup before running the application.

Security
The API incorporates Java Security features to ensure secure access to its endpoints. This includes implementing authentication and authorization mechanisms to authenticate users and control their access rights. Security configurations and filters can be found in the config and security packages, respectively.

Dependencies
The Custom Dictionary API relies on various dependencies, including:

Spring Boot Starter Web: Provides the necessary libraries and configurations for building RESTful APIs.
Spring Data JPA: Simplifies database operations and interaction with the MySQL database.
Spring Security: Offers a robust security framework for securing the API endpoints.
MySQL Connector/J: Provides the JDBC driver for connecting to the MySQL database.
