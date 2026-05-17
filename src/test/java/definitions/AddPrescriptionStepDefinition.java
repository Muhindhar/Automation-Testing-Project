package definitions;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import actions.PrescriptionAction;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.DriverFactory;

public class AddPrescriptionStepDefinition {

    private final PrescriptionAction prescriptionAction =
            new PrescriptionAction(DriverFactory.getDriver());

    // ─────────────────────────────────────────────────────────
    // Background Steps
    // ─────────────────────────────────────────────────────────

    @Given("the doctor user is on the login page")
    public void the_doctor_user_is_on_the_login_page() {
        DriverFactory.getDriver()
                .get("https://demo.smart-hospital.in/site/login");
    }

    @When("the user selects Doctor login")
    public void the_user_selects_doctor_login() {
        // Clicking Doctor tab auto-fills credentials
        prescriptionAction.clickDoctorTab();
    }

    @When("clicks on Login")
    public void clicks_on_login() {
        prescriptionAction.clickSignIn();
    }

    @Then("the doctor dashboard should be displayed")
    public void the_doctor_dashboard_should_be_displayed() {

        WebDriverWait wait =
                new WebDriverWait(
                        DriverFactory.getDriver(),
                        Duration.ofSeconds(15));

        wait.until(ExpectedConditions.not(
                ExpectedConditions.urlContains("/site/login")
        ));

        String currentUrl =
                DriverFactory.getDriver().getCurrentUrl();

        Assert.assertFalse(
                currentUrl.contains("/site/login"),
                "Login failed — still on login page: " + currentUrl
        );
    }

    // ─────────────────────────────────────────────────────────
    // Prescription Scenario Steps
    // ─────────────────────────────────────────────────────────

    @When("clicks the IPD -In Patient menu")
    public void clicks_the_ipd_in_patient_menu() {
        prescriptionAction.clickIPDMenu();
    }

    @When("searches patient by IPD Number {string}")
    public void searches_patient_by_ipd_number(String ipdNumber) {
        prescriptionAction.searchPatientByIPD(ipdNumber);
    }

    @Then("only patient {string} IPD should be displayed")
    public void only_patient_ipd_should_be_displayed(String ipdNumber) {

        Assert.assertTrue(
                prescriptionAction.isCorrectPatientDisplayed(ipdNumber),
                "Expected patient with IPD "
                        + ipdNumber
                        + " to be displayed"
        );
    }

    @When("clicks the IPD Number {string}")
    public void clicks_the_ipd_number(String ipdNumber) {
        prescriptionAction.clickIPDNumber(ipdNumber);
    }

    @When("clicks on Prescription")
    public void clicks_on_prescription() {
        prescriptionAction.clickPrescriptionTab();
    }

    @When("clicks on Add Prescription")
    public void clicks_on_add_prescription() {
        prescriptionAction.clickAddPrescription();
    }

    // ─────────────────────────────────────────────────────────
    // Data Table Step
    // ─────────────────────────────────────────────────────────

    @When("enters prescription details")
    public void enters_prescription_details(DataTable dataTable) {

        List<Map<String, String>> prescriptionData =
                dataTable.asMaps(String.class, String.class);

        for (Map<String, String> data : prescriptionData) {

            prescriptionAction.enterHeaderNote(data.get("headerNote"));

            prescriptionAction.selectPrescribeBy(data.get("prescribeBy"));

            prescriptionAction.selectPathology(data.get("pathology"));

            prescriptionAction.selectRadiology(data.get("radiology"));

            prescriptionAction.enterFindingCategory(data.get("findingCategory"));

            prescriptionAction.enterFindings(data.get("findings"));
            
            prescriptionAction.enterFindingDescription(data.get("findingDescription"));

            prescriptionAction.selectMedicineCategory(data.get("medicineCategory"));

            prescriptionAction.selectMedicine(data.get("medicine"));

            prescriptionAction.selectDose(data.get("dose"));

            prescriptionAction.selectDoseInterval(data.get("doseInterval"));

            prescriptionAction.selectDoseDuration(data.get("doseDuration"));

            prescriptionAction.enterInstruction(data.get("instruction"));

            prescriptionAction.uploadAttachment(data.get("attachmentPath"));

            prescriptionAction.enterFooterNote(data.get("footerNote"));
        }
    }

    @When("clicks on Save")
    public void clicks_on_save() {
        prescriptionAction.selectDoctorNotification();
        prescriptionAction.clickSave();
    }

    // ─────────────────────────────────────────────────────────
    // Assertions
    // ─────────────────────────────────────────────────────────

    @Then("the prescription should be saved successfully")
    public void the_prescription_should_be_saved_successfully() {

        Assert.assertTrue(
                prescriptionAction.isPrescriptionSaved(),
                "Prescription was not saved successfully"
        );
    }

    @Then("the prescription should appear in the prescription list")
    public void the_prescription_should_appear_in_the_prescription_list() {

        Assert.assertTrue(
                prescriptionAction.isPrescriptionInList(),
                "Expected new prescription in the list, "
                        + "but it was not found."
        );
    }
}