package definitions;

import org.testng.Assert;
import actions.PrescriptionAction;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.ConfigReader;
import utilities.DriverFactory;
import utilities.HelperClass;

public class EditDeletePrescriptionStepDefinition {

    private PrescriptionAction prescriptionAction;
    private String ipdNumber;

    public EditDeletePrescriptionStepDefinition() {
        ConfigReader.loadProperties();
        this.ipdNumber = ConfigReader.getProperty("IPDno");
        this.prescriptionAction = new PrescriptionAction(DriverFactory.getDriver());
    }
    
    @When("clicks on View Prescription")
    public void clicks_on_view_prescription() {
        HelperClass.logger.info("Clicking View Prescription");
        prescriptionAction.clickViewPrescription();
    }
    
    //for edit

    @When("clicks on Edit")
    public void clicks_on_edit() {
        HelperClass.logger.info("Clicking Edit");
        prescriptionAction.clickEdit();
    }
    @When("updates the prescription details")
    public void updates_the_prescription_details() {
        HelperClass.logger.info("Updating prescription details for IPD: {}", ipdNumber);
        prescriptionAction.updatePrescriptionDetails();
    }
    @Then("the prescription should be updated successfully")
    public void the_prescription_should_be_updated_successfully() {
        Assert.assertTrue(
            prescriptionAction.isPrescriptionUpdated(),
            "Prescription update failed"
        );
    }
    
    // for delete
    
    @When("clicks on Delete")
    public void clicks_on_delete() {
    	HelperClass.logger.info("Clicking delete");
    	prescriptionAction.clickDelete();
    }
    @Then("a confirmation popup should be displayed")
    public void a_confirmation_popup_should_be_displayed() {
        HelperClass.logger.info("Verifying delete confirmation popup is displayed");
        Assert.assertTrue(
            prescriptionAction.isDeleteConfirmationPopupDisplayed(),
            "Delete confirmation popup was not displayed");
    }
    @When("the user confirms deletion")
    public void the_user_confirms_deletion() {
        HelperClass.logger.info("Confirming deletion");
        prescriptionAction.confirmDelete();
    }
    @Then("the prescription should be deleted successfully")
    public void the_prescription_should_be_deleted_successfully() {
        HelperClass.logger.info("Verifying prescription deleted successfully");
        Assert.assertTrue(
            prescriptionAction.isPrescriptionDeletedSuccessfully(),
            "Prescription deletion failed");
    }
}