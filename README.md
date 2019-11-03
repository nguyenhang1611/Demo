# Login DEMO: how to run on local machine
1. Install Java 11
2. Install Maven 3.5.4
3. Clone code to local machine and run

```
1. Install JAVA JDK:
	- Download Java 11.
	- Setup Java 11 and Environment Variable. 
	- Open terminal and check Java JDK version by command: java –version
```
```
2. Install MAVEN:
	- Download Maven 3.5.4 and unzip.
	- Setup Environment Variable. 
	- Open terminal and check Maven version by command: mvn –version
```
 
```
3. Clone code to local machine and compile:
	- Clone code from Github. Link: https://github.com/nguyenhang1611/Demo.git
	- Open terminal and cd to folder contain pom.xml file
	- Run command: mvn clean install

```

# Login DEMO: how to run on Jenkins
1. Install Jenkins
2. Install Plugin, Config Global Tools
3. Create and Config Jenkins Job
4. Run Jenkins Job and check result

```
1. Install Jenkins
     - Download Jenkins and Setup. Link: https://jenkins.io/download/	      
```
```
2.  Install Plugin, Config Global Tools:
     - Install Maven Integration Plugin: "Manage Jenkins" => "Manage Plugins" => "Available" => Install "Maven Integration" and Restart Jenkins
     - Config JDK, GIT, Maven: "Manage Jenkins" => "Global Tool Configuration"
       (1) JDK: Config "JAVA_HOME" (is $JAVA_HOME of local machine)
       (2) Git: Config "Path to Git executable" is 
       (3) Maven: TICK "Install automatically" => Select "Version 3.5.4"
```
 
```
3. Create and Config Jenkins Job:
	- Create Job: "New Item" => Input project name is "Maven Project" => Select "Maven Project" => OK
	- Config Job: Click menu icon at the right side of "Maven Project" => Select "Configure":
	  (1) Click "Source Code Management" Tab => Select "Git" => Setting:
	  Repository URL: https://github.com/nguyenhang1611/Demo.git
	  Branch Specifier (blank for 'any'): */master
	  (2) Click "Build" Tab => Setting:
	  Root POM: pom.xml
	  Goals and options: test
	  (3) Click "Apply" => Click "Save"
```

```
4. Run Jenkins Job and check result:
	- Run Job: At the homepage, Click "Maven Project" => Click "Build Now"
	- Check Result:
	At "Build History" item => Click the build item(ex: #1) => Click "Console Output"
```