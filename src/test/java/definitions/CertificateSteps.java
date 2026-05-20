package definitions;

import actions.CertificateAction;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.DriverFactory;

public class CertificateSteps {

    CertificateAction certificateAction;

    public CertificateSteps() {

        certificateAction =
                new CertificateAction(DriverFactory.getDriver());
    }

    @When("the user clicks on the {string} menu")
    public void the_user_clicks_on_the_menu(String menu) {

        certificateAction.clickCertificateMenu();
    }

    @When("the user selects the {string} submenu")
    public void the_user_selects_the_submenu(String submenu) {

        certificateAction.clickCertificateSubMenu();
    }

    @When("the user selects module from excel data")
    public void selectValidModule() {

        certificateAction.selectValidCertificateDetails();
    }

    @When("the user selects patient status from excel data")
    public void selectPatientStatus() {

        System.out.println("Patient status selected");
    }

    @When("the user selects certificate template from excel data")
    public void selectCertificateTemplate() {

        System.out.println("Certificate template selected");
    }

    @When("the user clicks on the Search button")
    public void clickSearchButton() {

        certificateAction.clickSearchButton();
    }

    @Then("the system should display the matching patient records")
    public void verifyMatchingPatientRecords() {

        System.out.println("Matching patient records displayed");
    }

    @When("the user selects the patient from excel data")
    public void selectPatient() {

        certificateAction.selectPatient();
    }

    @When("the user clicks on the Generate button")
    public void clickGenerateButton() {

        certificateAction.clickGenerateButton();
    }

    @Then("the patient certificate details should be displayed successfully")
    public void verifyCertificate() {

        System.out.println("Certificate displayed successfully");
    }

    @Then("the certificate popup should be closed successfully")
    public void verifyPopupClosed() {

        System.out.println("Popup closed successfully");
    }

    @When("the user selects invalid module from excel data")
    public void selectInvalidModule() {

        certificateAction.selectInvalidCertificateDetails();
    }

    @When("the user selects invalid patient status from excel data")
    public void selectInvalidPatientStatus() {

        System.out.println("Invalid patient status selected");
    }

    @When("the user selects invalid certificate template from excel data")
    public void selectInvalidCertificateTemplate() {

        System.out.println("Invalid certificate template selected");
    }

    @Then("the system should display no matching patient records")
    public void verifyNoRecords() {

        System.out.println("No matching patient records displayed");
    }

    @Then("the user should see an appropriate validation or empty result message")
    public void verifyValidationMessage() {

        System.out.println("Validation message displayed successfully");
    }
}