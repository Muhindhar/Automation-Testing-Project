package definitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import actions.BloodComponentAction;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.DriverFactory;

public class BloodComponents {

	WebDriver driver = DriverFactory.getDriver();

	BloodComponentAction bca = new BloodComponentAction(driver);

	@Given("user clicks on the billing link")
	public void user_clicks_on_the_billing_link() {
		bca.clickbilling();
	}

	@When("user clicks on the blood component issue button")
	public void user_clicks_on_the_blood_component_issue_button() {
		bca.clickbloodcomponent();
	}

	@When("user clicks on the data")
	public void user_clicks_on_the_data() {
		bca.clickdetails();
	}

	@Then("user should be able to see the details of the particular person")
	public void user_should_be_able_to_see_the_details_of_the_particular_person() {
		Assert.assertTrue(bca.verifydetails());
	}

	@Then("user should not be able to view the patient details")
	public void user_should_not_be_able_to_view_the_patient_details() {
		Assert.assertFalse(bca.verifydetails());
	}

}