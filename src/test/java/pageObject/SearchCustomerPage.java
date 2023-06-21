package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class SearchCustomerPage extends BasePage
{
	
	public SearchCustomerPage(WebDriver d)
	{
		super(d);
	}

	//Locators
	@CacheLookup@FindBy(xpath = "//input[@id='SearchEmail']") WebElement txtEmail;
	
	@CacheLookup@FindBy(id="SearchFirstName") WebElement txtFirstName;
	
	@CacheLookup@FindBy(id="SearchLastName") WebElement txtLastName;
	
	/*
	@CacheLookup@FindBy(id="SearchMonthOfBirth") WebElement drpMonth;
	@CacheLookup@FindBy(id="SearchDayOfBirth") WebElement drpDay;
	
	@CacheLookup@FindBy(id="SearchRegistrationDateFrom") WebElement txtRegistrationdatefrom;
	
	@CacheLookup@FindBy(id="SearchRegistrationDateTo") WebElement txtRegistrationdateto;
	
	@CacheLookup@FindBy(id="SearchLastActivityFrom") WebElement txtLastactivityfrom;
	
	@CacheLookup@FindBy(id="SearchLastActivityTo") WebElement txtLastactivityto;
	
	@CacheLookup@FindBy(id="SearchCompany") WebElement txtCompany;
	
	@CacheLookup@FindBy(id="SearchIpAddress") WebElement txtIPAddress;
	
	@CacheLookup@FindBy(xpath ="//li[text()='Administrators']") WebElement lnkItemCustomerrolesAdministrators;
	@CacheLookup@FindBy(xpath ="//li[normalize-space()='Forum Moderators']") WebElement lnkItemCustomerrolesForumModerators;
	@CacheLookup@FindBy(xpath ="//li[text()='Guests']") WebElement lnkItemCustomerrolesGuests;
	@CacheLookup@FindBy(xpath ="//li[text()='Registered']") WebElement lnkItemCustomerrolesRegistered;
	@CacheLookup@FindBy(xpath ="//li[text()='Vendors']") WebElement lnkItemCustomerrolesVendors;
	*/
	@CacheLookup@FindBy(xpath ="//button[@id='search-customers']")WebElement btnSearch;
	//Tables
	@CacheLookup@FindBy(xpath = "//div[@id='customers-grid_wrapper']")WebElement table;
	@CacheLookup@FindBy(xpath = "//div[@id='customers-grid_wrapper']//tbody//tr") List<WebElement> tableRows;
	@CacheLookup@FindBy(xpath = "//div[@id='customers-grid_wrapper']//tbody//tr//td")List<WebElement> tableColumns;
	
	//Action Methods
	public void setEmail(String email) throws InterruptedException
	{
		System.out.println("Email******"+email);
		//waitHelper.waitForElement(txtEmail, 30);
		txtEmail.sendKeys(email);
		Thread.sleep(1000);
	}
	
	public void setFirstName(String firstName)
	{
		//waitHelper.waitForElement(txtFirstName, 30);
		txtFirstName.clear();
		txtFirstName.sendKeys(firstName);
	}
	
	public void setLastName(String lastName) throws InterruptedException
	{
		//waitHelper.waitForElement(txtLastName, 30);
		txtLastName.clear();
		txtLastName.sendKeys(lastName);
		Thread.sleep(1000);
	}
	
	public void ClickSearchButton() throws InterruptedException
	{
		//waitHelper.waitForElement(btnSearch, 30);
		btnSearch.click();
		Thread.sleep(1000);
	}
	
	public void webTable()
	{
		
	}
	
	public int getNoOfRows()
	{
		return tableRows.size();
	}
	
	public int getNoOfColumns()
	{
		return tableColumns.size();
	}
	
	public boolean SearchCustomerByEmail(String email)
	{
		boolean flag = false;
		
		for(int i=1;i<=getNoOfRows();i++)
		{
			String GetValue = d.findElement(By.xpath("//div[@id='customers-grid_wrapper']//tbody//tr["+i+"]//td[2]")).getText();
			if (GetValue.equals(email)) 
			{
				flag =true;
			}
		}
		return flag;
		
	}
	
	public boolean SearchCustomerByName(String Name)
	{
		boolean flag = false;
		
		for(int i=1;i<=getNoOfRows();i++)
		{
			String name = d.findElement(By.xpath("//div[@id='customers-grid_wrapper']//tbody//tr["+i+"]//td[3]")).getText();
			if(name.equals(Name))
			{
				//Separating First name and last name
				String[] names = name.split(" ");
				if(names[0].equals("John")&&names[1].equals("Smith"))
				{
					flag =true;
				}
			}	
		}
		return flag;	
	}
}
