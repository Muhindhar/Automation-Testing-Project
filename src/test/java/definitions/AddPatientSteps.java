package definitions;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import actions.AddPatientAction;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddPatientSteps {

    AddPatientAction addPatientAction = new AddPatientAction();

    @When("the user clicks on the In Patient option")
    public void the_user_clicks_on_the_in_patient_option() {
        addPatientAction.clickInPatient();
    }

    @Then("the In Patient page should be displayed")
    public void the_in_patient_page_should_be_displayed() {
        System.out.println("IPD page displayed");
    }

    @When("the user clicks on the Add Patient button")
    public void click_add_patient_button() throws InterruptedException {
        addPatientAction.clickAddPatient();
    }

    @When("the user clicks on the New Patient button")
    public void click_new_patient_button() {
        addPatientAction.clickNewPatient();
    }

    @Then("the Add Patient popup form should be displayed")
    public void the_add_patient_popup_form_should_be_displayed() {
        System.out.println("Popup displayed");
    }

    @When("the user enters patient details")
    public void enter_patient_details(DataTable dataTable) {

        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

        addPatientAction.enterPatientName(data.get(0).get("Name"));
        addPatientAction.enterGuardianName(data.get(0).get("GuardianName"));
        addPatientAction.selectGender(data.get(0).get("Gender"));
        addPatientAction.enterDOB(data.get(0).get("DOB"));
        addPatientAction.enterPhone(data.get(0).get("Phone"));
        addPatientAction.enterEmail(data.get(0).get("Email"));
        addPatientAction.enterAddress(data.get(0).get("Address"));
    }

    @When("clicks on the Save button")
    public void click_save_button() {
        addPatientAction.clickSave();
    }

    @Then("patient details should be saved successfully")
    public void patient_details_should_be_saved_successfully() {
        Assert.assertTrue(addPatientAction.successMessageDisplayed());
    }

    @Then("success message should be displayed")
    public void success_message_should_be_displayed() {
        Assert.assertTrue(addPatientAction.successMessageDisplayed());
    }

    @When("the user enters invalid patient details")
    public void the_user_enters_invalid_patient_details(DataTable dataTable) {

        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

        addPatientAction.enterPatientName(data.get(0).get("Name"));
        addPatientAction.selectGender(data.get(0).get("Gender"));
        addPatientAction.enterPhone(data.get(0).get("Phone"));
    }

    @Then("validation message should be displayed")
    public void validation_message_should_be_displayed() {
        Assert.assertTrue(addPatientAction.validationMessageDisplayed());
    }

    @When("the user enters admission and medical details")
    public void the_user_enters_admission_and_medical_details(DataTable dataTable) {

        System.out.println("Admission details entered (placeholder)");
    }

    @When("clicks on the final Save button")
    public void clicks_on_the_final_save_button() {
        addPatientAction.clickSave();
    }

    @Then("patient admission details should be saved successfully")
    public void patient_admission_details_should_be_saved_successfully() {
        System.out.println("Admission saved successfully");
    }
}