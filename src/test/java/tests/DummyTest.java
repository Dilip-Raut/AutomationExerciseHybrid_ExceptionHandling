package tests;

import java.time.Duration;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AllProductsPage;
import pageObjects.CheckOut;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.PaymentPage;
import testBase.BaseClass;

public class DummyTest extends BaseClass {

	@Test
	public void verify_login() {
		logger.info("**** Starting LoginTest  ****");
		logger.debug("capturing application debug logs....");
		try {
			// Home page
			HomePage hp = new HomePage(driver);
			hp.clickLogin();
			logger.info("clicked on Login link on the home page..");

			// Login page
			LoginPage lp = new LoginPage(driver);
			logger.info("Entering valid email and password..");
			lp.fillexistingemail("abcdpqrs@gmail.com");
			lp.fillemailpassword("abcdpqrs123");
			lp.clickOnExistingLogin();
			logger.info("clicked on login button..");

			// My Account Page

			boolean targetPage = hp.isLogoutDisplayed();

			Assert.assertEquals(targetPage, true, "Login Succesfull");

		} catch (NoSuchElementException e) {
			System.out.println("elements not found: " + e.getMessage());
		} catch (TimeoutException e) {
			System.out.println("process timed out: " + e.getMessage());
		}

		logger.info("**** Finished LoginTest  ****");
		logger.info("**** Starting SearchProductTestt  ****");

		try {

			HomePage hp = new HomePage(driver);
			AllProductsPage allProductsPage = new AllProductsPage(driver);

			hp.clickProductLink();
			// to perform Scroll on application using Selenium
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,350)", "");

			// hm.enterProductName("iPhone");
			allProductsPage.searchProduct("Men Tshirt");

			allProductsPage.buttonSubmitSearchProduct();
			Thread.sleep(2000);
			allProductsPage.moveToAddToCartButtonAndClick();
			Thread.sleep(3000);
			allProductsPage.clickOnAddToCart();
			Thread.sleep(3000);
			wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.elementToBeClickable(allProductsPage.buttonViewCart));
			allProductsPage.buttonViewCart.click();
			Thread.sleep(3000);

		} catch (NoSuchElementException e) {
			System.out.println("Search Products not found: " + e.getMessage());
		} catch (ElementNotInteractableException e) {
			System.out.println("ViewCart Button is not interactable: " + e.getMessage());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		logger.info("**** Finish SearchProductTest  ****");
		logger.info("**** Starting CheckoutTest  ****");

		try {

			CheckOut chk = new CheckOut(driver);
			chk.clickProceedCheckout();
			// to perform Scroll on application using Selenium
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,350)", "");

			chk.typeCheckoutReviewBox();

		} catch (Exception e) {
			Assert.fail();
		}

		logger.info("**** Finished CheckoutTest  ****");
		logger.info("**** Starting PaymentTest  ****");

		try {

			PaymentPage payment = new PaymentPage(driver);
			payment.clickAndEnterPayment();

		} catch (NoSuchElementException e) {
			System.out.println("Checkout elements not found: " + e.getMessage());
		} catch (NoSuchFrameException e) {
			System.out.println("Payment frame not found: " + e.getMessage());
		}

		logger.info("**** Finished PaymentTest  ****");

	}

}
