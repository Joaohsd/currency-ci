[![Cuurency Converter CI](https://github.com/Joaohsd/currency-ci/actions/workflows/maven.yml/badge.svg)](https://github.com/Joaohsd/currency-ci/actions/workflows/maven.yml)

# Currency Converter 💱

This Java project is a currency converter application that utilizes the [Free Currency API]((https://freecurrencyapi.com/)) to estimate currency conversion rates.

## Overview ℹ️

The Currency Converter application allows users to convert currencies using real-time exchange rates retrieved from the Free Currency API.

## Dependencies 🛠️

- Java Development Kit (JDK) 17+
- JUnit5
- Mockito
- Gson

## Installation 📥

1. Clone the repository to your local machine:

```bash
git clone https://github.com/Joaohsd/currency-ci.git
```

2. Navigate to the project directory:

```bash
cd currency-ci
```

3. Run the tests ✔️

```bash
mvn clean site
```

You can find the reports in `target/site` folder.

4. Build the project 🚀:

```bash
mvn clean install
```

## Usage 🚀

1. Run the application:

```bash
java -jar out/file.jar <value> <from_code> <to_code>
```
