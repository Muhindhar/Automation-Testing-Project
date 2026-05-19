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
import utilities.HelperClass;

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
    	wait.until(ExpectedConditions.elementToBeClickable(opdPage.opdButton));
    	HelperClass.logger.info("opening ODP page");
        jsClick(opdPage.opdButton);
        wait.until(ExpectedConditions.elementToBeClickable(opdPage.opdOutPatientNavLink));
        HelperClass.logger.info("clicking opdOutPatientNavLink ");
    }

    // Click the Show/name link of first patient in table
    public void clickShowIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(opdPage.opdOutPatientNavLink));
        jsClick(opdPage.opdOutPatientNavLink);
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
        HelperClass.logger.info("Clicking print icon");
        click(opdPage.printIcon);
    }

    // Verify download succeeded — new tab opened with report content
    public boolean isReportDownloadedSuccessfully() {
    	File folder = new File(System.getProperty("user.dir") + File.separator + "downloads");

		File[] files = folder.listFiles();

		if (files != null) {
			for (File file : files) {
				String filename = file.getName().toLowerCase();
				if (filename.endsWith(".pdf")) {
					return true;
				}
			}
		}

		return false;
    }
}