package actions;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BloodComponentPage;
import utilities.HelperClass;

public class BloodComponentAction extends BaseAction {
	BloodComponentPage bcp;
	WebDriver driver;
	WebDriverWait wait;
	public BloodComponentAction(WebDriver driver) {
		super(driver);
		this.driver = driver;
		bcp = new BloodComponentPage();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public void clickbilling() {

		try {
			HelperClass.logger.info("clicking billing");
			click(bcp.billing);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void clickbloodcomponent() {
		try {
			HelperClass.logger.info("clicking blood component issue");
			click(bcp.bloodcomp);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickdetails() {

	    try {
	        HelperClass.logger.info("clicking patient details");
	        jsClick(bcp.details);
	    } 
	    catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	public boolean verifydetails() {

		try {
			HelperClass.logger.info("verifying patient details popup");
			return isDisplayed(bcp.patientpopup);
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}