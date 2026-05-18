package actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.OPDPage;

public class OPD_SearchActions extends BaseAction {
	OPDPage opdPage;
	WebDriverWait wait;
	
	public OPD_SearchActions(WebDriver driver) {
		super(driver);
		opdPage = new OPDPage(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public void searchPatient(String patientName) {
		sendKeys(opdPage.searchBox,patientName);
		wait.until(ExpectedConditions.visibilityOfElementLocated(opdPage.patientname));
	}
	
	public void navigateToOPDPage() {
		jsClick(opdPage.opdButton);
		jsClick(opdPage.oldOpdTab);
	}
	
	public String verifySearchnameResult() {
	    wait.until(ExpectedConditions.visibilityOfElementLocated(opdPage.patientname));
	    return getText(opdPage.patientname);
	}

	public String verifySearchFailed(){
	    wait.until(ExpectedConditions.visibilityOfElementLocated(opdPage.searchFailed));
	    return getText(opdPage.searchFailed);
	}
}
