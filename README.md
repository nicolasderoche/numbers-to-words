# numbers-to-words
Convert numbers to words in english

## Context

Checks and certain contracts, for example, require amounts to be written out in full.

This exercise involves writing a program to automate this conversion.
This program, written in Java, must convert an integer into words (in English).
 
Here are some examples:
 - "245" is converted to *two hundred forty-five*
 - "75" is converted to *seventy-five*
 
Optional bonus: implement a REST API to perform the conversion.

> Note: Since this is an exercise designed to assess my level of computer skills, I played along without using any AI tools. As I haven't practiced Java in quite some time, I thank you in advance for your indulgence :)  

## Installation

This piece of Java code has been developped with java 24.0.2 2025-07-15 without any IDE. Just a code editor (Visual Studio Code) and a shell terminal to build, test and execute the code.

The testing part depends on [junit and hamcrest ](https://github.com/junit-team/junit4/wiki/Download-and-Install) libraries. These two libraries are shipped with the code to ease the use. Thus, everything needed is provided 

However, after cloning the GitHub repository, a shell command must be ran beforehand to initialize some shell env variables :
```
$ git clone git@github.com:nicolasderoche/numbers-to-words.git
$ cd numbers-to-words
$ . ./sourceMe
```


## Building

To build the code:
```
$ javac NumbersToWords.java 
```

## Testing

To test the code:
```
$ javac NumbersToWordsTest.java
$ java org.junit.runner.JUnitCore NumbersToWordsTest
JUnit version 4.13.2
.........
Time: 0.005

OK (9 tests)
```

## Running

To run the code:
``` 
$ java NumbersToWords 123
123 ---> one hundred twenty three

```
