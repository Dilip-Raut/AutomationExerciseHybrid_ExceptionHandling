package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends BasePage{


	public PaymentPage(WebDriver driver) {
		super(driver);
	}
	
	    @FindBy(xpath = "//input[@name='name_on_card']")
	    private WebElement NameOnCardField;

	    @FindBy(xpath ="//input[@name='card_number']" )
	    private WebElement CardNumberField;

	    @FindBy(xpath = "//input[@placeholder='ex. 311']")
	    private WebElement CVCField;

	    @FindBy(xpath = "//input[@placeholder='MM']")
	    private WebElement ExpirationMMField;

	    @FindBy(xpath = "//input[@placeholder='YYYY']")
	    private WebElement ExpirationYYField;

	    @FindBy(xpath = "//button[@id='submit']")
	    private WebElement PayAndConfirmOrder;

	    @FindBy(xpath = "//p[normalize-space()='Congratulations! Your order has been confirmed!']")
	    private WebElement MessageOrderPlaced;
	    
	  
	    @FindBy(xpath = "//a[normalize-space()='Continue']")
	    private WebElement paymentaftercontinue;


	    public  void  clickAndEnterPayment(){
	        NameOnCardField.sendKeys("tester");
	        CardNumberField.sendKeys("111111111111");
	        CVCField.sendKeys("123");
	        ExpirationMMField.sendKeys("1");
	        ExpirationYYField.sendKeys("2029");
	        PayAndConfirmOrder.click();
	        MessageOrderPlaced.isDisplayed();

	    }

}
