package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CreatePatientPage;

public class CreatePatientSteps {

	CreatePatientPage createPatientPage = new CreatePatientPage();

	@Given("User is on Home Page")
	public void user_is_on_home_page() {
		createPatientPage.verifyHomePage();
	}
	@When("User Clicks on Agency Portal")
	public void user_clicks_on_agency_portal() throws InterruptedException {
	createPatientPage.clickAgencyPortal();
	}
	@Then("He should be navigated to Agency Portal Page")
	public void he_should_be_navigated_to_agency_portal_page() {
		createPatientPage.verifyAgencyPortalPage();
	}
	@When("User enters Agency Login Detials")
	public void user_enters_agency_login_detials() {
		createPatientPage.enterAgencyLoginDetails();
	}
	@When("User Clicks on Sign in Button")
	public void user_clicks_on_sign_in_button() {
		createPatientPage.clickSignIn();
	}
	@Then("he should be on Agency Home Page with Agency Header as {string}")
	public void he_should_be_on_agency_home_page_with_agency_header_as(String agencyName) {
		createPatientPage.VerifyAgencyName(agencyName);
	}
	@When("User clicks on Add Patient")
	public void user_clicks_on_add_patient() {
		createPatientPage.clickAddPatient();
	}
	@Then("User should be on Create Patient form")
	public void user_should_be_on_create_patient_form() {
		createPatientPage.verifyCreatePatientForm();
	}
	@When("User enters the required fields to create patient")
	public void user_enters_the_required_fields_to_create_patient() {
		createPatientPage.enterNewPatientDetails();
	}
	@When("User clicks on Save button")
	public void user_clicks_on_save_button() {
		createPatientPage.savePatient();
	}
	@Then("patient should be saved successfully")
	public void patient_should_be_saved_successfully() throws InterruptedException {
		createPatientPage.verifyMessageOnScreen(createPatientPage.saveAlert, createPatientPage.configProp.getProperty("newPatientCreate"));
	}
}
