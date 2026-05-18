package definitions;

import org.testng.Assert;

import actions.PathalogyAction;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.DriverFactory;

public class PayPathologyStepDefinition {
	
	private final PathalogyAction pathoAction = new PathalogyAction(DriverFactory.getDriver());
	
	 @When("click pay on resulted report")
	    public void click_pay_on_resulted_report() {
	        pathoAction.clickpay();
	        System.out.println("Clicked the payment");
	    }

	    @When("enter {string} the payment amount")
	    public void enter_the_payment_amount(String string) {
            pathoAction.enterAmt(string);
	    }

	    @When("click add button")
	    public void click_add_button() {
	        pathoAction.clickadd();
	    }

	    @When("in the payment details page click make payment")
	    public void in_the_payment_details_page_click_make_payment() {
	        pathoAction.ensure_makepay();
	        System.out.println("Make sure payment");
	    }
	    
	    @When("enter the {string} mobile number and click continue button")
	    public void enter_the_mobile_number_and_click_continue_button(String string) {
	        pathoAction.enterMob(string);
	        pathoAction.clickContinue();
	    }

	    @When("click the UPI payment option")
	    public void click_the_upi_payment_option() {
	        pathoAction.chooseUpi();
	        System.out.println("Payment option was choosed");
	    }

	    @When("enter the {string}")
	    public void enter_the(String string) {
	        pathoAction.sendUpiId(string);
	    }

	    @When("click Verify and Pay button")
	    public void click_verify_and_pay_button() {
	        pathoAction.clickVerify();
	        System.out.println("Payment is processing!");
	    }

	    @Then("Payment Success Message will displayed as {string}")
	    public void payment_success_message_will_displayed_as(String string) {
	        String succTxt = pathoAction.getSuccessTxt();
	        System.out.println("Success message text: " + succTxt);
	        Assert.assertTrue(succTxt.contains(string),
	            "Expected message to contain: '" + string + "' but got: '" + succTxt + "'");
	        System.out.println("Payment was done successfully");
	    }
}
