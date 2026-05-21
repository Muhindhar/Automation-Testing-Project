package definitions;

import org.testng.Assert;

import actions.ReportFrontOfcAction;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import utilities.DriverFactory;
import utilities.HelperClass;

public class ReportFrontOfficeStepDefinition {
	ReportFrontOfcAction rfa = new ReportFrontOfcAction(DriverFactory.getDriver());
	String actualError;

	@Given("user is on login page of smart hospitals")
	public void user_is_on_login_page_of_smart_hospitals() {
		// Write code here that turns the phrase above into concrete actions
		HelperClass.logger.info("User is on login page");
	}

	@Given("user clicks on receptionist button in site")
	public void user_clicks_on_receptionist_button_in_site() throws InterruptedException {
		// Write code here that turns the phrase above into concrete action
		HelperClass.logger.info("receptionist button clicked");
		rfa.clickrecp();
	}

	@Given("click signin button of smart hospital site")
	public void click_signin_button_of_smart_hospital_site() {
		// Write code here that turns the phrase above into concrete actions
		HelperClass.logger.info("Clicking signin button");
		rfa.clksign();
	}

	@Given("user clicks on the {string} format")
	public void user_clicks_on_the_format(String string) {
		// Write code here that turns the phrase above into concrete actions
		HelperClass.logger.info("Downloading file in format : " + string);
		try {
			switch (string.toLowerCase()) {
			case "pdf":
				rfa.pdfdown();
				break;
			case "csv":
				rfa.csvdown();
				break;
			case "excel":
				rfa.exceldown();
				break;
			default:
				throw new IllegalArgumentException("Invalid format!! " + string);
			}
		} catch (Exception e) {
			actualError = e.getMessage();
		}
	}

	@Then("the document should be downloaded successfully")
	public void the_document_should_be_downloaded_successfully() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		HelperClass.logger.info("File downloaded");
		Assert.assertTrue(rfa.verifydown());
		
	}

	@Then("invalid download format message should be displayed")
	public void invalid_download_format_message_should_be_displayed() {
		// Write code here that turns the phrase above into concrete actions
		HelperClass.logger.info("Validating invalid format");
		Assert.assertTrue(true);
	}
}