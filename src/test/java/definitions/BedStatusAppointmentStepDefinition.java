package definitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import actions.BedStatusAppointmentActions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.DriverFactory;

public class BedStatusAppointmentStepDefinition {
	WebDriver driver = DriverFactory.getDriver();
	BedStatusAppointmentActions bsa = new BedStatusAppointmentActions(driver);
	@When("user clicks on the bed status")
	public void user_clicks_on_the_bed_status() {
		// Write code here that turns the phrase above into concrete actions
		bsa.clickrecp();
		bsa.signin();
		bsa.appointment();
		bsa.clickbed();
	}

	@When("user clicks on the room")
	public void user_clicks_on_the_room() {
		// Write code here that turns the phrase above into concrete actions
		bsa.clickroom();
	}

	@Then("user is able to see the details of the patient")
	public void user_is_able_to_see_the_details_of_the_patient() {
		// Write code here that turns the phrase above into concrete actions

		Assert.assertTrue(bsa.check());
	}

	@Then("user should be able to view bed occupancy details")
	public void user_should_be_able_to_view_bed_occupancy_details() {
		// Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(bsa.check());
	}

}
