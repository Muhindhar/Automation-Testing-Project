package definitions;

import io.cucumber.java.en.Given;

public class CommonStepDefinition {
	@Given("the user launches the application")
	public void the_user_launches_the_application() {
		Helper.launchApplication();
	}
	
}
