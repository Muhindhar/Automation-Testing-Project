package actions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.AddVisitorPages;
import utilities.HelperClass;

public class AddVisitorActions extends BaseAction {

	AddVisitorPages vp;

	WebDriverWait wait;

	public AddVisitorActions(WebDriver driver) {

		super(driver);

		this.driver = driver;

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		vp = new AddVisitorPages();
	}

	public void clkaddvistor() {

		HelperClass.logger.info("clicking front office");

		jsClick(vp.frontofc);

		HelperClass.logger.info("clicking add visitor button");

		waitForVisibility(vp.addVisitorBtn);

		jsClick(vp.addVisitorBtn);

		waitForVisibility(vp.visitorName);
	}

	public void enterdetails(String purpose,
			String visitorName,
			String checkinDate) {

		System.out.println(purpose + visitorName + checkinDate);
		
		HelperClass.logger.info("entering visitor details");

		selectByVisibleText(vp.purpose, purpose);

		sendKeys(vp.visitorName, visitorName);

		jsSendKeys(vp.checkinDate, checkinDate);
	}

	public void enterinvaloiddet(String visitorName,
			String phoneNumber,
			String purpose,
			String checkinDate) {

		HelperClass.logger.info("entering invalid visitor details");

		sendKeys(vp.visitorName, visitorName);

		sendKeys(vp.phoneNumber, phoneNumber);

		selectByVisibleText(vp.purpose, purpose);

		jsSendKeys(vp.checkinDate, checkinDate);
	}
	public void clicksave() {

		HelperClass.logger.info("clicking save button");

		jsClick(vp.saveBtn);
	}

	public String getsuccess() {

		HelperClass.logger.info("getting success message");

		return getText(vp.successMessage);
	}

	public boolean validmessage() {

		HelperClass.logger.info("checking validation message");

		return isDisplayed(vp.validationMessage);
	}
}