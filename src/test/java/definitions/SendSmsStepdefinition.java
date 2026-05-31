package definitions;

import actions.PathologistAction;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.DriverFactory;
import org.testng.Assert;
import utilities.HelperClass;

public class SendSmsStepdefinition {

    private final PathologistAction pathologyAction =
            new PathologistAction(DriverFactory.getDriver());

    @When("the user navigates to admin login")
    public void the_user_navigates_to_admin_login() {
        HelperClass.logger.info("Navigating to admin login page");
        pathologyAction.navigateToAdminLogin();
    }

    @When("the user clicks on the Pathologist login button")
    public void the_user_clicks_on_the_pathologist_login_button() {
        HelperClass.logger.info("Clicking Pathologist button and signing in");
        pathologyAction.clickPathologistBtn();
        pathologyAction.clickSignIn();
    }

    @Then("the user should be redirected to the pathologist dashboard")
    public void the_user_should_be_redirected_to_the_pathologist_dashboard() {
        HelperClass.logger.info("Redirected to pathologist dashboard");
    }

    @When("the user clicks the messaging menu")
    public void the_user_clicks_the_messaging_menu() {
        HelperClass.logger.info("Clicking Messaging menu");
        pathologyAction.clickmsg();
    }

    @When("the user clicks on send SMS tab")
    public void the_user_clicks_on_send_sms_tab() {
        HelperClass.logger.info("Clicking the Send SMS tab");
        pathologyAction.clickSms();
    }

    @When("the user enters the {string}")
    public void the_user_enters_the(String title) {
        HelperClass.logger.info("Entering title: " + title);
        pathologyAction.enterTitle(title);
    }

    @When("the user enters the tempId {string}")
    public void the_user_enters_the_temp_id(String tempId) {
        HelperClass.logger.info("Entering template ID: " + tempId);
        pathologyAction.enterTempId(tempId);
    }

    @When("the user selects the SMS and MobileApp button")
    public void the_user_selects_the_sms_and_mobile_app_button() {
        HelperClass.logger.info("Selecting SMS and MobileApp checkboxes");
        pathologyAction.sendthrough();
    }

    @When("the user enters the message {string}")
    public void the_user_enters_the_message(String message) {
        HelperClass.logger.info("Entering message: " + message);
        pathologyAction.enterMessage(message);
    }

    @When("the user selects the patient and nurse")
    public void the_user_selects_the_patient_and_nurse() {
        HelperClass.logger.info("Selecting Doctor and Nurse recipients");
        pathologyAction.msgTo();
    }

    @When("the user clicks the send button")
    public void the_user_clicks_the_send_button() {
        HelperClass.logger.info("Clicking send button");
        pathologyAction.clickSend();
    }

    @Then("success message {string} should be displayed")
    public void success_message_should_be_displayed(String expected) {
        String actual = pathologyAction.getSuccessMsg();
        Assert.assertEquals(actual, expected, "Success message mismatch");
        HelperClass.logger.info("Success message verified: " + actual);
    }

    @When("the user clicks the send button with empty fields")
    public void the_user_clicks_the_send_button_with_empty_fields() {
        HelperClass.logger.warn("Clicking send with all fields empty");
        pathologyAction.clickSend();
    }

    @Then("error message {string} should be displayed")
    public void error_message_should_be_displayed(String expected) {
        String actual = pathologyAction.getErrorMsg();
        Assert.assertEquals(actual, expected, "Error message mismatch");
        HelperClass.logger.warn("Error message verified: " + actual);
    }

    @When("the user clicks the send button with missing fields")
    public void the_user_clicks_the_send_button_with_missing_fields() {
        HelperClass.logger.warn("Clicking send with missing required fields");
        pathologyAction.clickSend();
    }

    @Then("missing field error {string} should be displayed")
    public void missing_field_error_should_be_displayed(String expected) {
        String actual = pathologyAction.getMissingFieldMsg();
        Assert.assertEquals(actual, expected, "Missing field message mismatch");
        HelperClass.logger.warn("Missing field error verified: " + actual);
    }
}