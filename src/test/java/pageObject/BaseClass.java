package pageObject;

import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class BaseClass
{
	
	public WebDriver d;
	public LoginPage lp;
	public AddCustomerPage acp;
	public SearchCustomerPage scp;
	public Logger logger; //for logging
    public Properties p;
    public String br,email,firstname,lastname; //to store data in the variable.
    
    public String randomString()
	{
		String genString =  RandomStringUtils.randomAlphabetic(5);
		return genString;
	}
    
    public String getPageTitle()
    {
    	return d.getTitle();
    }
}


