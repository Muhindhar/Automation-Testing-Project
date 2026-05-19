package definitions;

import java.io.IOException;
import java.util.Map;

import actions.JoinConsultationAction;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.DriverFactory;
import utilities.ExcelData;

public class AddConsultationStepDefinition {
	
	JoinConsultationAction ja = new JoinConsultationAction(DriverFactory.getDriver());
	
	@When("clicks on the add button")
	public void clicks_on_the_add_button() {
	    ja.clickAddButton();
	}

	@When("User enters consultation details from excel row {int}")
	public void user_enters_consultation_details_from_excel_row(Integer rowNum) throws IOException {

	    Map<String, String> consultationData =
	            ExcelData.getRowData(
	                    "src/test/resources/testdata/consultation.xlsx",
	                    "Sheet1",
	                    rowNum);

	    ja.setPatient(consultationData.get("patient"));

	    ja.setConsultationTitle(
	            consultationData.get("consultationTitle"));

	    ja.setConsultationDate(
	            consultationData.get("consultationDate"));

	    ja.setDuration(
	            consultationData.get("duration"));

	    ja.setOpdOrIpd(
	            consultationData.get("opdOrIpd"));

	    ja.setOpdIpdNo(
	            consultationData.get("opdIpdNo"));

	    ja.setConsultantDoctor(
	            consultationData.get("consultantDoctor"));

	    ja.setHostVideo(
	            consultationData.get("hostVideo"));

	    ja.setClientVideo(
	            consultationData.get("clientVideo"));

	    ja.setDescription(
	            consultationData.get("description"));
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
