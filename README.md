
# NNW Tech Solutions technical assessment

## Description

The project is a Maven Java implementation to find the Highest Common Factor of a list of integers (Question-1) and to parse a Json file (Question-2) of addresses (Postal, Physical and Business address types). For the latter question, the implementation must also validate each address type, pretty-print the content of the json file, print all addresses in the file, validate each address type and print each address type to console as per the format, (Line details - city - province/state - postal code – country).

The project is made up of a maven parent module, nnwtech-assessment and two maven child modules, highestcommonfactor and fileparser answering question one and two respectively.

### Technology API Implementation/Dependencies

- [Java 17](https://docs.oracle.com/en/java/javase/17/docs/api/)
- [Mapstruct](https://central.sonatype.com/artifact/org.mapstruct/mapstruct-processor)
- [Gson](https://central.sonatype.com/artifact/com.google.code.gson/gson)
- [Lombok](https://central.sonatype.com/artifact/org.projectlombok/lombok)
- [log4j-api](https://central.sonatype.com/artifact/org.apache.logging.log4j/log4j-api/2.20.0)
- [log4j-core](https://central.sonatype.com/artifact/org.apache.logging.log4j/log4j-core/2.22.0)
- [log4j-impl](https://central.sonatype.com/artifact/org.apache.logging.log4j/log4j-slf4j-impl/2.20.0)
- [Junit](https://central.sonatype.com/artifact/org.junit.jupiter/junit-jupiter-api)

#### Instructions (Testing and running the project)


- Question-1

  The maven module name, highestcommonfactor, provides the solution to the question. The main class of the module,za.co.nnwtech.highestcommonfactor.HighestCommonFactor.java

   In order to test the module, clone the repo:

    1. Update the inputArray variable in the main class or leave the default value.
    2. run the command, mvn clean install to genrate a fat jar
    3. run the jar generated in ../target directory with the command java -jar <jar-directory>.highestcommonfactor-0.0.1.jar
    4. HCF will be determined if it exists or otherwise as per printed on console.

- Question-2

  The maven module name,fileparser, provides the solution to the question in the java class, za.co.nnwtech.parse.AnswersFile.java. The main class of the 
  module, za.co.nnwtech.parser.JsonParser.java
  

