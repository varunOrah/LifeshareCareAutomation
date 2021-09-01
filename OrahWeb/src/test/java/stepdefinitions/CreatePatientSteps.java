package stepdefinitions;

import io.cucumber.java.en.And;
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
	
	@And("User clicks on {string} tab of patient")
	public void User_clicks_on_tab_of_patient(String tab) {
		createPatientPage.clickPatientTab(tab);
	}
	
	@Then("I should be able to select below aide services")
	public void addAideServices(io.cucumber.datatable.DataTable dataTable) {
		dataTable.asMaps().forEach(map->{
			try {
				createPatientPage.addAideServices(map);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		}
	
	@Then("I should be able to select below general medical history")
	public void addMedicalInfo(io.cucumber.datatable.DataTable dataTable) {
		dataTable.asMaps().forEach(map->{
			try {
				createPatientPage.addMedicalInformation(map);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		}
	
	@Then("I should be able to add below medication details")
	public void addMedicineDetails(io.cucumber.datatable.DataTable dataTable) {
		dataTable.asMaps().forEach(map->{
			try {
				createPatientPage.addmedicationDetails(map);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
	}
	
	@And("I should be able to delete medication details for {string}")
	public void deleteMedication(String medicine) throws InterruptedException {
	createPatientPage.delmedicationDetails(medicine);
	}
	
	
	@Then("I should be able to add below supplement details")
	public void addSuppDetails(io.cucumber.datatable.DataTable dataTable) {
		dataTable.asMaps().forEach(map->{
			try {
				createPatientPage.addSupplementDetails(map);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
	}
	
	@And("I should be able to delete supplement details for {string}")
	public void deleteSupplement(String supp) throws InterruptedException {
	createPatientPage.delSupplementDetails(supp);
	}
	
	@Then("I should be able to enter below emergency contact information")
	public void addEmergencyContact(io.cucumber.datatable.DataTable dataTable) {
		dataTable.asMaps().forEach(map->{
			try {
				createPatientPage.addEmergencyContact(map);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
	}
	
	@Then("I should be able to enter below payor information")
	public void addPayor(io.cucumber.datatable.DataTable dataTable) {
		dataTable.asMaps().forEach(map->{
			try {
				createPatientPage.addPayor(map);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
	}
	
	
	@When("User enters the below patient data")
	public void user_enters_the_below_patient_data(io.cucumber.datatable.DataTable dataTable) {
		dataTable.asMaps().forEach(map->{
			createPatientPage.enterPatientData(map);
		});
	}
	@Then("User should get the error message - {string}")
	public void user_should_get_the_error_message(String msg) throws InterruptedException {
	 createPatientPage.verifyMessageOnScreen(createPatientPage.saveAlert, msg);
	}
	@Then("User refreshes the page")
	public void user_refreshes_the_page() {
	  createPatientPage.getDriver().navigate().refresh();
	}
	
	}

