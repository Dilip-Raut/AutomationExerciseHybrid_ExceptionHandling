package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	WebDriver driver;
	Actions act;
	WebDriverWait wait;
	
	public BasePage(WebDriver driver)
	{
		this.driver=driver;
		act=new Actions(driver);
		wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		PageFactory.initElements(driver,this);
	}
}