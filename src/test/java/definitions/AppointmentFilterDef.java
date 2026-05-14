package definitions;

import org.testng.Assert;

import actions.AppointmentFilterAction;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AppointmentFilterDef {

	AppointmentFilterAction af = new AppointmentFilterAction();
	@When("user clicks on the Today Appointment filter")
	public void user_clicks_on_the_today_appointment_filter() {
		af.clickTodayAppointmentFilter();
	}

	@Then("user should be able to see today's appointment details")
	public void user_should_be_able_to_see_today_s_appointment_details() {
		Assert.assertTrue(af.verifyAppointmentRecordsPresent());
	}

	@When("user clicks on the Upcoming Appointment filter")
	public void user_clicks_on_the_upcoming_appointment_filter() {
		af.clickUpcomingAppointmentFilter();
	}

	@Then("user should be able to see upcoming appointments")
	public void user_should_be_able_to_see_upcoming_appointments() {
		Assert.assertTrue(af.verifyAppointmentRecordsPresent());
	}

	@When("user clicks on the Old Appointment filter")
	public void user_clicks_on_the_old_appointment_filter() {
		af.clickOldAppointmentFilter();
	}

	@Then("user should be able to see old appointments")
	public void user_should_be_able_to_see_old_appointments() {
		Assert.assertTrue(af.verifyAppointmentRecordsPresent());
	}
}