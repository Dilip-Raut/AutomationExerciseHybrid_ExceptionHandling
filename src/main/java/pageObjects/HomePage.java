package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath = "//a[contains(text(),'Signup')]")
	WebElement Login;
	
	public void clickLogin() {
		Login.click();
	}
	
	@FindBy(xpath="(//a[@href='/products'])[1]")
	public WebElement clicOnProduct;	
	
	
	@FindBy(xpath="//a[normalize-space()='Logout']")
	public WebElement textLogout;	
	
	public boolean isLogoutDisplayed() {
        return textLogout.isDisplayed();
    }
	
	public void clickProductLink() {
       clicOnProduct.click();
    }
}