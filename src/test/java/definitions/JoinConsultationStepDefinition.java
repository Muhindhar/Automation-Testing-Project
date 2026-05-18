package definitions;

import org.testng.Assert;

import actions.JoinConsultationAction;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.DriverFactory;

public class JoinConsultationStepDefinition {
	
	JoinConsultationAction ja = new JoinConsultationAction(DriverFactory.getDriver());
	private int index;
	
	@When("clicks on the live consultation from the sidebar")
	public void clicks_on_the_live_consultation_from_the_sidebar() {
	    ja.clickLiveConsultationDropDown();
	}

	@When("clicks on the live consultation from the dropdown appeared")
	public void clicks_on_the_live_consultation_from_the_dropdown_appeared() {
		ja.clickLiveConsultationOption();
	}

	@Given("the user identifies a consultation record with status {string}")
	public void the_user_identifies_a_consultation_record_with_status(String string) {
	   index = ja.findRecordWithStatus(string);
	}
//
//	@Then("the Join button should be visible for that consultation")
//	public void the_join_button_should_be_visible_for_that_consultation() {
//	    Assert.assertTrue(ja.isActionPresent(index));
//	}

	@Then("the user should be able to click the Join button")
	public void the_user_should_be_able_to_click_the_join_button() {
	    
	}

	@Given("the user identifies a consultation record with status not {string}")
	public void the_user_identifies_a_consultation_record_with_status_not(String string) {
	   
	}

	@Then("the Join button should not be visible for that consultation")
	public void the_join_button_should_not_be_visible_for_that_consultation() {
	    
	}

	@When("the user clicks the Join button")
	public void the_user_clicks_the_join_button() {
	    
	}

	@Then("the consultation popup should be displayed")
	public void the_consultation_popup_should_be_displayed() {
	   
	}

	@Then("the Start Now button should be visible in the popup")
	public void the_start_now_button_should_be_visible_in_the_popup() {
	    
	}

	@When("the user clicks the Start Now button")
	public void the_user_clicks_the_start_now_button() {
	    
	}

	@Then("a new browser tab should be opened")
	public void a_new_browser_tab_should_be_opened() {
	    
	}

	@Then("the Zoom meeting URL should contain {string}")
	public void the_zoom_meeting_url_should_contain(String string) {
	    
	}
}
