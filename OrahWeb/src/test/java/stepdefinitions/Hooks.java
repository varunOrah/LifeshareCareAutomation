package stepdefinitions;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import utility.TestBase;

public class Hooks extends TestBase {
	
	WebDriver driver;
	
	@Before
	public void beforeScenario() {
			getConfig();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		setDriver(driver);
		getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		getDriver().manage().window().maximize();
		getDriver().get("https://orah.care");
		
	}
	
	@AfterStep
	public void afterEachStep(Scenario scenario) {
		System.out.println("After step");
		String screenShotName = scenario.getName().replaceAll(" ", "_");
		byte[] sourcePath = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES);
		scenario.attach(sourcePath, "image/png", screenShotName);
	}
	
	@Before("@Appium")
	public void setUpDevice() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "MyDevice");
		cap.setCapability("udid", "bddeda92");
		cap.setCapability("platformName", "Android");
		cap.setCapability("patformVersion", "10");
		
		cap.setCapability("appPackage", "com.lifesharecare.family");
		cap.setCapability("appActivity", "com.lifesharecare.family.MainActivity");
		driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
	}

}
