package actions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.CallLogFrontofcPages;
import utilities.HelperClass;

public class CallLogFrontofcActions extends BaseAction {
	
	CallLogFrontofcPages cfp;
	WebDriverWait wait;
	public CallLogFrontofcActions(WebDriver driver) {
		super(driver);
		this.driver = driver;
		 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 cfp = new CallLogFrontofcPages();
		
	}

	public void clckrecp() {
		HelperClass.logger.info("clicking reception button");
		jsClick(cfp.recbtnfo);
	}

	public void clksign() {
		HelperClass.logger.info("clicking sign in button");
		jsClick(cfp.signinfo);
	}

	public void frontofclink() {
		HelperClass.logger.info("clicking front office link");
		jsClick(cfp.frontofc);
	}

	public void phcalllog() {
		HelperClass.logger.info("clicking phone call log button");
		jsClick(cfp.phcalllog);
	}

	public void addcall() {
		HelperClass.logger.info("clicking add call button");
		jsClick(cfp.addlog);
	}

	public void enterdet(String name, String phone, String description, String calltype) {
		sendKeys(cfp.name,name);
		sendKeys(cfp.desc,description);
		if (calltype.equalsIgnoreCase("Incoming")) {
			HelperClass.logger.info("clicking Incoming call ");
			jsClick(cfp.incom);

		} else if (calltype.equalsIgnoreCase("Outgoing")) {
			HelperClass.logger.info("clicking outgoing call");
			jsClick(cfp.outgng);

		}
	}

	public void clicksave() {
		HelperClass.logger.info("clicking save button");
		jsClick(cfp.savebtn);
	}

	public String checklist() {
		HelperClass.logger.info("checking whether the list is visible");
		return getText(cfp.checklist);
	}

	public boolean errorcheck() {
		return isDisplayed(cfp.error);
	}

}
