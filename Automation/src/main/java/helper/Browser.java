package helper;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Browser {
	public WebDriver driver;

	public Browser() throws IOException {
		initialise();
	}

	public void initialise() throws IOException {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\test\\java\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		// To maximize browser
		driver.manage().window().maximize();
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// To open website
		driver.get("https://marksandspicy.com");
	}

	// method to capture the screenshots
	public String captureScreenshot(WebDriver driver, String screenshotName) throws Exception {
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;

			File source = ts.getScreenshotAs(OutputType.FILE);
			String dest = System.getProperty("user.dir") + "\\src\\test-output\\screenshots";
			FileUtils.getFile(source, dest);

			return dest;

		} catch (Exception e) {
			System.out.println("Exception while taking screenshot " + e.getMessage());
		}
		return null;
	}

	// wait method
	public void WaitForElementClickable(WebElement element, int timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}
}
