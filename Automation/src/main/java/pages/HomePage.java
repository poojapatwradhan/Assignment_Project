package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import helper.Browser;

public class HomePage extends Page {
	WebDriver driver;

	public HomePage(Browser browser) {
		super(browser);
	}

	@FindBy(xpath = "//div[@class='header-container']//a[@class='login']")
	public WebElement logInButton;

	@FindBy(xpath = "//p[@class='alert alert-danger']")
	public WebElement alert;

	public void clickOnSignInButton() {
		logInButton.click();
	}
}
