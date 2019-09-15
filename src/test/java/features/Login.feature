Feature: Mercury Tours Application Test

Scenario Outline: Validating login into test application
Given Browser is Initialized
And User navigates to <baseURL> site
When user enters <username> and <password>
And clicks on login button
Then Dashboard page is displayed and browser is closed

Examples:
|baseURL						|username		|password		|
|http://newtours.demoaut.com/	|adminuser1		|test123		|
|http://newtours.demoaut.com/	|testuser		|test123		|

Scenario Outline: Validating page title
Given Browser is Initialized
And User navigates to <baseURL> site
Then Page title is compared and browser is closed

Examples:
|baseURL						|
|http://newtours.demoaut.com/	|