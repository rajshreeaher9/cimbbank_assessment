Feature: JavaScriptAlert page functionality check 

Background:
    Given user on alert page

Scenario: Alert - JS Confirm 
	When   	user clicks on “Click for JS Confirm” button and select [OK]
	Then   	result showing JS Confirm message "You clicked: Ok"
	
Scenario: Text Verification 
	When   	user clicks on “Click for JS Prompt” button
	And 	user enters the test "Test JS Prompt" and clicks [Cancel] 
	Then    result showing JS Prompt message "You entered: null"