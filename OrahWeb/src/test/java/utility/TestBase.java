package utility;

import org.openqa.selenium.WebDriver;

public class TestBase {
	
	private static ThreadLocal<WebDriver> webdriver = new ThreadLocal<WebDriver>();
	
	public static void setDriver(WebDriver driver)
	{
		webdriver.set(driver);
	}
	
	public static synchronized WebDriver getDriver() {
		return webdriver.get();
	}

}
