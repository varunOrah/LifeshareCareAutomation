package utility;

import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class TestUtil extends TestBase {

	public void openAccordian(String accordian) {
		WebElement element = getDriver().findElement(By.xpath("//button[contains(text(),'"+accordian+"')]/parent::div"));
		if(element.getAttribute("aria-expanded").equals("false"))
			element.click();
	}

	public WebElement waitForElementVisible(By by) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 20);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		return element;
	}

	public List<WebElement> waitForElementsVisible(By by) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 20);
		List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
		return elements;
	}

	public WebElement waitForElementClickable(By by) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 20);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
		return element;
	}

	public void clickOnElement(WebElement element) {
		element.click();
	}

	public void uploadFile(By by)
	{
		WebElement element = getDriver().findElement(by);
		element.sendKeys(System.getProperty("user.dir")+"\\ProfilePic.jpg");
	}

	public String getRandomString() {
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 6) { // length of the random string.
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr;


	}

	public void selectFromDropdownByText(By by, String text) {
		Select select = new Select(waitForElementVisible(by));
		select.selectByVisibleText(text);
	}
	
	public void selectFromDropdownByText(WebElement by, String text) {
		Select select = new Select(by);
		select.selectByVisibleText(text);
	}

	public void verifyMessageOnScreen(By by, String msg) throws InterruptedException {
		Thread.sleep(1000);
		List<String> messages = waitForElementsVisible(by).stream().map(element->element.getText()).collect(Collectors.toList());
		Assert.assertTrue(messages.contains(msg),"No such alert message found - "+msg);
		System.out.println("Mesages - "+messages);

	}

	public void clickRequiredDay(By by, String day)
	{
		List<WebElement> days = waitForElementsVisible(by);
		switch(day) {
		case("Monday"):
			clickOnElement(days.get(0));
		break;
		case("Tuesday"):
			clickOnElement(days.get(1));
		break;
		case("Wednesday"):
			clickOnElement(days.get(2));
		break;
		case("Thursday"):
			clickOnElement(days.get(3));
		break;
		case("Friday"):
			clickOnElement(days.get(4));
		break;
		case("Saturday"):
			clickOnElement(days.get(5));
		break;
		case("Sunday"):
			clickOnElement(days.get(6));
		break;
		}
	}

	public List<WebElement> findElements(By by) {
		List<WebElement> elements = getDriver().findElements(by);
		return elements;
	}

	public String getTomorrowDay()
	{
		Calendar calendar = Calendar.getInstance();
		int day = calendar.get(Calendar.DAY_OF_WEEK); 
		System.out.print(day);
		String daysOfWeek[] = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
		day = day + 1;
		day = day > 6 ? 0 : day;
		return daysOfWeek[day];
	}

	public void waitForTextToBe(By by,String text) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 20);
		wait.until(ExpectedConditions.textToBe(by, text));

	}
	
	public String toTitleCase(String text) {
		StringBuffer resultPlaceHolder = new StringBuffer(text.length());
		resultPlaceHolder.append(text.substring(0, 1)
                .toUpperCase())
                .append(text.substring(1)
                .toLowerCase());
		return resultPlaceHolder.toString();
	}
	
	public void waitForElementInvisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 20);
	wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	public void scrollToElement(WebElement element) {
	      ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);

	}
}
