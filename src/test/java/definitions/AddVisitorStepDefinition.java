package definitions;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import actions.AddVisitorActions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.CSVReaderUtil;
import utilities.DriverFactory;

public class AddVisitorStepDefinition {

	WebDriver driver = DriverFactory.getDriver();
	AddVisitorActions ava = new AddVisitorActions(driver);

	@When("user clicks on {string} button")
	public void user_clicks_on_button(String button) {
		if (button.equalsIgnoreCase("Add Visitor")) {
			ava.clkaddvistor();
		}

	}

	@When("user enters visitor details")
	public void user_enters_visitor_details() throws Exception {
		Map<String, String> data = CSVReaderUtil.getTestDataByTestCase("Addvisitor", "valid1");
		ava.entervalddet(data);
	}

	@When("user enters invalid visitor details {string}")
	public void user_enters_invalid_visitor_details(String scenario) throws IOException {
		Map<String, String> data = CSVReaderUtil.getTestDataByTestCase("Addvisitor", "invalid" + scenario);
		ava.enterinvaldet(data);
	}

	@When("user clicks on save button")
	public void user_clicks_on_save_button() {
		ava.clicksave();
	}

	@Then("visitor should be added successfully")
	public void visitor_should_be_added_successfully() {
		Assert.assertTrue(ava.getsuccess().contains("Record Saved Successfully"),
				"Expected success message not displayed");
	}

	@Then("proper validation message should be displayed")
	public void proper_validation_message_should_be_displayed() {
		Assert.assertTrue(ava.validmessage(), "Expected validation message not displayed");
	}

	@Then("mandatory field validation message should be displayed")
	public void mandatory_field_validation_message_should_be_displayed() {
		Assert.assertTrue(ava.validmessage(), "Expected mandatory field validation message not displayed");
	}
}