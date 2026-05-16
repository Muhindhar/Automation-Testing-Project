package definitions;

import java.io.IOException;

import org.testng.Assert;

import actions.ComplaintActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.ExcelUtility;
import utilities.HelperClass;

public class ComplainFo {
	ComplaintActions ca = new ComplaintActions();

	@Given("clicks on the complaint link")
	public void clicks_on_the_complaint_link() {
		// Write code here that turns the phrase above into concrete actions
		HelperClass.logger.info("clicking front office");
		ca.clkfo();
		HelperClass.logger.info("complaint button");
		ca.clkcom();
	}

	@Given("click on the add complaint")
	public void click_on_the_add_complaint() {
		// Write code here that turns the phrase above into concrete actions
		HelperClass.logger.info("adding complaint");
		ca.addcomp();
	}

	@When("user enters the complaint details from excel")
	public void user_enters_the_complaint_details_from_excel() throws IOException {
		// Write code here that turns the phrase above into concrete actions
		HelperClass.logger.info("Taking data from the excel sheet");
		String path = "src\\test\\resources\\FocomplaintData.xlsx";
		String complainttype = ExcelUtility.getCellData(path, "Sheet1", 1, 0);
		String source = ExcelUtility.getCellData(path, "Sheet1", 1, 1);
		String phone = ExcelUtility.getCellData(path, "Sheet1", 1, 2);
		String description = ExcelUtility.getCellData(path, "Sheet1", 1, 3);
		ca.compdet(complainttype, source, phone, description);

	}

	@When("click save button in the site")
	public void click_save_button_in_the_site() {
		// Write code here that turns the phrase above into concrete actions
		HelperClass.logger.info("save button");
		ca.savebtn();
	}

	@Then("user should be able to see the complaints")
	public void user_should_be_able_to_see_the_complaints() {
		// Write code here that turns the phrase above into concrete actions
		HelperClass.logger.info("verifying");
		String exp = "Complain List";
		String act = ca.checklistcom();
		Assert.assertEquals(exp, act);
	}

}
