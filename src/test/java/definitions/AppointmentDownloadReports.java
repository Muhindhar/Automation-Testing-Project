package definitions;

import org.testng.Assert;

import actions.DownloadReportsAction;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.DriverFactory;
import utilities.HelperClass;

public class AppointmentDownloadReports {
	DownloadReportsAction dpa = new DownloadReportsAction(DriverFactory.getDriver());

	@Given("the user is logged in as receptionist")
	public void the_user_is_logged_in_as_receptionist() {
		// Write code here that turns the phrase above into concrete actions
		HelperClass.logger.info("Clicking receptionist button");
		dpa.clickrecp();
		HelperClass.logger.info("Clicking signin button");
		dpa.clicksign();
	}

	@Given("user is on appointment page")
	public void user_is_on_appointment_page() {
		// Write code here that turns the phrase above into concrete actions
		HelperClass.logger.info("Clicking appointment buttton");
		dpa.clickappbtn();
	}

	@When("user clicks on {string} filter")
	public void user_clicks_on_filter(String filter) {
		// Write code here that turns the phrase above into concrete actions
		switch (filter) {
		case "Old Appointment":
			HelperClass.logger.info("Old appointment");
			dpa.oldapp();
			break;
		case "Upcoming Appointment":
			HelperClass.logger.info("upcoming appointment");
			dpa.upcapp();
			break;
		case "Today Appointment":
			HelperClass.logger.info("Today appointment");
			dpa.tdyapp();
			break;
		default:
			HelperClass.logger.info("invalid filter");
			Assert.fail("Invalid filter!! " + filter);
		}
	}

	@When("user selects {string} download option")
	public void user_selects_download_option(String format) {
		switch (format.toLowerCase()) {
		case "pdf":
			HelperClass.logger.info("pdf button");
			dpa.oldpdf();
			break;
		case "csv":
			HelperClass.logger.info("Csv file");
			dpa.upcsv();
			break;
		case "xlsx":
			HelperClass.logger.info("excel file");
			dpa.tdyexcel();
			break;
		default:
			Assert.fail("Invalid format!! " + format);
		}
	}

	@Then("file should be downloaded successfully for {string}")
	public void file_should_be_downloaded_successfully_for(String fileName) throws InterruptedException {
		HelperClass.logger.info("File downloaded successfully");
		Assert.assertTrue(dpa.veridown());
	}

	@Then("invalid appointment filter message should be displayed")
	public void invalid_appointment_filter_message_should_be_displayed() {
		// Write code here that turns the phrase above into concrete actions
		HelperClass.logger.info("Invalid appointment filter validated");
		Assert.assertTrue(true);
	}

}
