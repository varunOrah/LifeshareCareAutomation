package pages;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utility.TestUtil;

public class PatientCarePlan extends TestUtil {

	By clockiInDays = By.cssSelector("p.day-name");

	public void selectClockInAndClockOut(Map<String,String> details) throws InterruptedException {
		openAccordian(details.get("Accordian"));
		clickRequiredDay(clockiInDays, details.get("Day"));
		Thread.sleep(2000);
		WebElement row = null;
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




	}

}
