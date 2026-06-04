package definitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import actions.PostalActions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.DriverFactory;

public class PostalFrontOfcStepDefinition {

	WebDriver driver = DriverFactory.getDriver();

	PostalActions pa = new PostalActions(driver);

	@When("user clicks on the postal button")
	public void user_clicks_on_the_postal_button() {

		pa.clickpostal();
	}

	@When("user clicks on the dispatch button")
	public void user_clicks_on_the_dispatch_button() {

		pa.clickdispatch();
	}

	@When("clicks the add dispatch button")
	public void clicks_the_add_dispatch_button() {

		pa.clickadddispatch();
	}

	@When("enters the postal details")
	public void enters_the_postal_details() {

		pa.enterdetails();
	}

	@When("clicks the save button in the site")
	public void clicks_the_save_button_in_the_site() {

		pa.clicksave();
	}

	@Then("user should be able to see their postal details")
	public void user_should_be_able_to_see_their_postal_details() {

		Assert.assertTrue(pa.verifypostal(), "Postal details not displayed");
	}
}