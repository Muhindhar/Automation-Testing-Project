package definitions;

import java.util.Map;

import org.testng.Assert;

import actions.OPD_AddPatientActions;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.DriverFactory;

public class OPD_AddPatientDefinitions {

    OPD_AddPatientActions apa;

    @Before
    public void init() {
        apa = new OPD_AddPatientActions(DriverFactory.getDriver());
    }

    @When("the user clicks the Add Patient button")
    public void the_user_clicks_the_button() {
        apa.clickAddPatientButton();
    }

    @And("selects add icon")
    public void selects_add_icon() {
        apa.clickAddIcon();
    }

    @And("the user fills the Add Patient form with the following details:")
    public void the_user_fills_the_add_patient_form(Map<String, String> data) {
        apa.fillPatientForm(data);
    }
    

    @And("the user fills the Add Patient form with data from Excel")
    public void the_user_fills_the_add_patient_form_with_data_from_excel() throws Exception {
        apa.fillPatientFormFromExcel();
    }

    @And("clicks the {string} button")
    public void clicks_the_button(String buttonName) {
        apa.clickSave();
    }

    @Then("a {string} message should appear")
    public void a_message_should_appear(String message) {
        Assert.assertTrue(apa.isSuccessMessageDisplayed(),
            "Expected success message not displayed: " + message);
    }

    @Then("the system should show a message {string}")
    public void the_system_should_show_a_message(String message) {
        Assert.assertTrue(apa.isNameErrorDisplayed(),
            "Expected error message not displayed: " + message);
    }
}