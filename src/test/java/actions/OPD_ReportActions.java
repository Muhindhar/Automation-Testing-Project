package actions;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.OPDPage;

public class OPD_ReportActions extends BaseAction {

    OPDPage opdPage;
    WebDriverWait wait;

    public OPD_ReportActions(WebDriver driver) {
        super(driver);
        opdPage = new OPDPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // Expand OPD menu and click OPD - Out Patient tab
    public void navigateToOPDOutPatientPage() {
        jsClick(opdPage.opdButton);
        wait.until(ExpectedConditions.elementToBeClickable(opdPage.opdOutPatientNavLink));
        jsClick(opdPage.opdOutPatientNavLink);
    }

    // Click the Show/name link of first patient in table
    public void clickShowIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(opdPage.showIconFirstPatient));
        jsClick(opdPage.showIconFirstPatient);
    }

    // JS click to bypass overlapping pull-right div
    public void clickVisitsTab() {
        wait.until(ExpectedConditions.elementToBeClickable(opdPage.visitsTab));
        WebElement tab = driver.findElement(opdPage.visitsTab);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tab);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", tab);
    }

    // Click PDF/Print icon scoped to the visits table
    public void clickPrintIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(opdPage.printIcon));
        click(opdPage.printIcon);
    }

    // Verify download succeeded — new tab opened with report content
    public boolean isReportDownloadedSuccessfully() {
    	File folder = new File(System.getProperty("user.dir") + File.separator + "downloads");

		File[] files = folder.listFiles();

		if (files != null) {
			for (File file : files) {
				String filename = file.getName().toLowerCase();
				if (filename.endsWith(".pdf") || filename.endsWith(".csv") || filename.endsWith(".xlsx")) {
					return true;
				}
			}
		}

		return false;
    }
}