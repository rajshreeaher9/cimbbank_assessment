Feature: JavaScriptAlert page functionality check 

Background:
    Given user on alert page

Scenario Outline: Click different JS Buttons and Text Verification
	When   	user clicks on JS button "<button>" 
	And     user enters the text "<textToEnter>" and selects "<choice>"
	Then    result showing "<resultMessage>"

Examples:

	| button				| textToEnter   	| choice     | resultMessage		|		
	| Click for JS Confirm	| 			      	| ok	     | You clicked: Ok		|
	| Click for JS Prompt	| Test JS Prompt   	| cancel     | You entered: null	|