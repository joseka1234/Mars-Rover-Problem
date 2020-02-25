Mars Rover Problem for **ThoughtWorks**
==

## Design Decisions

### Class Position

I created a general Position class from which derives the 2DPosition just in case we extend the position to 3D, 4D, ... ND in the future.

### Class Program

Like in the case of the position I decided to create a general Program from which derives the current LRMProgram (the program with instructions L, R and M), just in case we need to expand later the program with new commands for the rovers.

### Exceptions

I created two types of exceptions one for the exceptions derivated from executing the program of the Rover and another for the exceptions derivated from loading the data.

---

## How to execute

### Create the .data file

To load any rover data you could write a .data (preferably in the Data folder) file with the format that was passed by mail.

### Building

I use Maven to build the project so you're gonna need it.
To build the project simply execute this in the folder where the **pom.xml** file is located.:
```
mvn install
````

### Execute

To execute the program you just need to write:
```
java -jar targuet/MarsRoverProblem.jar $PathToDataFile
```
Being **$PathToDataFile** the file with Rover info that you are gonna enter.

For example:
```
java -jar targuet/MarsRoverProblem.jar .\Data\RoverData.data
```
