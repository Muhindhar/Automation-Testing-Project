package actions;
import java.io.File;
import java.time.Duration;
import java.util.Map;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
        enableHeadlessDownloads(); // <-- unlock downloads in headless mode
    }

    private void enableHeadlessDownloads() {
        String downloadPath = System.getProperty("user.dir") + File.separator + "downloads";
        new File(downloadPath).mkdirs(); // create folder if it doesn't exist
        ((ChromeDriver) driver).executeCdpCommand(
            "Browser.setDownloadBehavior",
            Map.of(
                "behavior",     "allow",
                "downloadPath", downloadPath
            )
        );
        HelperClass.logger.info("Headless download path set to: " + downloadPath);
    }

    public void navigateToOPDOutPatientPage() {
        wait.until(ExpectedConditions.elementToBeClickable(opdPage.opdButton));
        HelperClass.logger.info("opening ODP page");
        jsClick(opdPage.opdButton);
        wait.until(ExpectedConditions.elementToBeClickable(opdPage.opdOutPatientNavLink));
        HelperClass.logger.info("clicking opdOutPatientNavLink ");
    }

    public void clickShowIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(opdPage.opdOutPatientNavLink));
        jsClick(opdPage.opdOutPatientNavLink);
    }

    public void clickVisitsTab() {
        wait.until(ExpectedConditions.elementToBeClickable(opdPage.visitsTab));
        WebElement tab = driver.findElement(opdPage.visitsTab);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tab);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", tab);
    }

    public void clickPrintIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(opdPage.printIcon));
        HelperClass.logger.info("Clicking print icon");
        click(opdPage.printIcon);
    }

    public boolean isReportDownloadedSuccessfully() {
        String downloadPath = System.getProperty("user.dir") + File.separator + "downloads";
        File folder = new File(downloadPath);

        long timeout = System.currentTimeMillis() + 15_000;

        while (System.currentTimeMillis() < timeout) {
            File[] files = folder.listFiles();

            if (files != null) {
                for (File file : files) {
                    String name = file.getName().toLowerCase();
                    if (name.endsWith(".pdf") && !name.contains(".crdownload")) {
                        HelperClass.logger.info("PDF found: " + file.getName());
                        return true;
                    }
                }
            }

            try { Thread.sleep(1000); }
            catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        }

        HelperClass.logger.warn("No PDF found in: " + downloadPath);
        return false;
    }
}