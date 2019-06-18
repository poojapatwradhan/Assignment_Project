package tests;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import helper.Browser;
import junit.framework.Assert;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests {

	Browser browser;
	HomePage homepage;
	LoginPage login;
	WebDriver driver;

	@Parameters({ "login" })
	@BeforeClass
	public void launchHomePage() throws IOException {
		browser = new Browser();
	}

	@Test(description = "enter loginid and pswd and check login functionality")
	public void validLoginTest() throws InterruptedException {
		String emaildId = "test@test.com";
		String pswd1 = "ThisIs@T3st";

		// Navigate to homepage and click on SignIn button
		HomePage homepage = new HomePage(browser);
		homepage.clickOnSignInButton();

		// enter email id and password
		LoginPage login = new LoginPage(browser);
		login.enterValue(login.emailAddressInput, emaildId);
		login.enterValue(login.passwordInput, pswd1);
		login.SignInSubmitButton.click();

		// Verify error message after entering invalid inputs
		Assert.assertTrue(login.alert.isDisplayed());
		Assert.assertEquals(login.alert.getText(), "Authentication failed.");
	}

	@Test(description = "enter loginid as test and check login functionality")
	public void loginWithIDTest() throws Exception {
		// Navigate to homepage and click on SignIn button
		homepage = new HomePage(browser);
		homepage.clickOnSignInButton();

		login = new LoginPage(browser);
		//this wait is added to avoid stale element reference
		browser.WaitForElementClickable(login.emailAddressInput, 2000);
		login.enterValue(login.emailAddressInput, "test");

		login.emailAddressInput.sendKeys(Keys.ENTER);
		
		//TODO "attributes of tooltip are not available in DOM "
		// Assert.assertEquals(login.emailAddressInput.getAttribute("tooltip"),
		// "Please include an '@' in email address. 'test' is missing an '@'.");
		// Assert.assertEquals(login.emailAddressInput.getAttribute("title"),
		// "Please include an '@' in email address. 'test' is missing an '@'.");
		System.out.println(browser.captureScreenshot(driver, "Tooltip_Scrrenshot"));

	}

	@Test(description = "enter loginid as blank and  check login functionality")
	public void UsernamePswdLoginTest() throws InterruptedException {
		// Navigate to homepage and click on SignIn button
		homepage = new HomePage(browser);
		homepage.clickOnSignInButton();

		login = new LoginPage(browser);
		login.enterValue(login.emailAddressInput, "");
		login.enterValue(login.passwordInput, "");
		login.SignInSubmitButton.click();
		Assert.assertTrue(login.alert.isDisplayed());
		Assert.assertEquals(login.alert.getText(), "An email address required.");
		

	}

	@AfterClass
	public void closeBrowser() {
		browser.driver.quit();
	}

}
