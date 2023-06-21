Feature: Login

	@Sanity
	Scenario: Login with valid Credentials
    	Given User Launch the browser
    	When User opens the URL "https://admin-demo.nopcommerce.com/admin/"
    	And User enters Email as "admin@yourstore.com" and Password as "admin"
    	And Click on Login
    	Then Page Title should be "Dashboard / nopCommerce administration"
   		When User click on logout link
   		Then Page Title should be "Your store. Login"
    	And Close browser
  @Regression 	
  Scenario: Login with Invalid password
  	  Given User Launch the browser
    	When User opens the URL "https://admin-demo.nopcommerce.com/admin/"
    	And User enters Email as "admin@yourstore.com" and Password as "admin123"
    	And Click on Login
    	Then Page Title should be "Dashboard / nopCommerce administration"
   		When User click on logout link
   		Then Page Title should be "Your store. Login"
    	And Close browser
    	
    	