package utility;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class TestBase {
	
	private static ThreadLocal<WebDriver> webdriver = new ThreadLocal<WebDriver>();
	public static Properties configProp;
	
	public static void setDriver(WebDriver driver)
	{
		webdriver.set(driver);
//		getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
		public void  getConfig() {
			configProp = new Properties();

		InputStream in = this.getClass().getClassLoader().getResourceAsStream("Config\\config.properties");
	      System.out.println("Reading all properties from the file");
	      try {
	          configProp.load(in);
	      } catch (IOException e) {
	          e.printStackTrace();
	      }
	}
	
	public static synchronized WebDriver getDriver() {
		return webdriver.get();
	}

}
