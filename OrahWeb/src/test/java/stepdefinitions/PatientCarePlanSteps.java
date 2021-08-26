package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.PatientCarePlan;

public class PatientCarePlanSteps {

	PatientCarePlan patientCarePlan = new PatientCarePlan();



	@Then("User should be able to enter below Clockin and Clocout Time")
	public void user_should_be_able_to_enter_below_clockin_and_clocout_time(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {

		Thread.sleep(2000);
		dataTable.asMaps().forEach(map->{
			try {
				patientCarePlan.selectClockInAndClockOut(map);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});	
	}
	@Then("it should get added to patient schedule")
	public void it_should_get_added_to_patient_schedule() throws InterruptedException {
		patientCarePlan.verifyMessageOnScreen(patientCarePlan.saveAlert, patientCarePlan.configProp.getProperty("scheduleCreate"));
	}

	@Then("aide activity should get created")
	public void aide_activity_should_get_created() throws InterruptedException {
		patientCarePlan.verifyMessageOnScreen(patientCarePlan.saveAlert, patientCarePlan.configProp.getProperty("activityAdd"));
	}
}
