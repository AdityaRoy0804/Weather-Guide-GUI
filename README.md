# 🌦️ Weather Guide - Java Swing Application

A Java desktop application built with **Swing GUI** that fetches real-time weather information for any city using the [WeatherAPI.com](https://www.weatherapi.com) and stores the history in a **MySQL** database.

---

## ✨ Features

- 🔍 Get current weather for any city
- 💾 Save queried weather data to MySQL database
- 📜 View historical weather search records
- 🖥️ User-friendly GUI built with Swing
- ✅ Input validation and error handling
- 🔗 Modular, extensible, and Maven-based Java project

---

## 🧰 Tech Stack

|***** LAYER *****|***Technology***|

|------------------ |-------------|

| Language          | Java (JDK 17+)     |

| GUI Framework     | Swing             |

| API Source        | [WeatherAPI.com](https://www.weatherapi.com) |

| JSON Parsing      | org.json          |

| Database          | MySQL             |

| Build Tool        | Maven             |

---

## 📦 Maven Dependencies


<dependencies>

    <!-- JSON Parser -->
    <dependency>
        <groupId>org.json</groupId>
        <artifactId>json</artifactId>
        <version>20230618</version>
    </dependency>

    <!-- MySQL Connector -->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>8.0.33</version>
    </dependency>
</dependencies>

---

## ⚙️ Setup Instructions
### 1. 🔧 Prerequisites
Java JDK 17 or above

MySQL Server

Maven installed

Internet connection (for API)

### 2. 📥 Clone & Setup

git clone https://github.com/yourusername/WeatherGuide.git

cd WeatherGuide

### 3. 🔑 Configure API Key
Replace the API key in WeatherFetcher.java:

private static final String API_KEY = "your_actual_api_key";

### 4. 🛠️ Set Up MySQL Database

CREATE DATABASE weather_app;

USE weather_app;

CREATE TABLE weather_history (

    id INT AUTO_INCREMENT PRIMARY KEY,
    city VARCHAR(100),
    temperature VARCHAR(50),
    condition VARCHAR(100),
    humidity VARCHAR(50),
    query_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

##### Update credentials in DatabaseManager.java:

private static final String DB_URL = "jdbc:mysql://localhost:3306/weather_app";

private static final String DB_USER = "your_user";

private static final String DB_PASS = "your_password";

### 5. 🚀 Build & Run
Build with Maven: mvn clean install

Run: mvn exec:java -Dexec.mainClass="WeatherAppGUI"

Or run the WeatherAppGUI class from your IDE.

---

## 📄 License

This project is open-source and free to use.

---

## 🤝 Author
Developed by Aditya Kumar Roy
##### 📧 Gmail : roy97278@gmail.com
##### 🔗 GitHub : https://github.com/AdityaRoy0804
