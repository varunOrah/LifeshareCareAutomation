package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utility.TestUtil;

public class AgencyHomePage extends TestUtil {

	By patientSearchBox = By.cssSelector("[placeholder='Search Patients']");
	By passwordBox = By.cssSelector("div.modal-content input");
	By proceed = By.cssSelector("div.modal-content button");
	By patientSearchResult = By.cssSelector("ul.patnt >li:nth-child(1)>a");
	public By saveAlert = By.cssSelector("[role='alertdialog']");
	By patientTab = By.cssSelector(".tab-pane-patients>a:nth-child(2)");
	By aideTab = By.cssSelector(".tab-pane-aides>a:nth-child(2)");
	By aideSearchBox = By.cssSelector("[placeholder='Search Aides']");





	public void enterPatientName() throws InterruptedException {
		clickOnElement(waitForElementClickable(patientTab));
		Thread.sleep(2000);
		if(CreatePatientPage.patientName==null || CreatePatientPage.patientName.isEmpty())
			waitForElementClickable(patientSearchBox).sendKeys(configProp.getProperty("patientName"));	
		else		
			waitForElementClickable(patientSearchBox).sendKeys(CreatePatientPage.patientName);
	}
	
	public void enterAideName() throws InterruptedException {
		clickOnElement(waitForElementClickable(aideTab));
		Thread.sleep(2000);
		if(CreateAidePage.aideName.isEmpty() || CreateAidePage.aideName==null)
			waitForElementClickable(patientSearchBox).sendKeys(configProp.getProperty("patientName"));	
		else		
			waitForElementClickable(aideSearchBox).sendKeys(CreateAidePage.aideName);
		Thread.sleep(2000);
	}

	public void clickDeletePatient() {
		Actions action = new Actions(getDriver());
		action.moveToElement(getDriver().findElement(By.cssSelector("ul.patnt >li:nth-child(1)")))
		.moveToElement(getDriver().findElement(By.cssSelector("ul.patnt >li:nth-child(1)>a")))
		.moveToElement(getDriver().findElement(By.xpath("//li//i[contains(@title,'Click to delete')]"))).click().build().perform();
	}

	public void enterPasswordToDelete() {
		waitForElementClickable(passwordBox).sendKeys(configProp.getProperty("agencyPassword"));
	}

	public void clickProceed() {
		clickOnElement(waitForElementClickable(proceed));
	}

	public void clickPatientSearchResult() {
		clickOnElement(waitForElementClickable(patientSearchResult));
	}
	
	public void clickOnHeaderTab(String tab) throws InterruptedException {
	getDriver().findElement(By.xpath("//div[contains(@class,'headermenu')]//a[contains(text(),'"+tab+"')]")).click();
	Thread.sleep(1000);
	}

}
