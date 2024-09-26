
# RestAssured Java+ TestNG automation framework

This is a java based automation framework using TestNG to automate the Rest APIs. 

## Documentation

[Project hierarchy]

The project is based on Maven as a build tool and so all the packages and classes are organized in a proper manner.
  

 
---------------------------------

/src/main/java contains four packages.

  1.APIs package-It has 1 class and 6 methods to perform different HTTP operations.

  2.Config package:-It has 1 class having the final and static string constants for endpoints.

  3.Custom Listeners package: It has 2 classes to create extent report
  
  4.Models package: It has 4 POJO classes to serve as request body for different APIs.
  
  5.Test Base package: It has a base class having @BeforeTest method to do the test setup and to set the base URI.

6. Utilities package: It has commonly used static methods spread across 3 classes to re-use them across the framework to enable re-useability and easy maintenance.
RestRequestUtils- This class has actual restassured methods implementation and to return the specific response.
TestDataUtil: This class is used to read properties file and also to set the data in the POJO class setter methods.
TokenManager: This class is having the getToken() method to return the token to be used for PUT and DELETE requests.

/src/main/resources :It has one .xml file.

log4j2- It has all the logging setup and required Appender to setup file location, level of log to be captured and patterns of the logs content

/src/test/java –It has one folder and has below class-
AllBookingTest: It has six  @Test methods having proper assertions to ascertain that the request is successful

/src/test/resources –It has 2 folders and 1 json file
A. Properties folder : It’s having all the required test data and serve as data provider . 
B.TestNG Suite Files folder: It has 1 testng.XML file having one consolidated test of the test package 
C. bookingSchema.json : This is having the schema of the create booking response. 

Current test results: It has html extent report file, it will be the latest or last run report.

Logs: This folder has the log file which gets created per day wise.
## Running Tests

To run tests,there are 2 ways.

1.Run the following command after going to the project home directory.

Note: Make sure maven is installed on the machine

```bash
  maven test
```


2. In the IDE such as Eclipse IDE, on the project fodler right click and select Run As > Maven Test

Note: TestNG xml file is available under src/test/resources folder name TestNG_SuiteFiles


## Logs

To check the logs, go to Logs folder under the project home directory

You will see log files created per day wise.

## Prerequisites

Before running the test cases , make sure   MAVEN_HOME and JAVA_HOME is set in the system variables of the system on which it will be run.
 
 No VPN is connected so that dependencies can be downloaded.
## Authors

- [@anilkumar](https://www.linkedin.com/in/anilkumarqa/)


## Demo

Insert gif or link to demo


## Environment Variables

To run this project, you will need to add the following environment variables to your .env file

`JAVA_HOME`
`MAVEN_HOME`



