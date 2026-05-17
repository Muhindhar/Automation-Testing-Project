package actions;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
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

    // Navigate to OPD - Out Patient tab
    public void navigateToOPDOutPatientPage() {
        click(opdPage.opdButton);           // expand OPD menu
        click(opdPage.opdOutPatientTab);    // click OPD - Out Patient
    }

    // Verify a patient with completed visit exists (first row in table)
    public boolean isPatientWithVisitPresent() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(opdPage.showIconFirstPatient));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Click the Show icon for first patient
    public void clickShowIcon() {
        click(opdPage.showIconFirstPatient);
    }

    // Click the Visits tab inside patient detail
    public void clickVisitsTab() {
        wait.until(ExpectedConditions.elementToBeClickable(opdPage.visitsTab));
        click(opdPage.visitsTab);
    }

    // Click the Print icon on a visit record
    public void clickPrintIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(opdPage.printIcon));
        click(opdPage.printIcon);
    }

    // Verify print preview opened in a new window/tab
    public boolean isPrintPreviewOpen() {
        try {
            wait.until(d -> d.getWindowHandles().size() > 1);
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1)); // switch to print preview tab
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Verify the page title or URL indicates a printable report
    public boolean isSaveAsPdfPossible() {
        String currentUrl = driver.getCurrentUrl();
        String pageTitle  = driver.getTitle();
        return currentUrl.contains("print") || pageTitle.toLowerCase().contains("print")
               || pageTitle.toLowerCase().contains("report");
    }
}