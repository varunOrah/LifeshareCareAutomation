package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CreateAidePage;
import pages.SubstitutionPage;

public class substitutionSteps {

	SubstitutionPage substitutionPage = new SubstitutionPage();

	@And("User searches for aide {string}")
	public void user_searches_For_Aide(String aide) throws InterruptedException {
		substitutionPage.enterAideName(aide);
	}
	
	@And("User searches for aide created above")
	public void user_searches_For_Aide_created_above(String aide) throws InterruptedException {
		substitutionPage.enterAideName(CreateAidePage.aideName);
	}
	
	@And("User enters start and end dates")
	public void user_enters_start_and_end_dates() {
		substitutionPage.enterStartAndEndDates();
	}
	@And("User clicks on search button")
	public void user_clicks_on_search_button() {
		substitutionPage.clickSearch();
	}
	
	@Then("User should be able to select substitute aide {string}")
	public void select_substitute_aide(String aide) {
	substitutionPage.selectSubstituteAide(aide);
	}
	
	@When("User clicks on Ok button in the pop up")
	public void acceptSubstitution() {
		substitutionPage.acceptSubstituion();
	}
	
	
	@Then("Substitute should be saves successfully")
	public void verifySubstitutionMessage() throws InterruptedException {
		substitutionPage.verifySubstitutionSuccess();
	}
	
	@Then("No task found message should be displayed")
	public void no_task_found_message_should_be_displayed() throws InterruptedException {
		substitutionPage.verifyNoTaskFOundMsg();
	}

}
