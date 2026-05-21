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
		try {
			HelperClass.logger.info("clicking front office");
			jsClick(vp.frontofc);
			HelperClass.logger.info("Clicking select");
			jsClick(vp.select);
			HelperClass.logger.info("clicking add visitor button");
			waitForVisibility(vp.addVisitorBtn);
			jsClick(vp.addVisitorBtn);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void entervalddet(Map<String, String> data) {
		try {
			HelperClass.logger.info("entering valid visitor details");
			sendKeys(vp.visitorName, data.get("visitorName"));
			sendKeys(vp.phoneNumber, data.get("phoneNumber"));
			selectByVisibleText(vp.purpose, data.get("purpose"));
			jsSendKeys(vp.checkinDate, data.get("date"));
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterinvaldet(Map<String, String> data) {
		try {
			HelperClass.logger.info("entering invalid visitor details");
			sendKeys(vp.visitorName, data.get("visitorName"));
			sendKeys(vp.phoneNumber, data.get("phoneNumber"));
			selectByVisibleText(vp.purpose, data.get("purpose"));
			jsSendKeys(vp.checkinDate, data.get("date"));
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void clicksave() {
		try {
			HelperClass.logger.info("clicking save button");
			jsClick(vp.saveBtn);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getsuccess() {
		try {
			HelperClass.logger.info("getting success message");
			return getText(vp.successmsg);
		} 
		catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	public boolean validmessage() {
		try {
			HelperClass.logger.info("checking validation message");
			return isDisplayed(vp.validationMessage);

		} 
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}