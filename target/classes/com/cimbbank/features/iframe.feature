Feature: iFrame functionality check 

Scenario: Accessing iFrame 
	Given   user on iframe page 
	When    user type "I love pizza" in the text box 
	Then    textbox shows "I love pizza"