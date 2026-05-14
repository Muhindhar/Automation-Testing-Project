package definitions;

import org.testng.Assert;

import actions.LoginAction;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.DriverFactory;

public class LoginStepDefinition {
	
	LoginAction la = new LoginAction(DriverFactory.getDriver());

	@Given("the user is on the login page")
	public void the_user_is_on_the_login_page() {
	    la.goToLoginPage();
	}

	@When("the user enters wrong email")
	public void the_user_enters_wrong_email() {
		la.setUsername(Helper.getPropertyFile().getProperty("email"));
	}

	@When("the user enters wrong password")
	public void the_user_enters_wrong_password() {
		la.setPassword(Helper.getPropertyFile().getProperty("password"));
	}

	@When("clicks on the Login button")
	public void clicks_on_the_login_button() {
	    la.clickLoginButton();
	}

	@Then("an authentication error message should be displayed")
	public void an_authentication_error_message_should_be_displayed() {
		Assert.assertEquals(la.getInvalidErrorMessage(), "Invalid Username or Password");
	}

	@Then("the user should remain on the login page")
	public void the_user_should_remain_on_the_login_page() {
	   Assert.assertEquals(Helper.getPropertyFile().getProperty("loginUrl"), "https://demo.smart-hospital.in/site/login");
	}

	@When("the user enters email")
	public void the_user_enters_email() {
		la.setUsername(Helper.getPropertyFile().getProperty("email"));
	}

	@When("the user leaves the email field empty")
	public void the_user_leaves_the_email_field_empty() {
	  
	}

	@When("the user leaves the password field empty")
	public void the_user_leaves_the_password_field_empty() {
	    
	}

	@Then("validation messages should be displayed for mandatory fields")
	public void validation_messages_should_be_displayed_for_mandatory_fields() {
	    
	}

	@When("the user enters password")
	public void the_user_enters_password() {
		la.setPassword(Helper.getPropertyFile().getProperty("password"));
	}

	@Then("a email required validation message should be displayed")
	public void a_email_required_validation_message_should_be_displayed() {
		Assert.assertEquals(la.getUsernameErrorMessage(), "Username field is required");
	}

	@Then("a password required validation message should be displayed")
	public void a_password_required_validation_message_should_be_displayed() {
	   Assert.assertEquals(la.getPasswordErrorMessage(), "Password field is required");
	}

	@When("the user clicks the {string} button")
	public void the_user_clicks_the_button(String string) {
	    la.clickLogin(string);
	}

	@Then("the user should be redirected to the dashboard")
	public void the_user_should_be_redirected_to_the_dashboard() {
		String url = DriverFactory.getDriver().getCurrentUrl();
		Assert.assertTrue(url.contains("dashboard"));
	}

	@Then("the role of the user in profile should {string}")
	public void the_role_of_the_user_in_profile_should(String string) {
		Assert.assertEquals(la.getUserRole(), string);
	}
}
