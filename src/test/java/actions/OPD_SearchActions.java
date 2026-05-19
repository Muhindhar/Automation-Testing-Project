package actions;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.OPDPage;
import utilities.HelperClass;

public class OPD_SearchActions extends BaseAction {
	OPDPage opdPage;
	WebDriverWait wait;
	
	public OPD_SearchActions(WebDriver driver) {
		super(driver);
		opdPage = new OPDPage(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public void searchPatient(String patientName) {
		HelperClass.logger.info("Passing patient name");
		sendKeys(opdPage.searchBox,patientName);
	}
	
	public void navigateToOPDPage() {
		wait.until(ExpectedConditions.elementToBeClickable(opdPage.opdButton));
		HelperClass.logger.info("clicking opd button");
		jsClick(opdPage.opdButton);
		HelperClass.logger.info("clicking old opd tab");
		wait.until(ExpectedConditions.elementToBeClickable(opdPage.oldOpdTab));
		jsClick(opdPage.oldOpdTab);
	}
	
	public String verifySearchnameResult() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(opdPage.patientname));
	    HelperClass.logger.info("Getting patient name");
	    return getText(opdPage.patientname);
	}

	public String verifySearchFailed(){
	    wait.until(ExpectedConditions.visibilityOfElementLocated(opdPage.searchFailed));
	    HelperClass.logger.info("Search failed");
	    return getText(opdPage.searchFailed);
	}
}
