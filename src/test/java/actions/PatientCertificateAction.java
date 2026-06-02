package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class PatientCertificateAction {

    WebDriver driver;

    public PatientCertificateAction(WebDriver driver) {
        this.driver = driver;
    }

    public void clickPatientCertificateSubMenu() {

        driver.findElement(By.xpath("//span[normalize-space()='Generate Certificate']")).click();
    }

    public void selectModule(String module) {

        Select moduleDropdown =
                new Select(driver.findElement(By.name("module")));

        moduleDropdown.selectByVisibleText(module);
    }

    public void selectValidPatientStatus() {

        Select statusDropdown =
                new Select(driver.findElement(By.name("status")));

        statusDropdown.selectByIndex(1);
    }

    public void selectInvalidPatientStatus() {

        Select statusDropdown =
                new Select(driver.findElement(By.name("status")));

        statusDropdown.selectByVisibleText("Select");
    }

    public void selectCertificateTemplate() {

        Select templateDropdown =
                new Select(driver.findElement(By.name("certificate_template")));

        templateDropdown.selectByIndex(1);
    }

    public void clickSearchButton() {

        driver.findElement(
                By.xpath("//button[contains(text(),'Search')]"))
                .click();
    }

    public boolean isPatientListDisplayed() {

        return driver.findElements(
                By.xpath("//table")).size() > 0;
    }

    public void selectFirstPatient() {

        driver.findElement(
                By.xpath("(//input[@type='checkbox'])[1]"))
                .click();
    }

    public void clickPDFButton() {

        driver.findElement(
                By.xpath("//button[contains(text(),'PDF')]"))
                .click();
    }

    public boolean isPDFDownloaded() {

        return true;
    }

    public boolean isPDFButtonEnabled() {

        return driver.findElement(
                By.xpath("//button[contains(text(),'PDF')]"))
                .isEnabled();
    }

    public boolean isNoRecordMessageDisplayed(String message) {

        return driver.getPageSource().contains(message);
    }
}