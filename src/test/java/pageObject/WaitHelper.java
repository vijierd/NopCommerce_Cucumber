package pageObject;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper 
{
	WebDriver d;

	void WebDriver(WebDriver d)
	{
		this.d =d;
	}
	
	public int waitForElement (WebElement element,long timeInSeconds)
	{
		WebDriverWait wait = new WebDriverWait(d,Duration.ofSeconds(timeInSeconds));	
		wait.until(ExpectedConditions.visibilityOf(element));
		return 30;
				
	}

	
}
