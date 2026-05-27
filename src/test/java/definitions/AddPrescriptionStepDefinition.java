package definitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import actions.PrescriptionAction;
import utilities.DriverFactory;
import utilities.ExcelUtility;
import utilities.HelperClass;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class AddPrescriptionStepDefinition {

    private final PrescriptionAction prescriptionAction =
            new PrescriptionAction(DriverFactory.getDriver());

    private static final String EXCEL_FILE_PATH  = "src/test/resources/testdata/PrescriptionTestData.xlsx";
    private static final String EXCEL_SHEET_NAME = "Sheet1";
    private static final String IPD_NUMBER       = "128";

    @When("clicks the IPD -In Patient menu")
    public void clicks_the_ipd_in_patient_menu() {
        HelperClass.logger.info("Clicking IPD menu");
        prescriptionAction.clickIPDMenu();
    }

    @And("searches patient by IPD Number")
    public void searches_patient_by_ipd_number() {
        HelperClass.logger.info("Searching patient by IPD Number");
        prescriptionAction.searchPatientByIPD(IPD_NUMBER);
    }

    @Then("only patient with that IPD should be displayed")
    public void only_patient_with_that_ipd_should_be_displayed() {
        HelperClass.logger.info("Verifying patient display");
        Assert.assertTrue(
                prescriptionAction.isCorrectPatientDisplayed(IPD_NUMBER),
                "Expected patient IPD: " + IPD_NUMBER + " was not displayed.");
    }

    @When("clicks that IPD Number")
    public void clicks_that_ipd_number() {
        HelperClass.logger.info("Clicking IPD number");
        prescriptionAction.clickIPDNumber(IPD_NUMBER);
    }

    @And("clicks on Prescription tab")
    public void clicks_on_prescription_tab() {
        HelperClass.logger.info("Clicking Prescription tab");
        prescriptionAction.clickPrescriptionTab();
    }

    @And("clicks on Add Prescription button")
    public void clicks_on_add_prescription_button() {
        HelperClass.logger.info("Clicking Add Prescription button");
        prescriptionAction.clickAddPrescription();
    }
    
    @When("fills the valid prescription details")
    public void fills_the_valid_prescription_details() throws IOException {
        HelperClass.logger.info("Filling valid prescription details from Excel");

        int row = 1;

        prescriptionAction.enterHeaderNote(
                ExcelUtility.getCellData(EXCEL_FILE_PATH, EXCEL_SHEET_NAME, row, 0));
        prescriptionAction.selectPrescribeBy(
                ExcelUtility.getCellData(EXCEL_FILE_PATH, EXCEL_SHEET_NAME, row, 1));
        prescriptionAction.selectPathology(
                ExcelUtility.getCellData(EXCEL_FILE_PATH, EXCEL_SHEET_NAME, row, 2));
        prescriptionAction.selectRadiology(
                ExcelUtility.getCellData(EXCEL_FILE_PATH, EXCEL_SHEET_NAME, row, 3));
        prescriptionAction.enterFindingCategory(
                ExcelUtility.getCellData(EXCEL_FILE_PATH, EXCEL_SHEET_NAME, row, 4));
        prescriptionAction.enterFindings(
                ExcelUtility.getCellData(EXCEL_FILE_PATH, EXCEL_SHEET_NAME, row, 5));
        prescriptionAction.enterFindingDescription(
                ExcelUtility.getCellData(EXCEL_FILE_PATH, EXCEL_SHEET_NAME, row, 6));
        prescriptionAction.selectMedicineCategory(
                ExcelUtility.getCellData(EXCEL_FILE_PATH, EXCEL_SHEET_NAME, row, 7));
        prescriptionAction.selectMedicine(
                ExcelUtility.getCellData(EXCEL_FILE_PATH, EXCEL_SHEET_NAME, row, 8));
        prescriptionAction.selectDose(
                ExcelUtility.getCellData(EXCEL_FILE_PATH, EXCEL_SHEET_NAME, row, 9));
        prescriptionAction.selectDoseInterval(
                ExcelUtility.getCellData(EXCEL_FILE_PATH, EXCEL_SHEET_NAME, row, 10));
        prescriptionAction.selectDoseDuration(
                ExcelUtility.getCellData(EXCEL_FILE_PATH, EXCEL_SHEET_NAME, row, 11));
        prescriptionAction.enterInstruction(
                ExcelUtility.getCellData(EXCEL_FILE_PATH, EXCEL_SHEET_NAME, row, 12));
        prescriptionAction.uploadAttachment(
                ExcelUtility.getCellData(EXCEL_FILE_PATH, EXCEL_SHEET_NAME, row, 13));
        prescriptionAction.enterFooterNote(
                ExcelUtility.getCellData(EXCEL_FILE_PATH, EXCEL_SHEET_NAME, row, 14));
    }

    @When("enters prescription details")
    public void enters_prescription_details(DataTable dataTable) {
        HelperClass.logger.info("Entering prescription details");

        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        Map<String, String> data = rows.get(0);

        prescriptionAction.enterHeaderNote(data.get("headerNote"));
        prescriptionAction.selectPrescribeBy(data.get("prescribeBy"));
    }

    @When("clicks on Save")
    public void clicks_on_save() {
        HelperClass.logger.info("Clicking Save button");
        prescriptionAction.clickSave();
    }

    @Then("the prescription should be saved successfully")
    public void the_prescription_should_be_saved_successfully() {
        HelperClass.logger.info("Verifying prescription saved");
        Assert.assertTrue(
                prescriptionAction.isPrescriptionSaved(),
                "Prescription was not saved successfully.");
    }

    @Then("the prescription should appear in the prescription list")
    public void the_prescription_should_appear_in_the_prescription_list() {
        HelperClass.logger.info("Verifying prescription in list");
        Assert.assertTrue(
                prescriptionAction.isPrescriptionInList(),
                "Prescription row not found in the prescription list.");
    }

    @Then("an error message should be displayed as {string}")
    public void an_error_message_should_be_displayed_as(String expectedMessage) {
        String actualMessage = prescriptionAction.getErrorMessage();
        Assert.assertTrue(
                actualMessage.contains(expectedMessage),
                String.format("Expected: '%s' but got: '%s'", expectedMessage, actualMessage));
    }
}