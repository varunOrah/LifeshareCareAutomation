package stepdefinitions;

import java.util.stream.IntStream;

import org.apache.commons.compress.compressors.lz77support.AbstractLZ77CompressorInputStream;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CreateAidePage;
import utility.TestUtil;

public class CreateAideSteps {
	CreateAidePage createAidePage = new CreateAidePage();

	@Then("User should be on Create Aide form")
	public void user_should_be_on_create_aide_form() {
		createAidePage.verifyCreateAideForm();
	}

	@When("User enters the required fields to create aide")
	public void user_enters_the_required_fields_to_create_aide() throws InterruptedException {
		createAidePage.createAide();
	}

	@When("User clicks on SaveAide button")
	public void user_clicks_on_save_aide_button() {
		createAidePage.saveAide();
	}

	@Then("aide should be saved successfully")
	public void aide_should_be_saved_successfully() throws InterruptedException {
		createAidePage.verifyAideSaveMsg();
	}

	@When("User clicks on {string} accordian")
	public void user_clicks_on_accordian(String accordian) {
		((TestUtil) createAidePage).openAccordian(accordian);
	}

	@Then("User should be able to set the below data")
	public void user_should_be_able_to_set_the_below_data(io.cucumber.datatable.DataTable dataTable) {
		dataTable.asMaps().forEach(map->{
			createAidePage.selectDayandTime(map);
		});
	}

	@Then("aide should get updated")
	public void aide_should_get_updated() throws InterruptedException {
		createAidePage.verifyAideUpdateMsg();
	}

	@Then("User creates {int} aides") 
	public void user_creates_number_of_Aides(int n) throws InterruptedException {
		for(int i=1;i<=n;i++) {
			createAidePage.createNumberOfAides();
		}
	}

	@Then(" there should exist a schedule for the patient and aide created above")
	public void there_should_exist_a_schedule_for_the_patient_and_aide_created_above() {
		createAidePage.verifyScheduleExists();
	}
}
