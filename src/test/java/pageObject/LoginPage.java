package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage
{
	public LoginPage(WebDriver d) 
	{
		super(d);	
	}
	@CacheLookup@FindBy(xpath = "//input[@id='Email']") WebElement txtUserName;
	@CacheLookup@FindBy(id = "Password") WebElement txtPwd;
	@CacheLookup@FindBy(xpath = "//button[text()='Log in']")WebElement btnSubmit;
	@CacheLookup@FindBy(xpath = "//a[text()='Logout']")WebElement lnkLogout;
	
	public void setUserName(String uname) throws InterruptedException
	{
		//"admin@yourstore.com"
		txtUserName.clear();
		Thread.sleep(1000);
		txtUserName.sendKeys(uname);
	}
	public void setPassword(String upwd) throws InterruptedException
	{
		//admin
		txtPwd.clear();
		Thread.sleep(1000);
		txtPwd.sendKeys(upwd);
	}
	public void clkLogin() throws InterruptedException 
	{
		Thread.sleep(1000);
		btnSubmit.click();
	}
	public void clklogout() throws InterruptedException
	{
		lnkLogout.click();
		Thread.sleep(2000);
	}
}
