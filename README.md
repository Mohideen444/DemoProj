# DemoProj


**Framework introduction:**

- This a BDD framework developed using *Java, Selenium, Maven and Cucumber*
  
- This framework is adaptable to both *Windows and Linux* OS environments and we can execute it on different browsers like *Chrome and Firefox*
  
- I have included **log4j** logging mechanism
  
- Added **Allure report** for reporting
  
- Added the **screen recording** functionality as well
  
- I have applied different design patterns like *POM, Singleton and Facade in this framework*


**Framework structure:**

- **src/main/java** - This folder contains the framework level configurations, libraries, page objects, step  definitions, Json getter classes
  
- **src/test/java** - This folder contains the cucumber runner file
  
- **src/test/resources** - The cucumber Feature files and the log4j property file
  
- I maintain the **Testdata** folder in the project level in hierarchy to stay away from the src folders. This enable the users to execute the created Jar files without compiling the project every time after changing the test data.
  
- Created **Uploads** and **Downloads** folders in project level to maintain the uploads and downloads during execution
  
- *POM.xml* - This is a main part of maven framework which contains the project information, dependencies, plugins etc.


**PLEASE EXPLORE THE DEMOPROJ FRAMEWORK FOR MORE DETAILS**
