package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import utility.TestBase;

public class Hooks extends TestBase {
	
	WebDriver driver;
	
	@Before
	public void beforeScenario() {
			
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		setDriver(driver);
	}

}
