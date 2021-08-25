package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utility.TestUtil;

public class AgencyHomePage extends TestUtil {

	By patientSearchBox = By.cssSelector("[placeholder='Search Patients']");
	By passwordBox = By.cssSelector("div.modal-content input");
	By proceed = By.cssSelector("div.modal-content button");
	public By saveAlert = By.cssSelector("[role='alertdialog']");



	public void enterPatientName() {
		waitForElementClickable(patientSearchBox).sendKeys(CreatePatientPage.patientName);
	}

	public void clickDeletePatient() {
		Actions action = new Actions(getDriver());
		action.moveToElement(getDriver().findElement(By.cssSelector("ul.patnt >li:nth-child(1)")))
		.moveToElement(getDriver().findElement(By.cssSelector("ul.patnt >li:nth-child(1)>a")))
		.moveToElement(getDriver().findElement(By.cssSelector("ul.patnt >li:nth-child(1)>i"))).click().build().perform();
	}

	public void enterPasswordToDelete() {
		waitForElementClickable(passwordBox).sendKeys(configProp.getProperty("agencyPassword"));
	}
	
	public void clickProceed() {
		clickOnElement(waitForElementClickable(proceed));
	}

}