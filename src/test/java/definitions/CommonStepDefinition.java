package definitions;

import actions.LoginAction;
import io.cucumber.java.en.Given;
import utilities.DriverFactory;

public class CommonStepDefinition {
	LoginAction la = new LoginAction(DriverFactory.getDriver());

	@Given("the user launches the application")
	public void the_user_launches_the_application() {
		Helper.launchApplication();
	}

	@Given("the user is on the login page")
	public void the_user_is_on_the_login_page() {
	    la.goToLoginPage();
	}

}
