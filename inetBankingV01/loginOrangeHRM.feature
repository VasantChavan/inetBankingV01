Feature: Test OrangeHRM login functionality 

Scenario: Check login is successful with valid credentials 
	When browser is open 
	And user is on login page 
	When user enters username and passsword 
	And click on login button 
	Then user is navigate to the home page 