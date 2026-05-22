package definitions;
import org.testng.Assert;

import actions.PathalogyAction;
import io.cucumber.java.en.*;
import utilities.ConfigReader;
import utilities.DriverFactory;
import utilities.HelperClass;
public class SearchPathalogyStepDefinition {


    private final PathalogyAction pathoAction = new PathalogyAction(DriverFactory.getDriver());

    //for search step definition
    
    private final String billNo = ConfigReader.getProperty("billNo");
    private final String invalidBillNo = ConfigReader.getProperty("invalidBillNo");
    
    @Given("the user clicks on the Sign In button")
    public void the_user_clicks_on_the_sign_in_button() {
        DriverFactory.getDriver().get("https://demo.smart-hospital.in/site/userlogin");
        HelperClass.logger.info("Clicking Sign In button");
        pathoAction.clickSignup();
    }
    
    @Then("the user should be redirected to the patient dashboard")
    	String currentUrl = DriverFactory.getDriver().getCurrentUrl();
        String currentUrl = DriverFactory.getDriver().getCurrentUrl();

        HelperClass.logger.info("Current URL: {}", currentUrl);
        Assert.assertTrue(
            currentUrl.contains("patient") || currentUrl.contains("dashboard"),
            "User is NOT on patient dashboard. Actual URL: " + currentUrl
        );
        HelperClass.logger.info("User redirected to patient dashboard successfully");
    }

    @When("the user clicks the Pathology menu")
    public void the_user_clicks_the_pathology_menu() {
        HelperClass.logger.info("Clicking Pathology menu");
        pathoAction.clickPathology();
    }

    @When("the user searches pathology reports by valid bill number")
    public void the_user_searches_pathology_reports_by_valid_bill_number() {
        String billNo = ConfigReader.getProperty("billNo");
        HelperClass.logger.info("Searching pathology report with Bill Number: {}", billNo);
        pathoAction.searchreport(billNo);
    }
   
    @When("the user searches pathology reports by invalid bill number")
    public void the_user_searches_pathology_reports_by_invalid_bill_number() {
        String invalidBillNo = ConfigReader.getProperty("invalidBillNo");
        HelperClass.logger.info("Searching with invalid Bill Number: {}", invalidBillNo);
        pathoAction.invalidSearch(invalidBillNo);
    }

    @Then("{string} should be displayed")
    public void should_be_displayed(String string) {
        String noFound = pathoAction.getErrorTxt();
        HelperClass.logger.info("Validation message displayed: {}", noFound);
        Assert.assertEquals(string, noFound);
    }

    @When("the user searches pathology reports by valid bill number")
    public void the_user_searches_pathology_reports_by_valid_bill_number() {
        HelperClass.logger.info("Searching pathology report with Bill Number: {}", billNo);
        pathoAction.searchreport(billNo);
    }

    @Then("only pathology report results should be displayed")
    public void only_pathology_report_results_should_be_displayed() {
        pathoAction.isRecDisplayed(billNo);
        HelperClass.logger.info("Validated pathology report for Bill Number: {}", billNo);

    }

    @When("the user searches pathology reports by invalid bill number")
    public void the_user_searches_pathology_reports_by_invalid_bill_number() {
        HelperClass.logger.info("Searching with invalid Bill Number: {}", invalidBillNo);
        pathoAction.invalidSearch(invalidBillNo);

    }
}