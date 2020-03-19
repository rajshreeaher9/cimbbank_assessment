Feature: upload functionality check 

Scenario Outline: File upload 
    Given 	user on upload page
	When    user upload a file named as "<filename>" and clicks [Upload] 
	Then    next screen should show "File Uploaded!" as title and filename "<filename2>"
	
Examples:
	
	| filename		| filename2		|
	| burrito.jpg	| burrito.jpg	|