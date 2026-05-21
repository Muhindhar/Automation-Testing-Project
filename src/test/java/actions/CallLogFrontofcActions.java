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
		try {
			HelperClass.logger.info("clicking reception button");
			jsClick(cfp.recbtnfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clksign() {
		try {
			HelperClass.logger.info("clicking sign in button");
			jsClick(cfp.signinfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void frontofclink() {
		try {
			HelperClass.logger.info("clicking front office link");
			jsClick(cfp.frontofc);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void phcalllog() {
		try {
			HelperClass.logger.info("clicking phone call log button");
			jsClick(cfp.phcalllog);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addcall() {
		try {
			HelperClass.logger.info("clicking add call button");
			jsClick(cfp.addlog);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterdet(String name, String phone, String description, String calltype, String note, String duration) {

		try {

			sendKeys(cfp.name, name);

			sendKeys(cfp.phone, phone);

			sendKeys(cfp.desc, description);

			sendKeys(cfp.note, note);

			sendKeys(cfp.callduration, duration);

			if (calltype.equalsIgnoreCase("Incoming")) {

				jsClick(cfp.incom);

			} else if (calltype.equalsIgnoreCase("Outgoing")) {

				jsClick(cfp.outgng);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void clicksave() {
		try {
			HelperClass.logger.info("clicking save button");
			jsClick(cfp.savebtn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String checklist() {
		try {
			HelperClass.logger.info("checking whether the list is visible");
			return getText(cfp.checklist);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	public boolean errorcheck() {
		try {
			return isDisplayed(cfp.error);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}