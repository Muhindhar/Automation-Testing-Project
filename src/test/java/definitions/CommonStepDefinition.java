package definitions;

import actions.PathalogyAction;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import utilities.DriverFactory;

public class CommonStepDefinition {
	
	private final PathalogyAction pathoAction = new PathalogyAction(DriverFactory.getDriver());
	
	@Given("the user launches the application")
	public void the_user_launches_the_application() {
		Helper.launchApplication();
	}

}
