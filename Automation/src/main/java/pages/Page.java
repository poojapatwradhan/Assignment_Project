package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import helper.Browser;

public class Page {
	protected WebDriver driver;
	protected Browser browser;

	public Page(Browser browser) {
		this.browser = browser;
		driver = browser.driver;
		PageFactory.initElements(driver, this);
	}

}
