package definitions;

import org.testng.Assert;

import actions.LoginAction;
import actions.OPD_ReportActions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.DriverFactory;

public class OPD_ReportDefinitions {

    OPD_ReportActions ra;
    LoginAction la;

    @io.cucumber.java.Before
    public void setUp() {
        ra = new OPD_ReportActions(DriverFactory.getDriver());
        la = new LoginAction(DriverFactory.getDriver());
    }

    @Given("the user is on the {string} page")
    public void the_user_is_on_the_page(String pageName) {
        ra.navigateToOPDOutPatientPage();
    }

    @Given("there is an OPD patient with a completed visit")
    public void there_is_an_opd_patient_with_a_completed_visit() {
        Assert.assertTrue(ra.isPatientWithVisitPresent(),
            "No OPD patient with a completed visit found in the table.");
    }

    @When("the user clicks the {string} icon for that patient")
    public void the_user_clicks_the_icon_for_that_patient(String iconName) {
        if (iconName.equalsIgnoreCase("Show")) {
            ra.clickShowIcon();
        }
    }

    @And("navigates to the {string} tab")
    public void navigates_to_the_tab(String tabName) {
        ra.clickVisitsTab();
    }

    @And("clicks the {string} icon on a specific visit record")
    public void clicks_the_icon_on_a_specific_visit_record(String iconName) {
        ra.clickPrintIcon();
    }

    @Then("a print preview should open")
    public void a_print_preview_should_open() {
        Assert.assertTrue(ra.isPrintPreviewOpen(),
            "Print preview did not open in a new tab.");
    }

    @And("the user should be able to save the report as a PDF")
    public void the_user_should_be_able_to_save_the_report_as_a_pdf() {
        Assert.assertTrue(ra.isSaveAsPdfPossible(),
            "Page does not appear to be a printable report.");
    }
}