package actions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.OPDPage;

public class OPD_SearchActions extends BaseAction {
	
	WebDriver driver;
	OPDPage opdPage;
	WebDriverWait wait;
	
	public OPD_SearchActions(WebDriver driver) {
		super(driver);
		opdPage = new OPDPage(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public void searchPatient(String patientName) {
		opdPage.searchBox.sendKeys(patientName);
	}
	
	public void navigateToOPDPage() {
		opdPage.opdButton.click();
		opdPage.oldOpdTab.click();
	}
	
	public String verifySearchnameResult() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(opdPage.patientname));
		return opdPage.patientname.getText();
		
	}
	
	public String verifySearchFailed() {
		wait.until(ExpectedConditions.visibilityOf(opdPage.searchFailed));
		return opdPage.searchFailed.getText();
		
	}
}
