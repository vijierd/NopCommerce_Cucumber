
Feature: Multiple Login
	@Regression 
	Scenario Outline: Login Using Data Driven
  		Given User Launch the browser
    	When User opens the URL "https://admin-demo.nopcommerce.com/admin/"
    	And User enters Email as "<email>" and Password as "<password>"
    	And Click on Login
    	Then Page Title should be "Dashboard / nopCommerce administration"
   		When User click on logout link
   		Then Page Title should be "Your store. Login"
    	And Close browser
  
    Examples: 
      | email								| password 	| 
      | admin@yourstore.com |		admin		| 
      | admin1@yourstore.com|  admin		| 
