package definitions;

import java.util.Map;

import org.junit.Assert;

import actions.JoinConsultationAction;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.CSVReaderUtil;
import utilities.DriverFactory;

public class AddConsultationStepDefinition {

	JoinConsultationAction ja = new JoinConsultationAction(DriverFactory.getDriver());

	Map<String, String> excelData;

	@When("clicks on the add button")
	public void clicks_on_the_add_button() {

		ja.clickAddButton();
	}

	@When("User enters consultation details for {string}")
	public void user_enters_consultation_details_for(String testCase) throws Exception {

		excelData =
		        CSVReaderUtil.getTestDataByTestCase(
		                "AddConsultation_TestData",
		                testCase);

		ja.setPatient(excelData.get("patient"));
//		ja.setConsultationTitle(excelData.get("title"));
//		ja.setConsultantDoctor(excelData.get("doctor"));
//		ja.setDuration(excelData.get("duration"));
//		ja.setConsultationDate(excelData.get("date"));
	}

	@When("User clicks on Save button")
	public void user_clicks_on_save_button() {

		ja.clickSaveButton();
	}

	@Then("Consultation should be added successfully")
	public void consultation_should_be_added_successfully() {

		String actualMessage = ja.getToastMessage();

		Assert.assertTrue(actualMessage.contains("Record Saved Successfully"));
	}

	@Then("Validation message should be displayed for mandatory fields")
	public void validation_message_should_be_displayed_for_mandatory_fields() {

		String actualMessage = ja.getToastMessage();

		Assert.assertTrue(actualMessage.contains("required"));
	}
}