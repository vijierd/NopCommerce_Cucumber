package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class AddCustomerPage extends BasePage
{

	public AddCustomerPage(WebDriver d) 
	{
		super(d);
	}

	//Locators
	//@CacheLookup@FindBy(xpath = "//p[normalize-space()='Dashboard']")WebElement lnkDashboard;
	@CacheLookup@FindBy(xpath = "//a[@href='#']//p[contains(text(),'Customers')]") WebElement lnkCustomer;
	@CacheLookup@FindBy(xpath = "//a[@href='/Admin/Customer/List']//p[contains(text(),' Customers')]") WebElement sublnkCustomer;
	@CacheLookup@FindBy(xpath = "//a[normalize-space()='Add new']")WebElement btnAddNew;
	
	//@CacheLookup@FindBy(xpath = "//div[@class='card-title']")WebElement ViewCustomerPage;
	@CacheLookup@FindBy(id="Email") WebElement txtEmail;
	
	@CacheLookup@FindBy(id="Password") WebElement txtPassword;
	
	@CacheLookup@FindBy(id="FirstName") WebElement txtFirstName;
	
	@CacheLookup@FindBy(id="LastName") WebElement txtLastName;
	@CacheLookup@FindBy(id="Gender_Male") WebElement rbGenderMale;
	@CacheLookup@FindBy(id="Gender_Female") WebElement rbGenderFemale;
	@CacheLookup@FindBy(id="DateOfBirth") WebElement txtBOB;
	@CacheLookup@FindBy(id="Company") WebElement txtCompany;
	
	@CacheLookup@FindBy(id="IsTaxExempt") WebElement ChkboxIsTaxExempt;
	
	@CacheLookup@FindBy(xpath ="//li[text()='Administrators']") WebElement lnkItemCustomerrolesAdministrators;
	@CacheLookup@FindBy(xpath ="//li[normalize-space()='Forum Moderators']") WebElement lnkItemCustomerrolesForumModerators;
	@CacheLookup@FindBy(xpath ="//li[text()='Guests']") WebElement lnkItemCustomerrolesGuests;
	@CacheLookup@FindBy(xpath ="//li[text()='Registered']") WebElement lnkItemCustomerrolesRegistered;
	@CacheLookup@FindBy(xpath ="//li[text()='Vendors']") WebElement lnkItemCustomerrolesVendors;

	@CacheLookup@FindBy(xpath ="//button[@name='save']") WebElement  btnsave;
	
	@CacheLookup@FindBy(tagName = "body") WebElement confmsg;
	//action methods
	
	public void CLickOnCustomerMenu() throws InterruptedException
	{
		Thread.sleep(1000);
		lnkCustomer.click();
	}
	
	public void CLickOnSubCustomerMenu() throws InterruptedException
	{
		Thread.sleep(1000);
		sublnkCustomer.click();
	}
	
	public void CLickOnAddNewBtn() throws InterruptedException
	{
		Thread.sleep(1000);
		btnAddNew.click();
	}
	
	public void setEmail(String Uname) throws InterruptedException
	{
		Thread.sleep(1000);
		txtEmail.sendKeys(Uname);
	}
	
	public void setPassword(String pwd) throws InterruptedException
	{
		Thread.sleep(1000);
		txtPassword.sendKeys(pwd);
	}
	
	public void setFirstName(String fname) throws InterruptedException
	{
		Thread.sleep(1000);
		txtFirstName.sendKeys(fname);
	}
	
	public void setLastName(String lname) throws InterruptedException
	{
		Thread.sleep(1000);
		txtLastName.sendKeys(lname);
	}
	
	public void ClickRadioBtnMale() throws InterruptedException
	{
		Thread.sleep(1000);
		rbGenderMale.click();
	}
	
	public void ClickRadioBtnFemale()
	{
		rbGenderFemale.click();
	}
	
	public void setDOB(String dob)
	{
		txtBOB.sendKeys(dob);
	}
	
	public void setCompany(String cpy)
	{
		txtCompany.sendKeys(cpy);
	}
	
	public void CLickOnSave()
	{
		btnsave.click();
	}
	
	public void ChkConfmsg()
	{
		confmsg.getText().contains("The new customer has been added successfully.");
		
	}
	
}
