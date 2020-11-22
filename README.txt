/******************************************************************************************************************************
Author: Manish Gairola
Project Name: Amazon Demo Project on Android physical device
File Name: SampleTest
Date Created: 10 July 2020
About: Contains the Demo amazon test

Technical Environment:
1) JDK 1.8
2) Eclipse Version 2020-06 (4.16.0)
3) Appium - Version 1.15.1
4) log4j - log4j2
5) Extent Report: Extent Repot V4
5) TestNG : 6.14.3
6) Android 6.0 Physical Device
7) Amazon.APK


About the Project: This framework used to create this project is TestNG and Page Object Model approach has been used

Snapshot of the components of the framework
1) TestNG Listeners: Located @ src/main/java/com.listeners package
2) log4j2 Logging- To log the events. File @ logs/application.log
3) log4j properties: Located @ src/main/resources/log4j2.properties
4) Extent Report: Extent Report 4 . File Name "extent.html" located @ the project root folder. ScreenShots have not been  implemented
5) testng.xml : Drives the Execution. Located @ Root Project folder
6) pom.xml : Contains all the dependencies. Located @ Root project folder
7) Application : amazon.apk file @ src/test/resources/app/android/amazon.apk
8) txtData.xml : Manages the static text used in the data. Located @ src/test/resources/txtData/txtData.xml
9) Json file: Used to manage the test data. Located @ src/test/resources/data/sampleTest.json
10) Page Objects at @ src/test/java/com.amazon.pages package
11) Sample test case @ src/test/java/com.amazon.tests package
12) Config Properties: To store environment variables. Located @ src/main/resources/config.properties
#******************************************************************************************************************************/

