Feature: Customers

	Background: Below are the common steps for each scenario
		  Given User Launch the browser
    	When User opens the URL "https://admin-demo.nopcommerce.com/admin/"
    	And User enters Email as "admin@yourstore.com" and Password as "admin"
    	And Click on Login
    	Then User can view Dashboard
	@Sanity	
  Scenario: Add a New Customer
    	When User click on Customers menu
    	And Click on Customers menu Item
    	And Click on AddItem
    	Then User can View Add new Customer Page
    	When User can enter customer info
    	And Click on Save button
    	Then User can view confirmation message "The new customer has been added successfully."
    	And Close browser 
   
  @Regression 	
  Scenario: Search Customer by EmailID
    	When User click on Customers menu
    	And Click on Customers menu Item
    	And Click on customer Email
    	When Click on Search button
    	Then User should found Email in the Search Table
    	And Close browser
  
  @Regression  	
	Scenario: Search Customer by Name
    	When User click on Customers menu
    	And Click on Customers menu Item
    	And Enter customer FirstName
    	And Enter customer LastName
    	When Click on Search button
    	Then User should found Name in the Search Table
    	And Close browser
			
 
