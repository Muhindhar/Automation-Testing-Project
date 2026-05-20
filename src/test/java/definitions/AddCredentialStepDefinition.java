package definitions;

import java.io.IOException;

import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import actions.JoinConsultationAction;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.CSVReaderUtil;
import utilities.DriverFactory;
import utilities.ExcelUtility;

public class AddCredentialStepDefinition {

	JoinConsultationAction ja = new JoinConsultationAction(DriverFactory.getDriver());

	Map<String, String> excelData;

	@When("clicks on the add credential button")
	public void clicks_on_the_add_credential_button() {

		ja.clickAddCredentialButton();
	}

	@When("enters the following credential details:")
	public void enters_the_following_credential_details(DataTable dataTable) {

		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

		for (Map<String, String> credentials : data) {

			ja.enterZoomApiKey(credentials.get("zoomApiKey"));

			ja.enterZoomApiSecret(credentials.get("zoomApiSecret"));
		}
	}

	@When("clicks on the save credential button")
	public void clicks_on_the_save_credential_button() throws InterruptedException {

		System.out.println(
			    "API KEY VALUE : " +
			    ja.getZoomApiKeyValue());

			System.out.println(
			    "API SECRET VALUE : " +
			    ja.getZoomApiSecretValue());
		
		ja.clickSaveCredentialButton();
		Thread.sleep(3000);
	}

	@Then("the credential should be saved successfully")
	public void the_credential_should_be_saved_successfully() {

		String actualMessage = ja.getToastMessage();

		Assert.assertEquals("Record Updated Successfully", actualMessage);
	}

	@When("enters invalid credential data for {string}")
	public void enters_invalid_credential_data_for(String testCase) throws IOException {

//		excelData =
//		        ExcelUtility.getTestDataByTestCase(
//		                "AddCredential_TestData",
//		                "AddCredential",
//		                testCase);
		
		excelData =
		        CSVReaderUtil.getTestDataByTestCase(
		                "AddCredential_CSVData",
		                testCase);

		if (excelData.get("zoomApiKey").length() != 0)
			ja.enterZoomApiKey(excelData.get("zoomApiKey"));
		if (excelData.get("zoomApiSecret").length() != 0)
			ja.enterZoomApiSecret(excelData.get("zoomApiSecret"));
	}

	@Then("the validation error message should be displayed")
	public void the_validation_error_message_should_be_displayed() {

	    SoftAssert softAssert = new SoftAssert();

	    String actualMessage = ja.getToastMessage();

	    softAssert.assertTrue(
	        actualMessage.contains("required"),
	        "Validation message mismatch"
	    );

	    softAssert.assertFalse(
	        actualMessage.isEmpty(),
	        "Toast message is empty"
	    );

	    softAssert.assertAll();
	}
	
	@When("clears the credential fields")
	public void clears_the_credential_fields() {
	    ja.clearCredentialFields();
	}
}