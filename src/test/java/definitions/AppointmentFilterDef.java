package definitions;

import org.testng.Assert;

import actions.AppointmentFilterAction;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import utilities.DriverFactory;
import utilities.HelperClass;

public class AppointmentFilterDef {

	AppointmentFilterAction af = new AppointmentFilterAction(DriverFactory.getDriver());

	@Given("user clicks on receptionist button")
	public void user_clicks_on_receptionist_button(){

		HelperClass.logger.info("Clicking receptionist button");

		af.recptbnclick();
	}

	@Given("user clicks on signin button")
	public void user_clicks_on_signin_button() {

		HelperClass.logger.info("Clicking signin button");

		af.subbtn();
	}

	@Then("user should navigate to receptionist dashboard")
	public void user_should_navigate_to_receptionist_dashboard() {

		HelperClass.logger.info("Navigated to receptionist dashboard");
	}

	@Then("user navigates to Appointment section")
	public void user_navigates_to_appointment_section() {

		HelperClass.logger.info("Navigating to appointment section");

		af.clickapp();
	}

	@When("user clicks on the Today Appointment filter")
	public void user_clicks_on_the_today_appointment_filter() {

		HelperClass.logger.info("Clicking Today Appointment filter");

		af.clicktdyapp();
	}

	@Then("user should be able to see today's appointment details")
	public void user_should_be_able_to_see_today_s_appointment_details() {

		HelperClass.logger.info("Verifying today's appointment records");

		Assert.assertTrue(af.verifyrecord());
	}

	@When("user clicks on the Upcoming Appointment filter")
	public void user_clicks_on_the_upcoming_appointment_filter() {

		HelperClass.logger.info("Clicking Upcoming Appointment filter");

		af.clickupapp();
	}

	@Then("user should be able to see upcoming appointments")
	public void user_should_be_able_to_see_upcoming_appointments() {

		HelperClass.logger.info("Verifying upcoming appointment records");

		Assert.assertTrue(af.verifyrecord());
	}

	@When("user clicks on the Old Appointment filter")
	public void user_clicks_on_the_old_appointment_filter() {

		HelperClass.logger.info("Clicking Old Appointment filter");

		af.clickoldapp();
	}

	@Then("user should be able to see old appointments")
	public void user_should_be_able_to_see_old_appointments() {

		HelperClass.logger.info("Verifying old appointment records");

		Assert.assertTrue(af.verifyrecord());
	}
}