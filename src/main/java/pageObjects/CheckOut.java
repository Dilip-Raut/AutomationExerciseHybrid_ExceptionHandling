package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOut extends BasePage {

	public CheckOut(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//a[@class='btn btn-default check_out']")
	public WebElement txtProceedCheckout;
	
	
	@FindBy(xpath="//textarea[@name='message']")
	public WebElement txtCheckoutReviewBox;
	
	@FindBy(xpath="//a[normalize-space()='Place Order']")
	public WebElement btnPlaceOrder;
	
	
	public void clickProceedCheckout() {
		txtProceedCheckout.click();
	}
	
	public void typeCheckoutReviewBox() {
		txtProceedCheckout.sendKeys("Expecting Good Quality Product");
		btnPlaceOrder.click();
	}
}
