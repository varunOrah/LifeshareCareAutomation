package pages;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.openqa.selenium.By;
import org.testng.Assert;

import utility.TestUtil;

public class CreateAidePage extends TestUtil{

	public static String aideName;
	public static List<String> newAides;
	public static String dayAvailable;
	private By uploadAideProfile = By.xpath("//input[@name='file']");
	private By firstName = By.cssSelector("[name='first_name']");
	private By lastName = By.cssSelector("[name='last_name']");
	private By address = By.cssSelector("[name='address']");
	private By phoneType = By.cssSelector("[name='phoneType']");
	private By phoneNo = By.cssSelector("[name='AidePhone']");
	private By email = By.cssSelector("[name='AideEmail']");
	private By dob = By.cssSelector("[name='dob']");
	private By gender = By.xpath("//div[@class='custom-radio']//label[contains(text(),'Male')]/span");
	//private By saveButton = By.xpath("//button[contains(text(),'Save')]");
	private By saveButton = By.xpath("//button[contains(@class, 'greenbtn') and not(@disabled)]");
	private By activateDatesOfMonth = By.cssSelector(".bs-datepicker-body td:not(.week)>span:not(.disabled):not(.is-other-month)");
	private By autoSuggestionList = By.cssSelector("div.pac-item");
	private By aideSaveAlert = By.cssSelector("[role='alertdialog']");
	private By createAideHeader = By.cssSelector(".cal-profile h4");
	private By weekDays = By.cssSelector("div.day-tags a>span");
	private By days = By.cssSelector("ul.day-details>li label");
	private By addAide = By.cssSelector("[title='Add Aide'] i");


	public void verifyCreateAideForm(){
		Assert.assertTrue(waitForElementVisible(createAideHeader).getText().equalsIgnoreCase("Create Aide"),"Create Aide form not found");
	}


	public void createAide() throws InterruptedException {
		openAccordian(" BASIC INFORMATION");
		uploadFile(uploadAideProfile);	
		String aideFname=getRandomString();
		String aideLname=getRandomString();
		waitForElementVisible(firstName).sendKeys(aideFname);
		waitForElementVisible(lastName).sendKeys(aideLname);
		waitForElementVisible(address).sendKeys("adarsh nagar rawat");
		Thread.sleep(2000);
		clickOnElement(waitForElementsVisible(autoSuggestionList).get(0));
		selectFromDropdownByText(phoneType, "Cell");
		waitForElementVisible(phoneNo).sendKeys("2903874839");

		waitForElementVisible(email).sendKeys(getRandomString()+"@yopmail.com");
		clickOnElement(waitForElementVisible(dob));
		clickOnElement(waitForElementsVisible(activateDatesOfMonth).get(0));

		clickOnElement(waitForElementVisible(gender));

		aideName = aideFname+" "+aideLname;
		System.out.println(aideName);
		newAides = new ArrayList<>();
		newAides.add(aideName);

	}

	public void saveAide() {
		//	waitTillAlertsDisappear();
		clickOnElement(waitForElementVisible(saveButton));
	}

	public void verifyAideSaveMsg() throws InterruptedException {
		//	Assert.assertTrue(waitForElementVisible(aideSaveAlert).getText().contains("Aide added successfully."),"Aide not created");
		verifyMessageOnScreen(aideSaveAlert, "Aide added successfully.");	
	}



	public void selectDayandTime(Map<String,String> dayTime) {	
		clickRequiredDay(weekDays,dayTime.get("Day"));
		List<String> timeList = Arrays.asList(dayTime.get("TimeOfDay").split(","));
		findElements(days).forEach(day->{

			if(day.getText().equalsIgnoreCase(dayTime.get("Day"))) {

				day.findElements(By.xpath("./ancestor::li//li[contains(@class,'avail_cur')]")).forEach(dayTimeFrame->{
					if(timeList.contains(dayTimeFrame.getText()))
						dayTimeFrame.click();
				});
			}
		});
	}



	public void verifyAideUpdateMsg() throws InterruptedException {
		//Assert.assertTrue(waitForElementVisible(aideSaveAlert).getText().contains("Aide profile updated successfully."),"Aid not updated");
		verifyMessageOnScreen(aideSaveAlert, "Aide profile updated successfully.");
	}

	public void createNumberOfAides() throws InterruptedException {
		clickAddAide();
		createAide();
		saveAide();
		verifyAideSaveMsg();
		openAccordian("AVAILABILITY");
		Map<String,String> dayTime = new HashedMap();
		dayAvailable = getTomorrowDay();
		dayTime.put("Day", dayAvailable);
		dayTime.put("TimeOfDay", "MORNING,AFTERNOON,EVENING");
		selectDayandTime(dayTime);
		saveAide();
		verifyAideUpdateMsg();
	}

	public void clickAddAide() {
		clickOnElement(waitForElementClickable(addAide));
	}
	
	public void verifyScheduleExists() {
		
	}
}
