# challengeCode

## Description
The present application is a web application that retrieves the weather information from https://openweathermap.org

The search is done by city by means of a simple html form with the city name as input.

### Versioning
	-1.0.0
	
	By Erick García Ramírez
	
### TODO


## Built

### Built With
* Maven 
* Spring
* SpringBoot

You need to have installed:

 - Java 1.8
 - Maven 3.3
 - IDE (STS, Eclipse, Intellij) 
 - lombok installed on IDE
 
 
 Instructions:
 
 execute the following command on your cmd or terminal prior to launch the application on your local machine:
 
  
  
```console
	$ mvn clean install
```

then execute the following to run your application:

```console
	$ mvn spring boot:run
```

you can also execute the jar directly in case that you were unable to execute the previous command:

```console
	$ mvn java -jar target/weather-search-0.0.1-SNAPSHOT.jar
```

Or from STS right click on the project -> Run As -> Spring Boot App
for Eclipse right click on the project -> Run As -> Java Application

### Reporting

To verify the quality code reports in terms of checkstyle, bugs, PMD and coverage. Execute the following:

```console
	$ mvn clean install site -Pdevelopment_reporting
```

After the execution enter to the target folder and open the index.html page. That includes the reports mentioned as 'Project Reports'

### Up and running

Open your browser and search for http://localhost:8080/weather. A simple form will be displayed with an input box so you can type the city of your preference.

Type London or Hong Kong. Click Submit and the weather information will be displayed. In case you type any other city the app will display the error message "*Invalid city".




