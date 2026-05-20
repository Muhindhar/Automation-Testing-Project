package actions;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

import pages.AddPatientPage;
import utilities.DriverFactory;

public class AddPatientAction extends DriverFactory {

    public void clickInPatient() {
        getDriver().findElement(AddPatientPage.inPatientMenu).click();
    }

    public void clickAddPatient() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        WebElement addPatientBtn = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        AddPatientPage.addPatientButton));

        ((JavascriptExecutor) getDriver()).executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                addPatientBtn);


        try {
            addPatientBtn.click();
        } catch (Exception e) {

            ((JavascriptExecutor) getDriver()).executeScript(
                    "arguments[0].click();",
                    addPatientBtn);
        }
    }

    public void clickNewPatient() {
        getDriver().findElement(AddPatientPage.newPatientButton).click();
    }

    public void clickSave() {
        getDriver().findElement(AddPatientPage.saveButton).click();
    }

    public void enterPatientName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            getDriver().findElement(AddPatientPage.patientName).clear();
            getDriver().findElement(AddPatientPage.patientName).sendKeys(name);
        }
    }

    public void enterGuardianName(String guardian) {
        if (guardian != null && !guardian.trim().isEmpty()) {
            getDriver().findElement(AddPatientPage.guardianName).clear();
            getDriver().findElement(AddPatientPage.guardianName).sendKeys(guardian);
        }
    }

    public void selectGender(String gender) {
        if (gender != null && !gender.trim().isEmpty()) {
            Select select = new Select(
                    getDriver().findElement(AddPatientPage.genderDropdown));
            select.selectByVisibleText(gender);
        }
    }

    public void enterDOB(String dob) {
        if (dob != null && !dob.trim().isEmpty()) {
            getDriver().findElement(AddPatientPage.dobField).clear();
            getDriver().findElement(AddPatientPage.dobField).sendKeys(dob);
        }
    }

    public void enterPhone(String phone) {
        if (phone != null && !phone.trim().isEmpty()) {
            getDriver().findElement(AddPatientPage.phoneField).clear();
            getDriver().findElement(AddPatientPage.phoneField).sendKeys(phone);
        }
    }

    public void enterEmail(String email) {
        if (email != null && !email.trim().isEmpty()) {
            getDriver().findElement(AddPatientPage.emailField).clear();
            getDriver().findElement(AddPatientPage.emailField).sendKeys(email);
        }
    }

    public void enterAddress(String address) {
        if (address != null && !address.trim().isEmpty()) {
            getDriver().findElement(AddPatientPage.addressField).clear();
            getDriver().findElement(AddPatientPage.addressField).sendKeys(address);
        }
    }

    public boolean successMessageDisplayed() {

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        return wait.until(ExpectedConditions.visibilityOfElementLocated(
                AddPatientPage.successMessage)).isDisplayed();
    }

    public boolean validationMessageDisplayed() {

        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));

            return wait.until(ExpectedConditions.visibilityOfElementLocated(
                    AddPatientPage.validationMessage)).isDisplayed();

        } catch (Exception e) {
            return false;
        }
    }
}