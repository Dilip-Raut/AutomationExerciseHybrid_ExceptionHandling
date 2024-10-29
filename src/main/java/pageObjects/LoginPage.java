package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(name = "name")
	WebElement signUp_name;

	@FindBy(xpath = "(//input[@name='email'])[2]")
	WebElement signUp_email;

	@FindBy(xpath = "//button[text()='Signup']")
	WebElement signUp;

	@FindBy(xpath = "//input[@data-qa='login-email']")
	WebElement Login_email;

	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement Login_password;

	@FindBy(xpath = "//button[normalize-space()='Login']")
	WebElement Login_emailBtn;

	public void fillname(String userName) {
		signUp_name.sendKeys(userName);
	}

	public void fillemail(String usermail) {
		signUp_email.sendKeys(usermail);
	}

	public void clickSignUp() {
		signUp.click();
	}

	public void fillexistingemail(String userEmail) {
		Login_email.sendKeys(userEmail);
	}

	public void fillemailpassword(String usermailPassword) {
		Login_password.sendKeys(usermailPassword);
	}

	public void clickOnExistingLogin() {
		Login_emailBtn.click();
	}

}
