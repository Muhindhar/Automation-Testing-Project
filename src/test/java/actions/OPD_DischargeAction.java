package actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.OPDPage;
import utilities.CSVReaderUtil;

import java.time.Duration;
import java.util.Map;

public class OPD_DischargeAction {

    WebDriver driver;
    OPDPage opdPage;
    WebDriverWait wait;

    public OPD_DischargeAction(WebDriver driver) {
        this.driver = driver;
        this.opdPage = new OPDPage(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickPatientIDLink() {
        wait.until(ExpectedConditions.elementToBeClickable(opdPage.revert)).click();
        wait.until(ExpectedConditions.elementToBeClickable(opdPage.opdOutPatientNavLink)).click();
        
    }

    public void clickDischargeIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(opdPage.dischargeIcon)).click();
    }

    public void fillDischargeForm() throws Exception {

        Map<String, String> data =
                CSVReaderUtil.getTestDataByTestCase("discharge_data", "DischargePatient");

        // Date
        WebElement dateInput = wait.until(ExpectedConditions
                .visibilityOfElementLocated(opdPage.dateField));
        dateInput.clear();
        dateInput.sendKeys(data.get("date"));

        // Reason 
        Select reasonSelect = new Select(
                driver.findElement(opdPage.reasonDropDown));
        reasonSelect.selectByVisibleText(data.get("reason"));

        // Text areas
        driver.findElement(opdPage.noteField).sendKeys(data.get("note"));
        driver.findElement(opdPage.operationField).sendKeys(data.get("operation"));
        driver.findElement(opdPage.diagnosisField).sendKeys(data.get("diagnosis"));
        driver.findElement(opdPage.investigationField).sendKeys(data.get("investigation"));
    }

    public void clickSaveDischargeButton() {
        wait.until(ExpectedConditions
                .elementToBeClickable(opdPage.saveDischargeButton))
                .click();
    }

    public boolean isSuccessMessageDisplayed() {
        try {
            return wait.until(ExpectedConditions
                    .visibilityOfElementLocated(opdPage.successMessage))
                    .isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}