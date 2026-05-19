package actions;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.OPDPage;
import utilities.ExcelUtility;

public class OPD_AddPatientActions extends BaseAction {

    OPDPage opdPage;
    WebDriverWait wait;

    private static final String FILE_PATH  = "src/test/resources/testdata/OPDTestData.xlsx";
    private static final String SHEET_NAME = "Sheet1";

    public OPD_AddPatientActions(WebDriver driver) {
        super(driver);
        opdPage = new OPDPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void clickAddPatientButton() {
        wait.until(ExpectedConditions.elementToBeClickable(opdPage.addPatientButton));
        click(opdPage.addPatientButton);
    }

    public void clickAddIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(opdPage.addIcon));
        click(opdPage.addIcon);
    }

    public void fillPatientForm(Map<String, String> data) {
        String name   = data.get("Name");
        String gender = data.get("Gender");
        String year   = data.get("Year");
        String month  = data.get("Month");
        String day    = data.get("Day");

        wait.until(ExpectedConditions.visibilityOfElementLocated(opdPage.nameField));

        if (name != null && !name.isBlank()) {
            sendKeys(opdPage.nameField, name);
        }
        if (gender != null && !gender.isBlank()) {
            WebElement genderEl = driver.findElement(opdPage.genderDropdown);
            new Select(genderEl).selectByVisibleText(gender);
        }
        if (year  != null && !year.isBlank())  sendKeys(opdPage.yearField,  year);
        if (month != null && !month.isBlank()) sendKeys(opdPage.monthField, month);
        if (day   != null && !day.isBlank())   sendKeys(opdPage.dayField,   day);
    }

    // ✅ NEW METHOD — reads from Excel, builds Map, calls fillPatientForm()
    public void fillPatientFormFromExcel() throws Exception {
        Map<String, String> data = new HashMap<>();

        data.put("Name",   ExcelUtility.getCellData(FILE_PATH, SHEET_NAME, 1, 1)); // blank
        data.put("Gender", ExcelUtility.getCellData(FILE_PATH, SHEET_NAME, 2, 1));
        data.put("Year",   ExcelUtility.getCellData(FILE_PATH, SHEET_NAME, 3, 1));
        data.put("Month",  ExcelUtility.getCellData(FILE_PATH, SHEET_NAME, 4, 1));
        data.put("Day",    ExcelUtility.getCellData(FILE_PATH, SHEET_NAME, 5, 1));

        System.out.println("Excel Data Loaded: " + data);

        fillPatientForm(data); // reuses existing method
    }

    public void clickSave() {
        click(opdPage.saveButton);
    }

    public boolean isSuccessMessageDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(opdPage.successMessage));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isNameErrorDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(opdPage.nameErrorMessage));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}