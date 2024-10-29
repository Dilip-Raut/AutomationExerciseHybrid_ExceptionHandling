package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AllProductsPage extends BasePage {
	
	public AllProductsPage(WebDriver driver) {
    	super(driver);
    	act=new Actions(driver);
    }
			
	@FindBy(xpath="//input[@id='search_product']")
	public WebElement boxSearchProduct;
	
	@FindBy(xpath = "//*[@id='submit_search']")
	public WebElement buttonSubmitSearchProduct;
	
	@FindBy(xpath = "//img[@alt='ecommerce website products']")
	public WebElement imgProductTshirt;
	
	@FindBy(xpath = "//div[@class='overlay-content']//a[@class='btn btn-default add-to-cart'][normalize-space()='Add to cart']")
	public WebElement txtAddToCart;
	
	
	@FindBy(xpath = "//u[.='View Cart']")
	public WebElement buttonViewCart;
	
	@FindBy(xpath = "//u[normalize-space()='View Cart']")
	public WebElement txtViewCartPage;
	
	
	public void clickOnViewCart() {
		buttonViewCart.click();;
	}
	
	public void clickOnAddToCart() {
		txtAddToCart.click();;
	}
	
	public void searchProduct(String productName) {
		boxSearchProduct.sendKeys(productName);
	}
	
	
	public void buttonSubmitSearchProduct() {
		buttonSubmitSearchProduct.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,-350)", "");
	}
	
	public void moveToAddToCartButtonAndClick() {
		act.moveToElement(imgProductTshirt).build().perform();
		clickOnAddToCart();
	}
}
