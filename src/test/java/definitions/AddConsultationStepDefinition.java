package definitions;

import java.util.Map;

import actions.JoinConsultationAction;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.DriverFactory;

public class AddConsultationStepDefinition {
	
	JoinConsultationAction ja = new JoinConsultationAction(DriverFactory.getDriver());
	
	@When("clicks on the add button")
	public void clicks_on_the_add_button() {
		ja.clickAddButton();
	}

	@When("User enters consultation details:")
	public void user_enters_consultation_details(io.cucumber.datatable.DataTable dataTable) {

	    Map<String, String> consultationData = dataTable.asMap(String.class, String.class);

	    String patient = consultationData.get("patient");
	    String consultationTitle = consultationData.get("consultationTitle");
	    String consultationDate = consultationData.get("consultationDate");
	    String duration = consultationData.get("duration");
	    String opdOrIpd = consultationData.get("opdOrIpd");
	    String opdIpdNo = consultationData.get("opdIpdNo");
	    String consultantDoctor = consultationData.get("consultantDoctor");
	    String hostVideo = consultationData.get("hostVideo");
	    String clientVideo = consultationData.get("clientVideo");
	    String description = consultationData.get("description");
	    
	    ja.setPatient(patient);
	}

	@When("User clicks on Save button")
	public void user_clicks_on_save_button() {
	    
	}

	@Then("Consultation should be added successfully")
	public void consultation_should_be_added_successfully() {
	    
	}

	@When("User leaves all consultation fields empty")
	public void user_leaves_all_consultation_fields_empty() {
	    
	}

	@Then("Validation message should be displayed for mandatory fields")
	public void validation_message_should_be_displayed_for_mandatory_fields() {
	    
	}
}
