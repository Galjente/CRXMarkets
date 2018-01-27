# README #

This README would normally document whatever steps are necessary to get your application up and running.

### CRXMarkets home work ###

* Quick summary
* Version 1.0.0

* Install Git
* Install Java 8
* Install Maven 3
* run app from IDE or from command line

### Clone ###
To get started you can simply clone this repository using git:
```
git clone https://github.com/Galjente/CRXMarkets.git
cd CRXMarkets
```

### Build an executable JAR
You can run the application from the command line using:
```
maven clean install tomee:run
```
When application startet you can open link http://localhost:8080/CRXMarkets

Or you can build a WAR file that contains all the necessary dependencies, classes, and resources with:
```
maven clean install
```
Then you can deploy the WAR file to servlet container.
