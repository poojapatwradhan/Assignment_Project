package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import helper.Browser;

public class CreateAccountPage extends Page {
	WebDriver driver;
	public static final String baseXpath = "//div[@class='form-line']";

	public CreateAccountPage(Browser browser) {
		// this.driver=driver;
		super(browser);
	}

	@FindBy(xpath = baseXpath + "//input[@id='email']")
	public WebElement emailAddressInput;

	@FindBy(xpath = baseXpath + "//input[@id='password']")
	public WebElement password;

	@FindBy(xpath = baseXpath + "//input[@id='password2']")
	public WebElement confirmPswd;

	@FindBy(xpath = "//div[@class='input-content col-xs-11']//label[contains(text(),'Mrs')]")
	public WebElement select;

	@FindBy(xpath = baseXpath + "//input[@id='nom']")
	public WebElement nameInput;

	@FindBy(xpath = baseXpath + "//input[@id='prenom']")
	public WebElement lastNameInput;

	@FindBy(xpath = baseXpath + "//input[@id='adresse']")
	public WebElement addressInput;

	@FindBy(xpath = baseXpath + "//input[@id='codePostal']")
	public WebElement postalcodeInput;

	@FindBy(xpath = baseXpath + "//input[@id='ville']")
	public WebElement city;

	@FindBy(xpath = baseXpath + "//input[@id='telephonePortable']")
	public WebElement mobileNumber;

	@FindBy(xpath = baseXpath + "//input[@id='telephoneFixe']")
	public WebElement HomeNumber;

}
