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
		jsClick(cfp.recbtnfo);

	}

	public void clksign() {
		jsClick(cfp.signinfo);
	}

	public void frontofclink() {
		jsClick(cfp.frontofc);

	}

	public void phcalllog() {
		jsClick(cfp.phcalllog);
	}

	public void addcall() {
		jsClick(cfp.addlog);
	}

	public void enterdet(String name, String phone, String description, String calltype) {
		sendKeys(cfp.name,name);
		sendKeys(cfp.desc,description);
		if (calltype.equalsIgnoreCase("Incoming")) {
			jsClick(cfp.incom);

		} else if (calltype.equalsIgnoreCase("Outgoing")) {
			jsClick(cfp.outgng);

		}
	}

	public void clicksave() {
		jsClick(cfp.savebtn);

	}

	public String checklist() {

		return getText(cfp.checklist);
	}

	public boolean errorcheck() {
		return isDisplayed(cfp.error);
	}

}
