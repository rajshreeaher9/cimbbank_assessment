Feature: login functionality check 

Background:
    Given 	user on login page
    
Scenario:
	When 	user clicks on the Login button 
	Then 	an error message stated "Your username is invalid!" appear 
	
Scenario: Login success 
	When 	user fill in username, password and clicks on Login button 
	Then   	a successful message stated "You logged into a secure area!" appear 
