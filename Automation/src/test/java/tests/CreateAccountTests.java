package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import helper.Browser;
import junit.framework.Assert;
import pages.CreateAccountPage;
import pages.HomePage;
import pages.LoginPage;

public class CreateAccountTests {

	Browser browser;
	HomePage homepage;
	LoginPage login;
	WebDriver driver;
	CreateAccountPage account;

	@Parameters({ "account" })
	@BeforeClass
	public void launchHomePage() throws IOException {
		browser = new Browser();
	}

	@Test(description = "create account test")
	public void createAccountTest() {
		homepage = new HomePage(browser);
		homepage.clickOnSignInButton();

		login = new LoginPage(browser);
		login.CreateAccButton.click();
		account = new CreateAccountPage(browser);
		account.emailAddressInput.sendKeys("test@test.com");
		account.password.sendKeys("testpswd");
		account.confirmPswd.sendKeys("testpswd");
		account.select.click();

		account.nameInput.sendKeys("testUser");
		account.lastNameInput.sendKeys("testName");

		account.addressInput.sendKeys("Rue De");
		account.postalcodeInput.sendKeys("78120");
		account.mobileNumber.sendKeys("1234567");
		account.HomeNumber.sendKeys("987654");
		// @Bug
		// Below assertion would fail as city field is disabled.
		Assert.assertEquals(account.city.getText(), "Rambouillet");
	}

	@AfterClass
	public void closeBrowser() {
		browser.driver.quit();
	}
}
