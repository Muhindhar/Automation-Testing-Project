package actions;

import java.time.Duration;
import java.util.Map;

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
		HelperClass.logger.info("Clicking select ");
		jsClick(vp.select);

		HelperClass.logger.info("clicking add visitor button");

		waitForVisibility(vp.addVisitorBtn);

		jsClick(vp.addVisitorBtn);
	}

	public void entervalddet(Map<String, String> data) {
		HelperClass.logger.info("entering invalid visitor details");
		sendKeys(vp.visitorName, data.get("visitorName"));
		sendKeys(vp.phoneNumber, data.get("phoneNumber"));
		selectByVisibleText(vp.purpose, data.get("purpose"));
		jsSendKeys(vp.checkinDate, data.get("date"));
	}

	public void enterinvaldet(Map<String, String> data) {
		HelperClass.logger.info("entering invalid visitor details");
		sendKeys(vp.visitorName, data.get("visitorName"));
		sendKeys(vp.phoneNumber, data.get("phoneNumber"));
		selectByVisibleText(vp.purpose, data.get("purpose"));
		jsSendKeys(vp.checkinDate, data.get("date"));
	}

	public void clicksave() {
		HelperClass.logger.info("clicking save button");
		jsClick(vp.saveBtn);
	}

	public String getsuccess() {
		HelperClass.logger.info("getting success message");
		return getText(vp.successmsg);
	}

	public boolean validmessage() {

		HelperClass.logger.info("checking validation message");

		return isDisplayed(vp.validationMessage);
	}
}