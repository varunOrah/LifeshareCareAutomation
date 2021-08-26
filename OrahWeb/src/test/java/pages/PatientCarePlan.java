package pages;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import utility.TestUtil;

public class PatientCarePlan extends TestUtil {

	By clockiInDays = By.cssSelector("p.day-name");
	By saveButton = By.cssSelector("button.greenbtn");
	public By saveAlert = By.cssSelector("[role='alertdialog']");

	public void selectClockInAndClockOut(Map<String,String> details) throws InterruptedException {
		openAccordian(details.get("Accordian"));
		if(details.get("Accordian").contains("CLOCK IN/CLOCK OUT"))
		clickRequiredDay(clockiInDays, details.get("Day"));
		Thread.sleep(2000);
		WebElement row = null;
		WebElement aideSelect = null;
		WebElement activitySelect = null;
		switch(details.get("Accordian")) {
		case ("CLOCK IN/CLOCK OUT"): 
			row = getDriver().findElements(By.xpath("//*[@heading='CLOCK IN/CLOCK OUT']//*[contains(@class,'form-register')]//div[contains(@class,'clearfix row') and not(contains(@class,'insert'))]")).get(0);
		System.out.println("Accordian - "+details.get("Accordian"));
		break;
		case ("MEDICAL"):
			row = getDriver().findElements(By.xpath("//*[@heading='MEDICAL']//tbody[not(contains(@class,'insert'))]//tr")).get(0);
		System.out.println("Accordian - "+details.get("Accordian"));
		break;

		case ("PERSONAL CARE & NUTRITION"):
			row = getDriver().findElements(By.xpath("//*[@heading='PERSONAL CARE & NUTRITION']//tbody[not(contains(@class,'insert'))]//tr")).get(0);
		System.out.println("Accordian - "+details.get("Accordian"));	
		break;

		case ("CLIENT ACTIVITY"):
			row = getDriver().findElements(By.xpath("//*[@heading='CLIENT ACTIVITY']//tbody[not(contains(@class,'insert'))]//tr")).get(0);
		System.out.println("Accordian - "+details.get("Accordian"));
		break;

		case ("HOMEMAKER SERVICES"):
			row = getDriver().findElements(By.xpath("//*[@heading='HOMEMAKER SERVICES']//tbody[not(contains(@class,'insert'))]//tr")).get(0);
		System.out.println("Accordian - "+details.get("Accordian"));
		break;
		}


		System.out.println("Row size - "+row.getAttribute("innerHTML"));
		WebElement clockInInput = row.findElements(By.xpath(".//input[@aria-haspopup]")).get(0);
		WebElement clockOutInput = row.findElements(By.xpath(".//input[@aria-haspopup]")).get(1);

		String reqClockIn[] = details.get("ClockIn").replaceAll(":", " ").split(" ");
		String reqHrs = reqClockIn[0];
		System.out.println("Req hrs - "+reqHrs);
		String reqMin = reqClockIn[1];
		String reqAmPm = reqClockIn[2];

		String reqClockOut[] = details.get("ClockOut").replaceAll(":", " ").split(" ");
		String reqHrsOut = reqClockOut[0];
		System.out.println("Req hrs - "+reqHrsOut);
		String reqMinOut = reqClockOut[1];
		String reqAmPmOut = reqClockOut[2];

		clockInInput.click();
		Thread.sleep(1000);

		WebElement  hrsIn = row.findElement(By.xpath(".//timepicker[contains(@id,'In')]//tr[2]//td[1]/input"));
		WebElement minIn = row.findElement(By.xpath(".//timepicker[contains(@id,'In')]//tr[2]//td[3]/input"));
		WebElement ampmIn = row.findElement(By.xpath(".//timepicker[contains(@id,'In')]//tr[2]//td[5]/button"));


		WebElement minInChanger = row.findElement(By.xpath(".//timepicker[contains(@id,'In')]//tr[1]//td[3]"));
		WebElement hrsInChanger = row.findElement(By.xpath(".//timepicker[contains(@id,'In')]//tr[1]//td[1]"));

		//WebElement ampmInChanger = row.findElement(By.xpath("./timepicker[contains(@id,'In')]//tr[2]//td[5]"));

		while(!hrsIn.getAttribute("value").equals(reqHrs)) {

			System.out.println("clock hrs - "+hrsIn.getAttribute("value"));
			hrsInChanger.click();
		}

		while(!minIn.getAttribute("value").equals(reqMin)) {

			System.out.println("clock min - "+minIn.getAttribute("value"));
			minInChanger.click();
		}


		while(!ampmIn.getText().equals(reqAmPm)) {

			System.out.println("clock ampm - "+ampmIn.getAttribute("value"));
			ampmIn.click();
		}


		clockOutInput.click();
		Thread.sleep(1000);

		WebElement  hrsOut = row.findElement(By.xpath(".//timepicker[contains(@id,'Out')]//tr[2]//td[1]/input"));
		WebElement minOut = row.findElement(By.xpath(".//timepicker[contains(@id,'Out')]//tr[2]//td[3]/input"));
		WebElement ampmOut = row.findElement(By.xpath(".//timepicker[contains(@id,'Out')]//tr[2]//td[5]/button"));


		WebElement minOutChanger = row.findElement(By.xpath(".//timepicker[contains(@id,'Out')]//tr[1]//td[3]"));
		WebElement hrsOutChanger = row.findElement(By.xpath(".//timepicker[contains(@id,'Out')]//tr[1]//td[1]"));

		//WebElement ampmInChanger = row.findElement(By.xpath("./timepicker[contains(@id,'In')]//tr[2]//td[5]"));

		while(!hrsOut.getAttribute("value").equals(reqHrsOut)) {

			System.out.println("clock hrs - "+hrsOut.getAttribute("value"));
			hrsOutChanger.click();
		}

		while(!minOut.getAttribute("value").equals(reqMinOut)) {

			System.out.println("clock min - "+minOut.getAttribute("value"));
			minOutChanger.click();
		}


		while(!ampmOut.getText().equals(reqAmPmOut)) {

			System.out.println("clock ampm - "+ampmOut.getAttribute("value"));
			ampmOut.click();
		}

		Thread.sleep(1000);


		aideSelect =  details.get("Accordian").contains("CLOCK IN/CLOCK OUT")?
				row.findElement(By.xpath(".//select[@name='clockinAide']"))
				: row.findElements(By.xpath(".//select")).get(0);

		selectFromDropdownByText(aideSelect, details.get("Aide"));



		if(!details.get("Accordian").contains("CLOCK IN/CLOCK OUT")) {
			activitySelect = row.findElements(By.xpath(".//select")).get(1);
			selectFromDropdownByText(activitySelect, details.get("Activity"));
			
			row.findElement(By.xpath(".//td[contains(@class,'media')]//span[@class='caret']")).click();
			Thread.sleep(1000);
			
			if(details.get("Media").contains("Camera"))
		row.findElement(By.xpath(".//li//i[contains(@class,'fa-camera')]")).click();
			if(details.get("Media").contains("Video"))
				row.findElement(By.xpath(".//li//i[contains(@class,'fa-video')]")).click();
			if(details.get("Media").contains("None"))
				row.findElement(By.xpath(".//li//a[contains(text(),'NONE')]")).click();
			
			row.findElement(By.xpath(".//i[contains(@class,'fa-plus')]")).click();
		}

		else 

			clickOnElement(waitForElementClickable(saveButton));


	}

}
