# Buggy Cars Rating automation

The project aims at creating automated tests for the Buggy Cars Rating application located at https://buggy.justtestit.org/.
The testing framework is developed with Selenium, Cucumber and JUnit keeping in mind Behaviour Driver Development. It would also generate an HTML report and take snapshots in case of failures.

Documents for Test Approach and discovered Defects can be found in the /testDocuments directory 

### Tools used:
* Cucumber-jvm: 5.3.0
* Selenium: 3.13.0
* Junit: 4.13
* Java: JDK 17
* Maven: 3.9.2

### Pre-requisites
* jdk 1.8 and above
* maven
* Intellij 
* Latest Webdriver (depending on the type and the version of the browser used)

### Execution instructions

Execute the 'RunCucumberTest' class in IntelliJ
or Run the project using the command line with: mvn clean test

Results and reports can be found under /target/cucumber-reports

