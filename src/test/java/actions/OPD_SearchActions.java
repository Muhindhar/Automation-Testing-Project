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
		click(opdPage.opdButton);
		click(opdPage.oldOpdTab);
	}
	
	public String verifySearchnameResult() throws InterruptedException {
		Thread.sleep(2000);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(opdPage.patientname));
	    return getText(opdPage.patientname);
	}

	public String verifySearchFailed() throws InterruptedException {
		Thread.sleep(2000);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(opdPage.searchFailed));
	    return getText(opdPage.searchFailed);
	}
}
