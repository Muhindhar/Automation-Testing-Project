package definitions;

import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import actions.PathalogyAction;
import io.cucumber.java.en.*;
import utilities.DriverFactory;

public class SearchPathalogyStepDefinition {

    private final PathalogyAction pathoAction = new PathalogyAction(DriverFactory.getDriver());

    //for search step definition
    
    @Given("the user is logged into the patient dashboard")
    public void the_user_is_logged_into_the_patient_dashboard() {
        System.out.println("User is on the login page");
    }

    @When("the user clicks on the Sign In button")
    public void the_user_clicks_on_the_sign_in_button() {

        DriverFactory.getDriver().get("https://demo.smart-hospital.in/site/userlogin");
        pathoAction.clickSignup();
        System.out.println("Clicked Sign In button");
    }

    @Then("the user should be redirected to the patient dashboard")
    public void the_user_should_be_redirected_to_the_patient_dashboard() {
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(20));

        wait.until(ExpectedConditions.not(ExpectedConditions.urlContains("userlogin")));

        String currentUrl = DriverFactory.getDriver().getCurrentUrl();
        String title      = DriverFactory.getDriver().getTitle();

        System.out.println("Current URL  : " + currentUrl);
        System.out.println("Current Title: " + title);

        Assert.assertFalse(currentUrl.contains("userlogin"),
            "User is still on login page — login may have failed");

        Assert.assertTrue(
            currentUrl.contains("patient") || currentUrl.contains("dashboard"),
            "User is NOT on patient dashboard. Actual URL: " + currentUrl);
    }
    
	@When("the user clicks the Pathology menu")
    public void the_user_clicks_the_pathology_menu() {
        pathoAction.clickPathology();
        System.out.println("Clicked Pathology menu");
    }

    @When("the user searches pathology reports by Bill Number {string}")
    public void the_user_searches_pathology_reports_by_bill_number(String billNo) {
        pathoAction.searchreport(billNo);
        System.out.println("Searching bill number: " + billNo);
    }

    @Then("only pathology report results for Bill Number {string} should be displayed")
    public void only_pathology_report_results_for_bill_number_should_be_displayed(String billNo) {
        pathoAction.isRecDisplayed(billNo);
        System.out.println("Validated bill number: " + billNo);
    }

    @Then("{string} should be displayed")
    public void should_be_displayed(String string) {
        String Nofound = pathoAction.getErrorTxt();
        Assert.assertEquals(string, Nofound);
    }
}