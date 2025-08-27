# Automation framework

Dependencies:

- Java JRE (14 or above)
- Gradle

Please specify user and password in src/test/java/apiEngine/APIServiceBase.java

Technologies and tools:

- Java;
- Junit - to execute tests locally;
- [Cucumber](https://cucumber.io/docs/guides/overview/) - to run the steps of the Gherkin scenarios;
- [REST Assured](https://rest-assured.io/) - to handle REST API requests;
- IntelliJ - IDE.

It is a GRADLE project, meaning all the dependencies are in the gradle.build file, allowing anyone to
easily clone the project on their local machine.

The project is structured in 3 main parts:

- Requests (one java class for each endpoint of the application)
- Step Definitions (one java class for each screen of the application containing the Given / When /
  Then steps)
- Feature files (one feature file for each feature of the application containing the actual gherkin
  scenarios)

## Setup and execution

- [With an IDE](#with-an-ide)
- [Without an IDE](#without-an-ide)

### With an IDE

#### Setup

1. Make sure you have installed Java SE 1.8 or higher on your machine;
2. Clone the repository;
3. Open your IDE (Eclipse, IntelliJ, etc);
4. Import the project into IDE;
5. Wait until all dependencies are downloaded and installed;
6. Download the necessary drivers that you will be using (ChromedDriver, EdgeDriver,
   etc.); (the files need to be signed in order to be able to use them on RBI machines);
7. Set the drivers path in the PATH environment variable (you can also set the path from the IDE Run Configuration window);

