package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PatientCertificatePage {

    WebDriver driver;

    public PatientCertificatePage(WebDriver driver) {
        this.driver = driver;
    }

    // ───────── MENU ─────────

    public By certificateMenu =
            By.xpath("//span[contains(text(),'Certificate')]");

    public By certificateSubMenu =
            By.xpath("//a[@href='https://demo.smart-hospital.in/admin/generatecertificate']");

    // ───────── DROPDOWNS ─────────

    public By moduleDropdown =
            By.id("module");

    public By patientStatusDropdown =
            By.id("patient_status");

    public By certificateTemplateDropdown =
            By.id("certificate_template");

    // ───────── BUTTONS ─────────

    public By searchButton =
            By.xpath("//button[contains(text(),'Search')]");

    public By pdfButton =
            By.xpath("//button[contains(text(),'PDF')]");

    // ───────── TABLE ─────────

    public By patientRows =
            By.xpath("//table/tbody/tr");

    // ───────── MENU ACTIONS ─────────

    public void clickCertificateMenu() {

        WebElement menu =
                driver.findElement(certificateMenu);

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript("arguments[0].click();", menu);
    }
    public void clickCertificateSubMenu() {

        try {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

            WebElement submenu = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath("//a[contains(@href,'generatecertificate')]")
                    )
            );

            JavascriptExecutor js = (JavascriptExecutor) driver;

            js.executeScript("arguments[0].scrollIntoView(true);", submenu);

            js.executeScript("arguments[0].click();", submenu);

            System.out.println("Certificate submenu clicked successfully");

        } catch (Exception e) {

            System.out.println("Unable to click Certificate submenu");
            e.printStackTrace();
        }
    }

    public void selectModuleIPD() {

        Select select =
                new Select(driver.findElement(moduleDropdown));

        select.selectByVisibleText("IPD");
    }

    public void selectValidPatientStatus() {

        Select select =
                new Select(driver.findElement(patientStatusDropdown));

        select.selectByIndex(1);
    }

    public void selectInvalidPatientStatus() {

        Select select =
                new Select(driver.findElement(patientStatusDropdown));

        select.selectByVisibleText("Select");
    }

    public void selectValidTemplate() {

        Select select =
                new Select(driver.findElement(certificateTemplateDropdown));

        select.selectByIndex(1);
    }

    // ───────── BUTTON ACTIONS ─────────

    public void clickSearchButton() {

        driver.findElement(searchButton).click();
    }

    public void clickPDFButton() {

        driver.findElement(pdfButton).click();
    }

    // ───────── TABLE ACTIONS ─────────

    public void selectFirstPatient() {

        List<WebElement> patients =
                driver.findElements(patientRows);

        if (!patients.isEmpty()) {

            patients.get(0).click();
        }
    }

    // ───────── VALIDATION ─────────

    public boolean isPDFButtonEnabled() {

        return driver.findElement(pdfButton).isEnabled();
    }
}