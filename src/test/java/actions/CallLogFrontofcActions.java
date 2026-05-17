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
		click(cfp.recbtnfo);

	}

	public void clksign() {
		click(cfp.signinfo);
	}

	public void frontofclink() {
		click(cfp.frontofc);

	}

	public void phcalllog() {
		click(cfp.phcalllog);
	}

	public void addcall() {
		click(cfp.addlog);
	}

	public void enterdet(String name, String phone, String description, String calltype) {
		sendKeys(cfp.name,name);
		sendKeys(cfp.desc,description);
		if (calltype.equalsIgnoreCase("Incoming")) {
			click(cfp.incom);

		} else if (calltype.equalsIgnoreCase("Outgoing")) {
			click(cfp.outgng);

		}
	}

	public void clicksave() {
		click(cfp.savebtn);

	}

	public String checklist() {

		return getText(cfp.checklist);
	}

	public boolean errorcheck() {
		return isDisplayed(cfp.error);
	}

}
