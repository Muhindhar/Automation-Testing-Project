package definitions;

import org.testng.Assert;

import actions.LoginAction;
import actions.ProfileAction;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.DriverFactory;

public class ProfileStepDefinition {
	LoginAction la = new LoginAction(DriverFactory.getDriver());
	ProfileAction pa = new ProfileAction(DriverFactory.getDriver());
	
	@Given("the user is logged into the Smart Hospital portal as {string}")
	public void the_user_is_logged_into_the_smart_hospital_portal_as(String string) {
	    la.goToLoginPage();
	    la.clickLogin(string);
	    la.clickLoginButton();
	}
	
	@When("the user clicks the profile image")
	public void the_user_clicks_the_profile_image() {
	    pa.clickProfileIcon();
	}

	@When("clicks the profile button")
	public void clicks_the_profile_button() {
	    pa.clickProfileButton();
	}


	@Then("the user should be navigated to the profile page showing {string}")
	public void the_user_should_be_navigated_to_the_profile_page_showing(String string) {
	    Assert.assertTrue(pa.getRole().contains(string));
	}
	
	@When("clicks the attendance button")
	public void clicks_the_attendance_button() {
	    pa.clickLeaveButton();
	}

	@Then("the user should be able to view the attendance report")
	public void the_user_should_be_able_to_view_the_attendance_report() {
	    Assert.assertTrue(pa.isLeaveTable());
	}


	


}
