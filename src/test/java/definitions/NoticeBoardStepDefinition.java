package definitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import actions.NoticeBoardActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.DriverFactory;

public class NoticeBoardStepDefinition {

	WebDriver driver =
			DriverFactory.getDriver();

	NoticeBoardActions nba =
			new NoticeBoardActions(driver);

	public NoticeBoardStepDefinition() {

		System.out.println(
				"NoticeBoardStepDefinition Loaded");
	}

	@Given("user navigates to dashboard section")
	public void user_navigates_to_dashboard_section() {

		System.out.println(
				"User is on dashboard");
	}

	@Given("user clicks on the notice displayed")
	public void user_clicks_on_the_notice_displayed() {

		nba.clknotice();
	}

	@Then("user should be able to see the list of notices")
	public void user_should_be_able_to_see_the_list_of_notices() {

		Assert.assertTrue(

				nba.noticedisplayed(),

				"Notice Board page is not displayed");
	}
}