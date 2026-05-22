package actions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

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

			waitForVisibility(cfp.recbtnfo);

			jsClick(cfp.recbtnfo);

		} catch (Exception e) {

			e.printStackTrace();

			Assert.fail("Unable to click receptionist button");
		}
	}

	public void clksign() {

		try {

			HelperClass.logger.info("clicking sign in button");

			waitForVisibility(cfp.signinfo);

			jsClick(cfp.signinfo);

		} catch (Exception e) {

			e.printStackTrace();

			Assert.fail("Unable to click sign in button");
		}
	}

	public void frontofclink() {

		try {

			HelperClass.logger.info("clicking front office link");

			waitForVisibility(cfp.frontofc);

			jsClick(cfp.frontofc);

		} catch (Exception e) {

			e.printStackTrace();

			Assert.fail("Unable to click front office link");
		}
	}

	public void phcalllog() {

		try {

			HelperClass.logger.info("clicking phone call log button");

			waitForVisibility(cfp.phcalllog);

			jsClick(cfp.phcalllog);

		} catch (Exception e) {

			e.printStackTrace();

			Assert.fail("Unable to click phone call log");
		}
	}

	public void addcall() {

		try {

			HelperClass.logger.info("clicking add call button");

			waitForVisibility(cfp.addlog);

			jsClick(cfp.addlog);

		} catch (Exception e) {

			e.printStackTrace();

			Assert.fail("Unable to click add call button");
		}
	}

	public void enterdet(
			String name,
			String phone,
			String description,
			String calltype,
			String note,
			String duration) {

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

			Assert.fail("Unable to enter call details");
		}
	}

	public void clicksave() {

		try {

			HelperClass.logger.info("clicking save button");

			waitForVisibility(cfp.savebtn);

			jsClick(cfp.savebtn);

		} catch (Exception e) {

			e.printStackTrace();

			Assert.fail("Unable to click save button");
		}
	}

	public String checklist() {

		try {

			HelperClass.logger.info("checking whether list is visible");

			waitForVisibility(cfp.checklist);

			return getText(cfp.checklist);

		} catch (Exception e) {

			e.printStackTrace();

			Assert.fail("Checklist not visible");

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