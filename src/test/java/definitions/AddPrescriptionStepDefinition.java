package definitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import actions.PrescriptionAction;
import utilities.DriverFactory;
import utilities.ExcelUtility;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class AddPrescriptionStepDefinition {

    private final PrescriptionAction prescriptionAction =
            new PrescriptionAction(DriverFactory.getDriver());

    // Column index constants — matches PrescriptionTestData.xlsx column order
    private static final int COL_HEADER_NOTE        = 0;
    private static final int COL_PRESCRIBE_BY       = 1;
    private static final int COL_PATHOLOGY          = 2;
    private static final int COL_RADIOLOGY          = 3;
    private static final int COL_FINDING_CATEGORY   = 4;
    private static final int COL_FINDINGS           = 5;
    private static final int COL_FINDING_DESC       = 6;
    private static final int COL_MEDICINE_CATEGORY  = 7;
    private static final int COL_MEDICINE           = 8;
    private static final int COL_DOSE               = 9;
    private static final int COL_DOSE_INTERVAL      = 10;
    private static final int COL_DOSE_DURATION      = 11;
    private static final int COL_INSTRUCTION        = 12;
    private static final int COL_ATTACHMENT         = 13;
    private static final int COL_FOOTER_NOTE        = 14;

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
                "Expected patient IPD: " + ipdNumber + " was not displayed.");
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

    // -----------------------------------------------------------------------
    //  Excel-driven step  (used by @ValidPrescriptionSave)
    // -----------------------------------------------------------------------

    @When("enters prescription details from Excel file {string} sheet {string} row {int}")
    public void enters_prescription_details_from_excel(String filePath, String sheetName, int rowNum) throws IOException {

        prescriptionAction.enterHeaderNote        (ExcelUtility.getCellData(filePath, sheetName, rowNum, COL_HEADER_NOTE));
        prescriptionAction.selectPrescribeBy      (ExcelUtility.getCellData(filePath, sheetName, rowNum, COL_PRESCRIBE_BY));
        prescriptionAction.selectPathology        (ExcelUtility.getCellData(filePath, sheetName, rowNum, COL_PATHOLOGY));
        prescriptionAction.selectRadiology        (ExcelUtility.getCellData(filePath, sheetName, rowNum, COL_RADIOLOGY));
        prescriptionAction.enterFindingCategory   (ExcelUtility.getCellData(filePath, sheetName, rowNum, COL_FINDING_CATEGORY));
        prescriptionAction.enterFindings          (ExcelUtility.getCellData(filePath, sheetName, rowNum, COL_FINDINGS));
        prescriptionAction.enterFindingDescription(ExcelUtility.getCellData(filePath, sheetName, rowNum, COL_FINDING_DESC));
        prescriptionAction.selectMedicineCategory (ExcelUtility.getCellData(filePath, sheetName, rowNum, COL_MEDICINE_CATEGORY));
        prescriptionAction.selectMedicine         (ExcelUtility.getCellData(filePath, sheetName, rowNum, COL_MEDICINE));
        prescriptionAction.selectDose             (ExcelUtility.getCellData(filePath, sheetName, rowNum, COL_DOSE));
        prescriptionAction.selectDoseInterval     (ExcelUtility.getCellData(filePath, sheetName, rowNum, COL_DOSE_INTERVAL));
        prescriptionAction.selectDoseDuration     (ExcelUtility.getCellData(filePath, sheetName, rowNum, COL_DOSE_DURATION));
        prescriptionAction.enterInstruction       (ExcelUtility.getCellData(filePath, sheetName, rowNum, COL_INSTRUCTION));
        prescriptionAction.uploadAttachment       (ExcelUtility.getCellData(filePath, sheetName, rowNum, COL_ATTACHMENT));
        prescriptionAction.enterFooterNote        (ExcelUtility.getCellData(filePath, sheetName, rowNum, COL_FOOTER_NOTE));
    }

    // -----------------------------------------------------------------------
    //  DataTable-driven step  (used by @MissingMandatoryFields)
    // -----------------------------------------------------------------------

    @When("enters prescription details")
    public void enters_prescription_details(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> data : rows) {
            prescriptionAction.enterHeaderNote        (data.get("headerNote"));
            prescriptionAction.selectPrescribeBy      (data.get("prescribeBy"));
            prescriptionAction.selectPathology        (data.get("pathology"));
            prescriptionAction.selectRadiology        (data.get("radiology"));
            prescriptionAction.enterFindingCategory   (data.get("findingCategory"));
            prescriptionAction.enterFindings          (data.get("findings"));
            prescriptionAction.enterFindingDescription(data.get("findingDescription"));
            prescriptionAction.selectMedicineCategory (data.get("medicineCategory"));
            prescriptionAction.selectMedicine         (data.get("medicine"));
            prescriptionAction.selectDose             (data.get("dose"));
            prescriptionAction.selectDoseInterval     (data.get("doseInterval"));
            prescriptionAction.selectDoseDuration     (data.get("doseDuration"));
            prescriptionAction.enterInstruction       (data.get("instruction"));
            prescriptionAction.uploadAttachment       (data.get("attachmentPath"));
            prescriptionAction.enterFooterNote        (data.get("footerNote"));
        }
    }

    @When("clicks on Save")
    public void clicks_on_save() {
        prescriptionAction.clickSave();
    }

    @When("clicks on Save and Print")
    public void clicks_on_save_and_print() {
        prescriptionAction.clickSaveAndPrint();
    }

    @Then("the prescription should be saved successfully")
    public void the_prescription_should_be_saved_successfully() {
        Assert.assertTrue(
                prescriptionAction.isPrescriptionSaved(),
                "Prescription was not saved successfully. List table did not appear.");
    }

    @Then("the prescription should appear in the prescription list")
    public void the_prescription_should_appear_in_the_prescription_list() {
        Assert.assertTrue(
                prescriptionAction.isPrescriptionInList(),
                "Prescription row not found in the prescription list.");
    }

    @Then("the prescription should be saved successfully and navigated to the print preview page")
    public void the_prescription_should_be_saved_successfully_and_navigated_to_the_print_preview_page() {
        Assert.assertTrue(
                prescriptionAction.isPrescriptionSaved(),
                "Prescription save failed after Save & Print.");
        Assert.assertTrue(
                prescriptionAction.isPrintPreviewOpened(),
                "Print preview page was not opened.");
    }

    @Then("an error message should be displayed as {string}")
    public void an_error_message_should_be_displayed_as(String expectedMessage) {
        String actualMessage = prescriptionAction.getErrorMessage();
        Assert.assertTrue(
                actualMessage.contains(expectedMessage),
                String.format("Expected error message: '%s' but got: '%s'", expectedMessage, actualMessage));
    }
}
