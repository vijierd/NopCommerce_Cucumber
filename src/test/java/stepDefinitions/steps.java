package stepDefinitions;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import org.apache.logging.log4j.*;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.*;
import io.cucumber.java.en.*;
import pageObject.AddCustomerPage;
import pageObject.BaseClass;
import pageObject.LoginPage;
import pageObject.SearchCustomerPage;

public class steps extends BaseClass
{
    List<HashMap<String, String>> datamap; //Data driven

   @Before
   public void setup() throws IOException
   {
       //for logging
       logger= LogManager.getLogger(this.getClass());
       
       //Reading config.properties (for browser)
       FileReader file=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");//\resources\\config.properties
		
       p=new Properties();
		p.load(file);
		br=p.getProperty("browser");
		email = p.getProperty("email");
		firstname = p.getProperty("firstname");
		lastname = p.getProperty("lastname");
   }
   
   @After
   public void tearDown(Scenario scenario) 
   {
       System.out.println("Scenario status ======>"+scenario.getStatus());
       if(scenario.isFailed()) 
       {
    	   	TakesScreenshot ts=(TakesScreenshot) d;
    	   	byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
       		scenario.attach(screenshot, "image/png",scenario.getName());
       	            
       }
      d.quit();
   }
	
	@Given("User Launch the browser")
	public void user_launch_the_browser() 
	{
		if(br.equals("chrome"))
		{
			d=new ChromeDriver();
		}
        else if (br.equals("firefox")) 
        {
            d = new FirefoxDriver();
        }
        else if (br.equals("edge")) 
        {
            d = new EdgeDriver();
        }
		
		//d=new ChromeDriver();
		d.manage().deleteAllCookies();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		lp=new LoginPage(d);
	}

	@When("User opens the URL {string}")
	public void user_opens_the_url(String url) 
	{
	    d.get(url);
	    logger.info("Browser opens the url");
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String uname, String upwd) throws InterruptedException 
	{
	    lp.setUserName(uname);
	    logger.info("Entered the username....");
	    lp.setPassword(upwd);
	    logger.info("Entered the password....");
	}

	@When("Click on Login")
	public void click_on_login() throws InterruptedException 
	{
		//bs.tearDown(Scenario);
		lp.clkLogin();
		logger.info("Clicked the login button");
		
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String title)  {
		if (d.getPageSource().contains("Login was unsuccessful.")) 
		{
			logger.error("Login was unsuccessful....");
			Assert.assertTrue(false);
		}
		else
		{
			logger.info("Get the title of the page");
			String title1 = d.getTitle();
			Assert.assertEquals(title1, d.getTitle());
		}
	}

	@When("User click on logout link")
	public void user_click_on_logout_link() throws InterruptedException 
	{
		if (d.getPageSource().contains("Login was unsuccessful.")) 
		{
			logger.error("Login was unsuccessful....");
		}
		else
		{
			lp.clklogout();
		}
	    
	}

	@Then("Close browser")
	public void Close_browser() 
	{
		if (d.getPageSource().contains("Login was unsuccessful.")) 
		{
			logger.error("Login was unsuccessful....");
		}
		else
		{
			logger.info("..........Ended with Passed Scenario...............");
		} 		
	}
	
	//******************Add Customer Details*********************************

	@Then("User can view Dashboard")
	public void user_can_view_dashboard() throws InterruptedException 
	{
		Thread.sleep(1000);
		
		Assert.assertEquals("Dashboard / nopCommerce administration", getPageTitle());	
	}
	
	@When("User click on Customers menu")
	public void user_click_on_customers_menu() throws InterruptedException 
	{
		acp = new AddCustomerPage(d);
		acp.CLickOnCustomerMenu();
		Thread.sleep(1000);
		logger.info("Click on the customer menus...");
	}
	
	@When("Click on Customers menu Item")
	public void click_on_the_customers_menu_item() throws InterruptedException {
		acp.CLickOnSubCustomerMenu();
		Thread.sleep(1000);
		logger.info("Click on the customer menu Item...");
		
	}
	
	@When("Click on AddItem")
	public void click_on_add_item() throws InterruptedException 
	{
		acp.CLickOnAddNewBtn();
		Thread.sleep(1000);
		logger.info("Click on the customer sub menu...");
	}
	
	@Then("User can View Add new Customer Page")
	public void user_can_view_add_new_customer_page() throws InterruptedException 
	{
		Thread.sleep(1000);
		Assert.assertEquals("Add a new customer / nopCommerce administration", getPageTitle());
		logger.info("Click on the add new customer");
	}
	
	@When("User can enter customer info")
	public void user_can_enter_customer_info() throws InterruptedException 
	{
		String email = randomString()+"@gmail.com";
		acp.setEmail(email);
	}
	
	@When("Click on Save button")
	public void click_on_save_button() throws InterruptedException 
	{
	   acp.CLickOnSave();
	   Thread.sleep(1000);
	   logger.info("Click on save button...");
	}
	
	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String message) 
	{
		acp.ChkConfmsg();
		logger.info("Checking the customer added message...");
	}
		
//************Search a Customer***********************************
	
	@When("Click on customer Email")
	public void click_on_customer_email() throws InterruptedException 
	{
		scp = new SearchCustomerPage(d);
	    scp.setEmail(email);
	    Thread.sleep(3000);
	    logger.info("Entered the Email id for serach Customer....");
	}

	@When("Click on Search button")
	public void click_on_search_button() throws InterruptedException 
	{
	    scp.ClickSearchButton();
	    logger.info("Click on the save button....");
	}

	@Then("User should found Email in the Search Table")
	public void user_should_found_email_in_the_search_table() 
	{
		boolean status = scp.SearchCustomerByEmail("admin@yourStore.com");
		Assert.assertEquals(true,status);
		logger.info("Checking the status of the Search Customer by Email....");	
	}
	
//***********Searching a Customer by FirstName and LastName********************	
	@When ("Enter customer FirstName")
	public void enter_customer_firstname()
	{
		scp = new SearchCustomerPage(d);
		scp.setFirstName("John");
		logger.info("Enter the First Name....");
	}
	
	@When ("Enter customer LastName")
	public void enter_customer_lastname() throws InterruptedException
	{
		scp.setLastName("Smith");
		logger.info("Enter the last name....");
	}
	
	@Then ("User should found Name in the Search Table")
	public void user_should_found_name_in_the_search_table()
	{
		boolean status = scp.SearchCustomerByName("John Smith");
		Assert.assertEquals(true,status);
		logger.info("Checking the status of the Search Customer by Name....");
	}
	
}
