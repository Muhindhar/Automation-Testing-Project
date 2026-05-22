// package definitions;

// import java.util.List;
// import java.util.Map;

// import org.testng.Assert;

// import actions.CallLogFrontofcActions;
// import io.cucumber.java.en.Given;
// import io.cucumber.java.en.Then;
// import io.cucumber.java.en.When;
// import utilities.DriverFactory;
// import utilities.HelperClass;

// public class CallLogfrontofficeStepDefinition {
// 	CallLogFrontofcActions cfa = new CallLogFrontofcActions(DriverFactory.getDriver());

// 	@Given("user is on login page of site")
// 	public void user_is_on_login_page_of_site() {
// 		// Write code here that turns the phrase above into concrete actions
// 		HelperClass.logger.info("User is on login site");
// 		cfa.clckrecp();
// 	}

// 	@Given("click signin button")
// 	public void click_signin_button() {
// 		// Write code here that turns the phrase above into concrete actions
// 		HelperClass.logger.info("Clicking signin button");
// 		cfa.clksign();
// 	}

// 	@Given("user navigates to the front office link")
// 	public void user_navigates_to_the_front_office_link() {
// 		// Write code here that turns the phrase above into concrete actions
// 		HelperClass.logger.info("user is on homepage");
// 		cfa.frontofclink();
// 	}

// 	@Given("user clicks on phone call log link")
// 	public void user_clicks_on_phone_call_log_link() {
// 		// Write code here that turns the phrase above into concrete actions

// 		HelperClass.logger.info("Clicking on phone call log");
// 		cfa.phcalllog();
// 	}

// 	@Given("user click on add call log link")
// 	public void user_click_on_add_call_log_link() {
// 		// Write code here that turns the phrase above into concrete actions
// 		HelperClass.logger.info("clicking on add call log");
// 		cfa.addcall();
// 	}

// 	@When("user enters following details")
// 	public void user_enters_following_details(io.cucumber.datatable.DataTable dataTable) {
// 		// Write code here that turns the phrase above into concrete actions
// 		// For automatic transformation, change DataTable to one of
// 		// E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
// 		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
// 		// Double, Byte, Short, Long, BigInteger or BigDecimal.
// 		//
// 		// For other transformations you can register a DataTableType.
// 		HelperClass.logger.info("Taking data from data table");
// 		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
// 		for (Map<String, String> row : data) {
// 			String name = row.get("name");
// 			String phone = row.get("phone");
// 			String description = row.get("description");
// 			String calltype = row.get("calltype");
// 			String note = row.get("note");
// 			String duration = row.get("call duration");

// 			cfa.enterdet(name, phone, description, calltype, note, duration);
// 		}
// 	}

// 	@When("click save button")
// 	public void click_save_button() {
// 		// Write code here that turns the phrase above into concrete actions
// 		HelperClass.logger.info("saving");
// 		cfa.clicksave();
// 	}

// 	@Then("user should be able to see in the call log list")
// 	public void user_should_be_able_to_see_in_the_call_log_list() {
// 		// Write code here that turns the phrase above into concrete actions
// 		HelperClass.logger.info("List displayed");
// 		String s = "Phone Call Log List";
// 		String act = cfa.checklist();
// 		Assert.assertEquals(act, s);
// 		HelperClass.logger.info("Listed");
// 		System.out.println(cfa.checklist());
// 	}

// 	@Given("user clicks on Phone Call Log link in site")
// 	public void user_clicks_on_phone_call_log_link_in_site() {
// 		// Write code here that turns the phrase above into concrete actions
// 		HelperClass.logger.info("Clicking on phone call log for checking invalid");
// 		cfa.phcalllog();
// 	}

// 	@Given("user clicks the  Add Call Log link")
// 	public void user_clicks_the_add_call_log_link() {
// 		// Write code here that turns the phrase above into concrete actions
// 		HelperClass.logger.info("clicking on add call log for checking invalid");
// 		cfa.addcall();
// 	}

// 	@Given("user leaves mandatory fields empty")
// 	public void user_leaves_mandatory_fields_empty() {
// 		// Write code here that turns the phrase above into concrete actions
// 		HelperClass.logger.info("Leaving fields empty");
// 	}

// 	@Given("user clicks on Save button")
// 	public void user_clicks_on_save_button() {
// 		// Write code here that turns the phrase above into concrete actions
// 		HelperClass.logger.info("CLicking the save button");
// 		cfa.clicksave();
// 	}

// 	@Then("validation error message should be displayed")
// 	public void validation_error_message_should_be_displayed() {
// 		// Write code here that turns the phrase above into concrete actions
// 		Assert.assertTrue(cfa.errorcheck());
// 		HelperClass.logger.info("Error displayed");
// 		System.out.println("Error message displayed");

// 	}

// }

package definitions;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import actions.CallLogFrontofcActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.DriverFactory;
import utilities.HelperClass;

public class CallLogfrontofficeStepDefinition {
	CallLogFrontofcActions cfa = new CallLogFrontofcActions(DriverFactory.getDriver());

	@Given("user is on login page of site")
	public void user_is_on_login_page_of_site() {
		// Write code here that turns the phrase above into concrete actions
		HelperClass.logger.info("User is on login site");
		cfa.clckrecp();
	}

	@Given("click signin button")
	public void click_signin_button() {
		// Write code here that turns the phrase above into concrete actions
		HelperClass.logger.info("Clicking signin button");
		cfa.clksign();
	}

	@Given("user navigates to the front office link")
	public void user_navigates_to_the_front_office_link() {
		// Write code here that turns the phrase above into concrete actions
		HelperClass.logger.info("user is on homepage");
		cfa.frontofclink();
	}

	@Given("user clicks on phone call log link")
	public void user_clicks_on_phone_call_log_link() {
		// Write code here that turns the phrase above into concrete actions

		HelperClass.logger.info("Clicking on phone call log");
		cfa.phcalllog();
	}

	@Given("user click on add call log link")
	public void user_click_on_add_call_log_link() {
		// Write code here that turns the phrase above into concrete actions
		HelperClass.logger.info("clicking on add call log");
		cfa.addcall();
	}

	@When("user enters following details")
	public void user_enters_following_details(io.cucumber.datatable.DataTable dataTable) {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte, Short, Long, BigInteger or BigDecimal.
		//
		// For other transformations you can register a DataTableType.
		HelperClass.logger.info("Taking data from data table");
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> row : data) {
			String name = row.get("name");
			String phone = row.get("phone");
			String description = row.get("description");
			String calltype = row.get("calltype");
			String note = row.get("note");
			String duration = row.get("call duration");

			cfa.enterdet(name, phone, description, calltype, note, duration);
		}
	}

	@When("click save button")
	public void click_save_button() {
		// Write code here that turns the phrase above into concrete actions
		HelperClass.logger.info("saving");
		cfa.clicksave();
	}

	@Then("user should be able to see in the call log list")
	public boolean user_should_be_able_to_see_in_the_call_log_list() {
		// Write code here that turns the phrase above into concrete actions
		HelperClass.logger.info("List displayed");
		String s = "Phone Call Log List";
		String act = cfa.checklist();
		Assert.assertEquals(act, s);
		HelperClass.logger.info("Listed");
		return true;
	}

	@Given("user clicks on Phone Call Log link in site")
	public void user_clicks_on_phone_call_log_link_in_site() {
		// Write code here that turns the phrase above into concrete actions
		HelperClass.logger.info("Clicking on phone call log for checking invalid");
		cfa.phcalllog();
	}

	@Given("user clicks the  Add Call Log link")
	public void user_clicks_the_add_call_log_link() {
		// Write code here that turns the phrase above into concrete actions
		HelperClass.logger.info("clicking on add call log for checking invalid");
		cfa.addcall();
	}

	@Given("user leaves mandatory fields empty")
	public void user_leaves_mandatory_fields_empty() {
		// Write code here that turns the phrase above into concrete actions
		HelperClass.logger.info("Leaving fields empty");
	}

	@Given("user clicks on Save button")
	public void user_clicks_on_save_button() {
		// Write code here that turns the phrase above into concrete actions
		HelperClass.logger.info("CLicking the save button");
		cfa.clicksave();
	}

	@Then("validation error message should be displayed")
	public boolean validation_error_message_should_be_displayed() {
		// Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(cfa.errorcheck());
		HelperClass.logger.info("Error displayed");
		System.out.println("Error message displayed");
		return true;


	}

}

