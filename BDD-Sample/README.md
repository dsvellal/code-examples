Hello!
Thank you for considering going through the sample for test-driven-development and business-driven-development, written by folks @ Software Center of Excellence (SWCoE), Philips.

You can contact SWCoE team, or ping me - dsvellal@philips.com, and we can get into an exploratory call on how SWCoE team can engage with your team and relevant stakeholders and add value. 

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


Project setup:
1. Change directory to a comfortable folder location.
-- I have this project setup in: C:\Users\320038909\OneDrive - Philips\Documents\SWCoE\2019\20190801_TDD\Code
2. Clone the git project, by running the following command on git-bash: git clone https://tfsemea1.ta.philips.com/tfs/TPC_Region22/SW_CoE/_git/SWCoEXpers-Workshop-Examples
3. Open eclipse's workspace, and import the maven project by doing the following: 
-- Navigate to File > Import > Maven > Existing Maven Projects > Next
-- In the "Root" directory option, paste the location where the git-project was cloned. In my case, it is: "C:\Users\320038909\OneDrive - Philips\Documents\SWCoE\2019\20190801_TDD\Code\SWCoEXpers-Workshop-Examples\TestDrivenDevelopment\xpers.samples.tdd"
-- Click on "Browse" and ensure that a "pom.xml" shows up in the options
-- Select the pom.xml & click "Finish".
-- Wait for the maven dependencies to resolve.


Running the project:
1. Right click on the project, and select: Run As > Maven clean
2. Right click on the project, and select: Run As > Maven install
3. Navigate to "src/test/java", right click on the folder & select: Run As > JUnit Test
4. Navigate to "src/test/resources/" and double click on "anagram.feature" file. On the editor, right click & select: Run As > Cucumber Feature