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


    @When("the user clicks the ID link for that patient")
    public void the_user_clicks_the_icon_for_that_patient() {
        ra.clickShowIcon();
    }

    @And("navigates to the Visits tab")
    public void navigates_to_the_tab() {
        ra.clickVisitsTab();
    }

    @And("clicks the Pdf icon on the visit record")
    public void clicks_the_icon_on_a_specific_visit_record() {
        ra.clickPrintIcon();
    }

    @Then("the report should be downloaded successfully")
    public void the_report_should_be_downloaded_successfully() {
        Assert.assertTrue(ra.isReportDownloadedSuccessfully(),
            "Report did not open/download successfully.");
    }
}