package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.PatientCarePlan;

public class PatientCarePlanSteps {

	PatientCarePlan patientCarePlan = new PatientCarePlan();
	
	@When("User searches for any patient")
	public void user_searches_for_any_patient() {
	 
	}
	@When("User clicks on that patient name")
	public void user_clicks_on_that_patient_name() {
	   
	}
	@When("User clicks on {string} tab")
	public void user_clicks_on_tab(String string) {
	   
	}
	@Then("User should be able to enter below Clockin and Clocout Time")
	public void user_should_be_able_to_enter_below_clockin_and_clocout_time(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		
		Thread.sleep(7000);
	 dataTable.asMaps().forEach(map->{
		 try {
			patientCarePlan.selectClockInAndClockOut(map);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	 });	}
	@Then("it should get added to patient schedule")
	public void it_should_get_added_to_patient_schedule() {
	   
	}
}
