package pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
	By license = By.cssSelector("[name='Licence']");
	By addLicense = By.xpath("//*[@heading='REQUESTED AIDE SERVICES']//span[contains(text(),'Add Licence')]");
	By additionReq = By.cssSelector("[name='additionalRequests']");
	By additionReqLabel = By.xpath("//h6[contains(text(),'Request')]");
	By diagnosis = By.cssSelector("[name='principalDiagnosis']");
	By height = By.cssSelector("[name='medicalHeight']");
	By weight = By.cssSelector("[name='medicalWeight']");
	By bloodTypeLabel = By.xpath("//label[contains(text(),'Blood Type')]");
	By bloodType = By.cssSelector("[name='medical_informations']");
	By allergy = By.cssSelector("[name='allergy']");
	By addallergyLink = By.xpath("//a[contains(text(),'Add Allergy')]");
	By medicineName = By.cssSelector("[name='addMedicationDetails'] [name='title']");
	By medicinedose = By.cssSelector("[name='addMedicationDetails'] [name='mdose']");
	By medicinefreq = By.cssSelector("[name='addMedicationDetails'] [name='mfrequency']");
	By medicinepurpose = By.cssSelector("[name='addMedicationDetails'] [name='purpose']");
	By addMedicineLink = By.cssSelector("[name='addMedicationDetails'] a");
	By popupOk = By.xpath("//div[contains(@class,'modal-content')]//button[1]");
	By suppName = By.cssSelector("[name='supplement']");
	By suppDose = By.cssSelector("[name='sdose']");
	By suppFreq = By.cssSelector("[name='sfrequency']");
	By addSupplementLink = By.xpath("//a/b[contains(text(),'Add Supplement')]");
	By contactName = By.cssSelector("[name='eContactName']");
	By contactNo = By.cssSelector("[name='eContacPhNo']");
	By contactEmail = By.cssSelector("[name='eContactEmail']");
	By contactRel = By.cssSelector("[name='eContactRelation']");
	By contactAddress = By.cssSelector("[name='eaddress']");
	By contactAdd = By.cssSelector("button.greenbtn");
	By carrier = By.cssSelector("[name='carrier']");
	By subscriber = By.cssSelector("[name='subscriber']");
	By subscriberId = By.cssSelector("[name='subscriberID']");
	By addPayor = By.xpath("//a/b[contains(text(),'Add Payor')]");
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


	public void clickPatientTab(String tab) {
		clickOnElement(getDriver().findElement(By.xpath("//ul[contains(@class,'tab-head')]//li/a[contains(text(),'"+tab+"')]")));
	}
	public void addAideServices(Map<String,String> details) throws InterruptedException {
		openAccordian(details.get("Accordian"));
		String typeOfCare[] =details.get("TypeOfCare").split(",");
		for(String care:typeOfCare)
			clickWaitAndAssert(getDriver().findElement(By.xpath("//*[@heading='REQUESTED AIDE SERVICES']//label[contains(text(),'"+care+"')]")),configProp.getProperty("profileUpdate"));

		selectFromDropdownByText(license, details.get("License"));
		clickWaitAndAssert(waitForElementVisible(addLicense),configProp.getProperty("profileUpdate"));

		String expertise[] =details.get("Expertise").split(",");
		for(String exp:expertise)
			clickWaitAndAssert(getDriver().findElement(By.xpath("//*[@heading='REQUESTED AIDE SERVICES']//label[contains(text(),'"+exp+"')]")),configProp.getProperty("profileUpdate"));

		String acitivity[] =details.get("Activity").split(",");
		for(String act:acitivity)
			clickWaitAndAssert(getDriver().findElement(By.xpath("//*[@heading='REQUESTED AIDE SERVICES']//label[contains(text(),'"+act+"')]")),configProp.getProperty("profileUpdate"));

		waitForElementVisible(additionReq).sendKeys(details.get("AddRequest"));
		clickWaitAndAssert(waitForElementVisible(additionReqLabel),configProp.getProperty("profileUpdate"));


	}

	public void clickWaitAndAssert(WebElement element,String message) throws InterruptedException {
		element.click();
		Thread.sleep(1000);
		if(getDriver().findElements(By.cssSelector("div.loading-text")).size()>0)
			waitForElementInvisible(getDriver().findElements(By.cssSelector("div.loading-text")).get(0));
		verifyMessageOnScreen(saveAlert, message);
	}

	public void addMedicalInformation(Map<String,String> details) throws InterruptedException {
		openAccordian(details.get("Accordian"));
		waitForElementVisible(diagnosis).sendKeys(details.get("Diagnosis"));
		clickWaitAndAssert(waitForElementVisible(height),configProp.getProperty("profileUpdate"));
		waitForElementVisible(height).sendKeys(details.get("Height"));
		clickWaitAndAssert(waitForElementVisible(weight),configProp.getProperty("profileUpdate"));
		waitForElementVisible(weight).sendKeys(details.get("Weight"));
		clickWaitAndAssert(waitForElementVisible(bloodTypeLabel),configProp.getProperty("profileUpdate"));
		selectFromDropdownByText(bloodType, details.get("Blood"));
		clickWaitAndAssert(waitForElementVisible(allergy),configProp.getProperty("profileUpdate"));
		waitForElementVisible(allergy).sendKeys(details.get("Allergy"));
		clickWaitAndAssert(waitForElementVisible(addallergyLink),configProp.getProperty("profileUpdate"));		
	}
	
	public void addmedicationDetails(Map<String,String> details) throws InterruptedException {
		openAccordian(details.get("Accordian"));
		waitForElementVisible(medicineName).sendKeys(details.get("Medicine"));
		waitForElementVisible(medicinedose).sendKeys(details.get("Dose"));
		waitForElementVisible(medicinefreq).sendKeys(details.get("Frequency"));
		waitForElementVisible(medicinepurpose).sendKeys(details.get("Purpose"));
		clickWaitAndAssert(waitForElementClickable(addMedicineLink),configProp.getProperty("profileUpdate"));
	}
	
	public void delmedicationDetails(String medicine) throws InterruptedException {
		getDriver().findElement(By.xpath("//td[contains(text(),'"+medicine+"')]/parent::tr//td//i[contains(@class,'fa-trash')]")).click();
		clickOnElement(waitForElementClickable(popupOk));
		verifyMessageOnScreen(saveAlert, "Deleted successfully");
	}
	
	public void addSupplementDetails(Map<String,String> details) throws InterruptedException {
		openAccordian(details.get("Accordian"));
		waitForElementVisible(suppName).sendKeys(details.get("Supplement"));
		waitForElementVisible(suppDose).sendKeys(details.get("Dose"));
		waitForElementVisible(suppFreq).sendKeys(details.get("Frequency"));
		clickWaitAndAssert(waitForElementClickable(addSupplementLink),"Supplement updated successfully.");
	}

	public void delSupplementDetails(String supp) throws InterruptedException {
		getDriver().findElement(By.xpath("//td[contains(text(),'"+supp+"')]/parent::tr//td//i[contains(@class,'fa-trash')]")).click();
		clickOnElement(waitForElementClickable(popupOk));
		verifyMessageOnScreen(saveAlert, "Deleted successfully");
	}
	
	public void addEmergencyContact(Map<String,String> details) throws InterruptedException {
		openAccordian(details.get("Accordian"));
		waitForElementVisible(contactName).sendKeys(details.get("Name"));
		waitForElementVisible(contactNo).sendKeys(details.get("Number"));
		waitForElementVisible(contactEmail).sendKeys(details.get("Email"));
		selectFromDropdownByText(contactRel, details.get("Relation"));
		waitForElementVisible(contactAddress).sendKeys(details.get("Address"));
		clickWaitAndAssert(waitForElementClickable(contactAdd), configProp.getProperty("contactAdd"));
	}
	
	public void addPayor(Map<String,String> details) throws InterruptedException {
		openAccordian(details.get("Accordian"));
		waitForElementVisible(carrier).sendKeys(details.get("Carrier"));
		waitForElementVisible(subscriber).sendKeys(details.get("Subscriber"));
		waitForElementVisible(subscriberId).sendKeys(details.get("SubscriberId"));
		clickWaitAndAssert(waitForElementClickable(addPayor), configProp.getProperty("profileUpdate"));
	}

}


