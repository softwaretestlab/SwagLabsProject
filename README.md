Java Maven Cucumber BDD setup and running process
--------------------------------------------------
Step-1: download and install Java-17 on your local machine
Java Environment Variables setup:
JAVA_HOME:C:\Program Files\Java\jdk-17.0.6
Path:C:\Program Files\Java\jdk-17.0.6\bin

Step-2: download maven and unzip and copy the maven folder under C:\Program Files
Download link below:
https://dlcdn.apache.org/maven/maven-3/3.9.6/binaries/apache-maven-3.9.6-bin.zip
Maven Environment Variables setup:
MAVEN_HOME: C:\Program Files\apache-maven-3.9.6
Path: C:\Program Files\apache-maven-3.9.6\bin

Step-3: GitHub
Install Git [https://git-scm.com/download/win]
clone repo from GitHub:
git clone https://github.com/softwaretestlab/SwagLabsProject.git

Step-4: Intellij Install [https://www.jetbrains.com/edu-products/download/download-thanks.html?platform=windows]
or
in cmd navigate to the location were this project is cloned to and type below command
mvn clean install
Ex:  C:\Users\softw\IdeaProjects\SwagLabsProject> mvn clean install

this command will run all the cucumber BDD's inside the project and a Cucumber JVM report gets generated under target folder
open this folder and you will see the test results.
Ex: Location of BDD report
C:\Users\softw\IdeaProjects\SwagLabsProject\target\cucumber-JVM-reports\cucumber-html-reports



