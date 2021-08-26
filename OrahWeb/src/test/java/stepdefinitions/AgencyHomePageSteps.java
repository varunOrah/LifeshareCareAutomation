package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AgencyHomePage;

public class AgencyHomePageSteps {

	AgencyHomePage agencyHomePage = new AgencyHomePage();
	
	@When("User enter patient name in the search box")
	public void user_enter_patient_name_in_the_search_box() {
	   agencyHomePage.enterPatientName();
	}
	@When("User clicks on delete patient")
	public void user_clicks_on_delete_patient() {
	   agencyHomePage.clickDeletePatient();
	}
	@When("User enters password in the dialog box")
	public void user_enters_password_in_the_dialog_box() {
	   agencyHomePage.enterPasswordToDelete();
	}
	@When("User clicks on Proceed")
	public void user_clicks_on_proceed() {
	   agencyHomePage.clickProceed();
	}
	@Then("patient should get deleted")
	public void patient_should_get_deleted() throws InterruptedException {
		agencyHomePage.verifyMessageOnScreen(agencyHomePage.saveAlert, agencyHomePage.configProp.getProperty("patientDelete"));
	}
	
	
	@When("User searches for any patient")
	public void user_searches_for_any_patient() {
	 agencyHomePage.enterPatientName();
	}
	@When("User clicks on that patient name")
	public void user_clicks_on_that_patient_name() {
	   agencyHomePage.clickPatientSearchResult();
	}
	
	@When("User clicks on {string} tab")
	public void user_clicks_on_tab(String tab) throws InterruptedException {
	   agencyHomePage.clickOnHeaderTab(tab);
	}
}
