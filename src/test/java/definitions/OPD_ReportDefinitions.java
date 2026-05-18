package definitions;

import org.testng.Assert;

import actions.LoginAction;
import actions.OPD_ReportActions;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.DriverFactory;

public class OPD_ReportDefinitions {

    OPD_ReportActions ra;
    LoginAction la;

    @Before
    public void init() {
        ra = new OPD_ReportActions(DriverFactory.getDriver());
        la = new LoginAction(DriverFactory.getDriver());
    }

    @Given("the user is on the {string} page")
    public void the_user_is_on_the_page(String pageName) {
        ra.navigateToOPDOutPatientPage();
    }

    @When("the user clicks the {string} icon for that patient")
    public void the_user_clicks_the_icon_for_that_patient(String iconName) {
        ra.clickShowIcon();
    }

    @And("navigates to the {string} tab")
    public void navigates_to_the_tab(String tabName) {
        ra.clickVisitsTab();
    }

    @And("clicks the {string} icon on a specific visit record")
    public void clicks_the_icon_on_a_specific_visit_record(String iconName) {
        ra.clickPrintIcon();
    }

    @Then("the report should be downloaded successfully")
    public void the_report_should_be_downloaded_successfully() {
        Assert.assertTrue(ra.isReportDownloadedSuccessfully(),
            "Report did not open/download successfully.");
    }
}