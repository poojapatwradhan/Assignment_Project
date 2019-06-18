package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import helper.Browser;

public class LoginPage extends Page {
	WebDriver driver;

	public LoginPage(Browser browser) {
		super(browser);
	}

	// locator for emailId input filed
	@FindBy(xpath = "//div[@class='form-group']//input[@id='email']")
	public WebElement emailAddressInput;

	// locator for password input filed
	@FindBy(xpath = "//div[@class='form-group']//input[@id='passwd']")
	public WebElement passwordInput;

	// locator for submit Button
	@FindBy(xpath = "//button[@id='SubmitLogin']")
	public WebElement SignInSubmitButton;

	// locator for create account button
	@FindBy(xpath = "//button[@id='SubmitCreate']")
	public WebElement CreateAccButton;

	//locator for alert
	@FindBy(xpath = "//div[@class='alert alert-danger']//li")
	public WebElement alert;

	// common method to clear input field and enter value
	public void enterValue(WebElement web, String value) {
		web.clear();
		web.sendKeys(value);
	}

}
