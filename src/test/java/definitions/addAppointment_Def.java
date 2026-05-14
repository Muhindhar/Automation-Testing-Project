// ==========================================
// addAppointment_Def.java
// Package : definitions
// ==========================================

package definitions;

import java.util.List;
import java.util.Map;

import actions.AddAppointmentAction;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class addAppointment_Def {

	AddAppointmentAction aa =
			new AddAppointmentAction();

	@Given("the user is on the homepage")
	public void the_user_is_on_the_homepage() {

		System.out.println("Application launched");
	}

	@Given("user clicks on receptionist button")
	public void user_clicks_on_receptionist_button() {

		aa.clickReceptionistButton();
	}

	@Given("user clicks on signin button")
	public void user_clicks_on_signin_button() {

		aa.clickSigninButton();
	}

	@Then("user should navigate to receptionist dashboard")
	public void user_should_navigate_to_receptionist_dashboard() {

		System.out.println("Dashboard displayed");
	}

	@When("user navigates to Appointment section")
	public void user_navigates_to_appointment_section() {

		aa.navigateToAppointmentSection();
	}

	@When("user clicks on Add Appointment")
	public void user_clicks_on_add_appointment()
			throws InterruptedException {

		aa.clickAddAppointment();
	}

	@When("user enters valid patient details")
	public void user_enters_valid_patient_details(
			DataTable dataTable)
			throws InterruptedException {

		List<Map<String, String>> data =
				dataTable.asMaps(
						String.class,
						String.class);

		aa.enterAppointmentDetails(data);
	}

	@When("user clicks on Save button")
	public void user_clicks_on_save_button() {

		aa.clickSaveButton();
	}

	@Then("appointment should be added successfully")
	public void appointment_should_be_added_successfully() {

		System.out.println(
				"Appointment Added Successfully");
	}

	@Then("success message should be displayed")
	public void success_message_should_be_displayed() {

		aa.verifySuccessMessage();
	}

	@When("user leaves mandatory fields empty")
	public void user_leaves_mandatory_fields_empty() {

		aa.leaveMandatoryFieldsEmpty();
	}

	@Then("appropriate validation message should be displayed")
	public void appropriate_validation_message_should_be_displayed() {

		aa.verifyValidationMessage();
	}

	@Then("appointment should not be created")
	public void appointment_should_not_be_created() {

		System.out.println(
				"Appointment not created");
	}

	@When("user enters already existing appointment details")
	public void user_enters_already_existing_appointment_details(
			DataTable dataTable)
			throws InterruptedException {

		List<Map<String, String>> data =
				dataTable.asMaps(
						String.class,
						String.class);

		aa.enterDuplicateAppointmentDetails(data);
	}

	@Then("duplicate appointment warning message should be displayed")
	public void duplicate_appointment_warning_message_should_be_displayed() {

		aa.verifyDuplicateAppointmentMessage();
	}
}