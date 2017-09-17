# gauge-java-maven-restassured-demo

This is an example project, illustrating how to do API test automation using [Gauge](https://github.com/getgauge/gauge) test automation framework, with Java, REST Assured  support.

This project uses

- [Gauge](http://getgauge.io/)
- Gauge Java plugin
- [Java 1.7](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) or above
- [REST Assured ](http://rest-assured.io/)


# Concepts covered

- REST Assured usage
- Specs

# Prerequisites

- [Install Gauge](http://getgauge.io/download.html)
- [Install Java 1.7](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Refer REST Assured](https://github.com/rest-assured/rest-assured/wiki/GettingStarted)
- [Install Gauge-Java plugin] by running
  ````
  gauge install java
  ````

## System Under Test (SUT)

```
Use the /env/default/api.properties accordingly.
```
* The SUT should be available at [https://www.googleapis.com/](https://www.googleapis.com/books/v1/volumes)

# Executing specs

### Set up
This project requires maven to install dependencies. To install dependencies re-import maven dependencies using IntelliJ IDEA.
Modify /env/default/appium.properties

### All specs
````
mvn gauge:execute -DspecsDir=specs
````
This will also compile all the supporting code implementations.

