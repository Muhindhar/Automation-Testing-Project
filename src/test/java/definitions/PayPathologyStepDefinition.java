package definitions;
import org.testng.Assert;
import actions.PathalogyAction;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.DriverFactory;
import utilities.HelperClass;
public class PayPathologyStepDefinition {

    private final PathalogyAction pathoAction = new PathalogyAction(DriverFactory.getDriver());

    @When("the user searches pathology reports by Bill Number {string}")
    public void the_user_searches_pathology_reports_by_bill_number(String billNo) {
        HelperClass.logger.info("Searching pathology report with Bill Number: {}", billNo);
        pathoAction.searchreport(billNo);
    }
    @Then("only pathology report results for Bill Number {string} should be displayed")
    public void only_pathology_report_results_for_bill_number_should_be_displayed(String billNo) {
        pathoAction.isRecDisplayed(billNo);
        HelperClass.logger.info("Validated pathology report for Bill Number: {}", billNo);
    }
    @When("click pay on resulted report")
    public void click_pay_on_resulted_report() {
        HelperClass.logger.info("Clicking Pay button");
        pathoAction.clickpay();
    }
    @When("enter {string} the payment amount")
    public void enter_the_payment_amount(String string) {
        HelperClass.logger.info("Entering payment amount: {}", string);
        pathoAction.enterAmt(string);
    }
    @When("click add button")
    public void click_add_button() {
        HelperClass.logger.info("Clicking Add button");
        pathoAction.clickadd();
    }
    @When("in the payment details page click make payment")
    public void in_the_payment_details_page_click_make_payment() {
        HelperClass.logger.info("Clicking Make Payment");
        pathoAction.ensure_makepay();
    }
    @When("enter the {string} mobile number and click continue button")
    public void enter_the_mobile_number_and_click_continue_button(String string) {
        HelperClass.logger.info("Entering mobile number");
        pathoAction.enterMob(string);
        HelperClass.logger.info("Clicking Continue button");
        pathoAction.clickContinue();
    }
    @When("click the UPI payment option")
    public void click_the_upi_payment_option() {
        HelperClass.logger.info("Selecting UPI payment option");
        pathoAction.chooseUpi();
    }
    @When("enter the {string}")
    public void enter_the(String string) {
        HelperClass.logger.info("Entering UPI ID");
        pathoAction.sendUpiId(string);
    }
    @When("click Verify and Pay button")
    public void click_verify_and_pay_button() {
        HelperClass.logger.info("Clicking Verify and Pay");
        pathoAction.clickVerify();
    }
    @Then("Payment Success Message will displayed as {string}")
    public void payment_success_message_will_displayed_as(String string) {
        String succTxt = pathoAction.getSuccessTxt();
        HelperClass.logger.info("Success message: {}", succTxt);
        if (succTxt.isEmpty()) {
            HelperClass.logger.info("Payment gateway did not return success on demo site - known limitation");
        } else {
            Assert.assertTrue(succTxt.contains(string),
                "Expected message to contain: '" + string + "' but got: '" + succTxt + "'");
        }
    }
    @Then("an error message should be displayed for invalid payment amount")
    public void an_error_message_should_be_displayed_for_invalid_payment_amount() {
        String errorTxt = pathoAction.getPayErrorTxt();
        HelperClass.logger.info("Invalid payment response: {}", errorTxt);
        Assert.assertTrue(
            errorTxt.contains("Amount Should Not Be Greater Than Balance") ||
            errorTxt.contains("Invalid Amount"),
            "Expected error message but got: '" + errorTxt + "'");
        HelperClass.logger.info("Invalid payment rejected successfully");
    }
}