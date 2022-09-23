Hello!
Thank you for considering going through the sample for test-driven-development and business-driven-development

Here are some helpful links of SWCoE: 
- Sharepoint: http://bit.ly/swcoe-sharepoint
- Yammer: http://bit.ly/swcoe-yammer
- GitHub: http://bit.ly/swcoe-xpers-tfs-git

-------

Note: You are free to use any of your favorite IDE(s) and Java version. 
The below sample was built using: 
- Eclipse: Neon.3 Release (4.6.3)
- Maven: 3.6.1
- Java JDK: 8

--------

Here is step by step instruction of downloading & running this program.

Pre-requisites:
1. Download & install Java: https://www.java.com/en/download/.
-- Ensure that the JAVA_HOME is correctly set, and the PATH variable is updated with the right <java-jdk>/bin location
2. Download & install JEE version of Eclipse: https://www.eclipse.org/downloads/
-- Download & install cucumber for eclipse plugin: https://cucumber.github.io/cucumber-eclipse/
3. Download & install Maven: https://maven.apache.org/download.cgi.
-- Ensure that MAVEN_HOME path is correctly set, and the PATH variable is updated with the right <maven>/bin location
4. Download a git client, if you don't have one already. For windows, Git-bash works well: https://git-scm.com/download/win
5. Setup eclipse to support Maven projects: http://bit.ly/dsvellal-setup


Running the project:
1. Right click on the project, and select: Run As > Maven clean
2. Right click on the project, and select: Run As > Maven install
3. Navigate to "src/test/java", right click on the folder & select: Run As > JUnit Test
4. Navigate to "src/test/resources/" and double click on "anagram.feature" file. On the editor, right click & select: Run As > Cucumber Feature
