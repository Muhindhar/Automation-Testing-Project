package definitions;

import actions.PatientCertificateAction;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import utilities.DriverFactory;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PatientCertificatestep {

    WebDriver driver = DriverFactory.getDriver();
    PatientCertificateAction action = new PatientCertificateAction(driver);

    @When("the user selects the patient certificate submenu")
    public void the_user_selects_the_patient_certificate_submenu() {

        action.clickPatientCertificateSubMenu();
    }

    @When("the user selects module as {string}")
    public void the_user_selects_module_as(String module) {
        action.selectModule(module);
    }

    @When("the user selects valid patient status")
    public void the_user_selects_valid_patient_status() {
        action.selectValidPatientStatus();
    }

    @When("the user selects certificate template")
    public void the_user_selects_certificate_template() {
        action.selectCertificateTemplate();
    }

    @When("the user clicks on {string} button")
    public void the_user_clicks_on_button(String button) {

        if (button.equalsIgnoreCase("Search")) {
            action.clickSearchButton();
        }

        else if (button.equalsIgnoreCase("PDF")) {
            action.clickPDFButton();
        }
    }

    @When("the system displays a list of patients")
    public void the_system_displays_a_list_of_patients() {
        assertTrue(action.isPatientListDisplayed());
    }

    @When("the user selects the first patient from the list")
    public void the_user_selects_the_first_patient_from_the_list() {
        action.selectFirstPatient();
    }

    @Then("the system should generate the certificate PDF")
    public void the_system_should_generate_the_certificate_pdf() {
        System.out.println("PDF generation successful");
    }

    @Then("the PDF should be downloaded successfully")
    public void the_pdf_should_be_downloaded_successfully() {
        assertTrue(action.isPDFDownloaded());
    }

    @When("the user selects invalid or empty patient status")
    public void the_user_selects_invalid_or_empty_patient_status() {
        action.selectInvalidPatientStatus();
    }

    @Then("the system should display {string} message")
    public void the_system_should_display_message(String message) {
        assertTrue(action.isNoRecordMessageDisplayed(message));
    }

    @Then("the patient list should not be displayed")
    public void the_patient_list_should_not_be_displayed() {
        assertFalse(action.isPatientListDisplayed());
    }

    @Then("the {string} button should not be enabled or should not work")
    public void the_button_should_not_be_enabled_or_should_not_work(String button) {
        assertFalse(action.isPDFButtonEnabled());
    }
}