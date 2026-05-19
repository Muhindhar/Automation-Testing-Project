package definitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import actions.AddVisitorActions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.CSVReaderUtil;
import utilities.DriverFactory;

public class AddVisiorStepDefinition {

	WebDriver driver = DriverFactory.getDriver();

	AddVisitorActions ava = new AddVisitorActions(driver);

	String[] data;

	@When("user clicks on {string} button")
	public void user_clicks_on_button(String button) {

		if (button.equalsIgnoreCase("Add Visitor")) {

			ava.clkaddvistor();
		}
	}

	@When("user enters visitor details from CSV {string}")
	public void user_enters_visitor_details_from_csv(String rowNumber) throws Exception {

		int row = Integer.parseInt(rowNumber);

		data = CSVReaderUtil.getCSVData("src/test/resources/testdata/Addvisitor.csv", row);

		
		ava.enterdetails(data[1], data[2], data[3]);
	}

	@When("user clicks on save button")
	public void user_clicks_on_save_button() {

		ava.clicksave();
	}

	@Then("visitor should be added successfully")
	public void visitor_should_be_added_successfully() {

		Assert.assertTrue(ava.getsuccess().contains("Record Saved Successfully"));
	}

	@When("user enters invalid visitor details from CSV {string}")
	public void user_enters_invalid_visitor_details_from_csv(String rowNumber) throws Exception {

		int row = Integer.parseInt(rowNumber);

		data = CSVReaderUtil.getCSVData("src/test/resources/testdata/Addvisitor.csv", row);

		ava.enterinvaloiddet(data[1], data[2], data[3], data[4]);
	}

	@Then("proper validation message should be displayed")
	public void proper_validation_message_should_be_displayed() {

		Assert.assertTrue(ava.validmessage());
	}

	@Then("mandatory field validation message should be displayed")
	public void mandatory_field_validation_message_should_be_displayed() {

		Assert.assertTrue(ava.validmessage());
	}
}