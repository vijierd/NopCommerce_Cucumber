package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage extends WaitHelper
{
	public WaitHelper waitHelper;
	public WebDriver d;
	BasePage(WebDriver d)
	{
		this.d=d;
		PageFactory.initElements(d, this);
		WaitHelper waitHelper =new WaitHelper();
	}
}
