package pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.testng.Assert;

import utility.TestUtil;

public class CreatePatientPage extends TestUtil {
	
	public static String patientName;

	By agencyPortal = By.cssSelector(".header-display-desktop a.btn");
	By userName = By.cssSelector("[name='username']");
	By password = By.cssSelector("[name='password']");
	By signIn = By.xpath("//button[contains(text(),'Sign In')]");
	By agencyName = By.cssSelector("h4.company-name");
	By addPAtient = By.cssSelector("[title='Add Patient'] i");
	By createPatientForm = By.xpath("//h4[contains(text(),'Create Patient')]");

	By careStartDate = By.cssSelector("[name='careStartDate']");
	By activeDates = By.cssSelector(".bs-datepicker-body span:not([class*='disabled']):not([class*='is-other-month'])[bsdatepickerdaydecorator]");
	By firstName = By.cssSelector("[name='first_name']");
	By lastName = By.cssSelector("[name='last_name']");
	By address = By.cssSelector("[name='address']");
	By autoSuggestion = By.cssSelector("div.pac-item");
	By phoneType = By.cssSelector("[name='phoneType']");
	By phNo = By.cssSelector("[name='phNo']");
	By dob = By.cssSelector("[name='dob']");
	By patientProfilePic = By.cssSelector("[heading='GENERAL INFORMATION'] [name='file']");
	By genderMale = By.xpath("//label[contains(text(),'Male')]");
	By savePatient = By.cssSelector("button.patientBtn");
	public By saveAlert = By.cssSelector("[role='alertdialog']");


	public void verifyHomePage() {
		Assert.assertTrue(getDriver().getCurrentUrl().contains("orah.care"));
		getDriver().switchTo().frame(getDriver().findElement(By.className("myframe")));
	}

	public void clickAgencyPortal() throws InterruptedException {
		System.out.println("Parent Handle - "+getDriver().getWindowHandle());
		clickOnElement(waitForElementClickable(agencyPortal));
		
		Thread.sleep(2000);
		String parentHandle = getDriver().getWindowHandle();
		System.out.println("Parent Handle - "+parentHandle);
		 ArrayList<String> tabs2 = new ArrayList<String> (getDriver().getWindowHandles());
		    getDriver().switchTo().window(tabs2.get(1));
	}

	public void verifyAgencyPortalPage() {
		Assert.assertTrue(getDriver().getCurrentUrl().contains("/login/agency"));
	}

	public void enterAgencyLoginDetails() {
		waitForElementClickable(userName).sendKeys(configProp.getProperty("agencyUserName"));
		waitForElementClickable(password).sendKeys(configProp.getProperty("agencyPassword"));
	}

	public void clickSignIn() {
		clickOnElement(waitForElementClickable(signIn));
	}

	public void VerifyAgencyName(String name) {
		waitForTextToBe(agencyName, name);
	}

	public void clickAddPatient() {
		clickOnElement(waitForElementClickable(addPAtient));
	}
	public void verifyCreatePatientForm() {
		waitForElementClickable(createPatientForm);
	}

	public void enterNewPatientDetails() {
		clickOnElement(waitForElementClickable(careStartDate));
		clickOnElement(waitForElementsVisible(activeDates).get(0));
		String fName=toTitleCase(getRandomString());
		waitForElementClickable(firstName).sendKeys(fName);
		String lName=toTitleCase(getRandomString());
		waitForElementClickable(lastName).sendKeys(lName);

		waitForElementClickable(address).sendKeys("kanpur");
		clickOnElement(waitForElementsVisible(autoSuggestion).get(0));

		selectFromDropdownByText(phoneType, "Cell");
		waitForElementClickable(phNo).sendKeys("8293098271");

		clickOnElement(waitForElementClickable(dob));
		clickOnElement(waitForElementsVisible(activeDates).get(0));

		uploadFile(patientProfilePic);

		clickOnElement(waitForElementClickable(genderMale));
		
		patientName = fName+" "+lName;
	}

	public void savePatient() {
		clickOnElement(waitForElementClickable(savePatient));
	}
	
	
}


