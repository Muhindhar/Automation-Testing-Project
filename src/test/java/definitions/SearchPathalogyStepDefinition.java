package definitions;

import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import actions.PathalogyAction;
import io.cucumber.java.en.*;
import utilities.DriverFactory;
import utilities.HelperClass;

public class SearchPathalogyStepDefinition {

    private final PathalogyAction pathoAction = new PathalogyAction(DriverFactory.getDriver());

    //for search step definition
    
    @Given("the user is logged into the patient dashboard")
    public void the_user_is_logged_into_the_patient_dashboard() {
    	HelperClass.logger.info("User is on the login page");
    }

    @When("the user clicks on the Sign In button")
    public void the_user_clicks_on_the_sign_in_button() {

        DriverFactory.getDriver().get("https://demo.smart-hospital.in/site/userlogin");
        HelperClass.logger.info("Clicking Sign In button");
        pathoAction.clickSignup();
    }

    @Then("the user should be redirected to the patient dashboard")
    public void the_user_should_be_redirected_to_the_patient_dashboard() {
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(20));

        wait.until(ExpectedConditions.not(ExpectedConditions.urlContains("userlogin")));

        String currentUrl = DriverFactory.getDriver().getCurrentUrl();
        String title      = DriverFactory.getDriver().getTitle();

        HelperClass.logger.info("Current URL: {}",currentUrl);
        HelperClass.logger.info("Current Title: {}",title);
        
        Assert.assertFalse(currentUrl.contains("userlogin"),
            "User is still on login page — login may have failed");

        Assert.assertTrue(
            currentUrl.contains("patient") || currentUrl.contains("dashboard"),
            "User is NOT on patient dashboard. Actual URL: " + currentUrl);
        HelperClass.logger.info("User redirected to patient dashboard successfully");
    }
    
	@When("the user clicks the Pathology menu")
    public void the_user_clicks_the_pathology_menu() {
		HelperClass.logger.info("Clicking Pathology menu");
        pathoAction.clickPathology();
    }

    @When("the user searches pathology reports by Bill Number {string}")
    public void the_user_searches_pathology_reports_by_bill_number(String billNo) {
    	HelperClass.logger.info("Searching pathology report with Bill Number: {}",billNo);
        pathoAction.searchreport(billNo);
    }

    @Then("only pathology report results for Bill Number {string} should be displayed")
    public void only_pathology_report_results_for_bill_number_should_be_displayed(String billNo) {
        pathoAction.isRecDisplayed(billNo);
        HelperClass.logger.info("Validated pathology report for Bill Number: {}",billNo);
    }

    @Then("{string} should be displayed")
    public void should_be_displayed(String string) {
        String NoFound = pathoAction.getErrorTxt();
        HelperClass.logger.info("Validation message displayed: {}",NoFound);
        Assert.assertEquals(string, NoFound);
    }
}