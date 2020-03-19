Feature: Check the Property Affordability Calculator

Background:
    Given I am on CIMB page for calculator
   And I navigate to Tools page from menu

Scenario Outline: Accessing & using Property Affordability Calculator	
	
	When I access to Property Affordability Calculator
	And I have inputted all necessary values as "<grossmonthly>" "<monthlynet>" "<totalmonthly>" "<period>" "<rate>"
	Then I will be able to know the "<estimated monthly payment>" and "<maximum loan amount>"
	And I will see Credit Card Payment Calculator, Auto Financing Affordability Calculator and Property Monthly Installment Calculator at the bottom

Examples:

|grossmonthly|monthlynet|totalmonthly| period|rate|estimated monthly payment|maximum loan amount|
|1000000	 |800000    | 500000     | 5		| 800  |2,189.85           |108,000.00|
|	         |1000000   | 4000       | 9		| 20   | 0.00               | 0.00|
	