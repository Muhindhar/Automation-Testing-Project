package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pages.PrescriptionPage;

import java.util.List;

public class PrescriptionAction extends BaseAction {

    private final WebDriver driver;
    private final PrescriptionPage page;

    public PrescriptionAction(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.page = new PrescriptionPage();
    }

    public void clickIPDMenu() {
        jsClick(page.ipdMenu);
        waitForVisibility(page.patientSearchBox);
    }

    public void searchPatientByIPD(String ipdNumber) {
        sendKeys(page.patientSearchBox, ipdNumber);
        waitForVisibility(page.patientByIPD(ipdNumber));
    }

    public boolean isCorrectPatientDisplayed(String ipdNumber) {
        try {
            return waitForVisibility(page.patientByIPD(ipdNumber))
                    .getText().trim().contains(ipdNumber);
        } catch (Exception e) {
            return false;
        }
    }

    public void clickIPDNumber(String ipdNumber) {
        try {
            jsClick(page.click128Tab);
        } catch (Exception e) {
            jsClick(page.ipdNumber(ipdNumber));
        }
    }

    public void clickPrescriptionTab() {
        jsClick(page.prescriptionTab);
        waitForClickable(page.prescriptionButton);
        jsClick(page.prescriptionButton);
        waitForVisibility(page.addprescbtn);
    }

    public void clickAddPrescription() {
        waitForClickable(page.addprescbtn);
        jsClick(page.addprescbtn);
        wait.until(ExpectedConditions.presenceOfElementLocated(page.headerNote));
    }

    private void typeInWysihtml5(By iframeLocator, String value) {
        if (value == null || value.trim().isEmpty()) return;

        driver.switchTo().defaultContent();

        try {
            WebElement iframe = wait.until(
                ExpectedConditions.presenceOfElementLocated(iframeLocator));

            js.executeScript("arguments[0].scrollIntoView({block:'center'});", iframe);
            wait.until(ExpectedConditions.visibilityOfElementLocated(iframeLocator));

            driver.switchTo().frame(iframe);

            WebElement body = wait.until(
                ExpectedConditions.presenceOfElementLocated(page.frameBody));

            js.executeScript("arguments[0].focus();", body);
            js.executeScript("arguments[0].click();", body);

            wait.until(ExpectedConditions.visibilityOf(body));

            js.executeScript("arguments[0].innerHTML='';", body);
            body.sendKeys(value);

        } catch (org.openqa.selenium.StaleElementReferenceException e) {
            driver.switchTo().defaultContent();

            WebElement iframe = wait.until(
                ExpectedConditions.visibilityOfElementLocated(iframeLocator));

            driver.switchTo().frame(iframe);

            WebElement body = wait.until(
                ExpectedConditions.presenceOfElementLocated(page.frameBody));

            js.executeScript("arguments[0].focus();", body);
            js.executeScript("arguments[0].click();", body);
            js.executeScript("arguments[0].innerHTML='';", body);
            body.sendKeys(value);

        } finally {
            driver.switchTo().defaultContent();
        }
    }


    public void enterHeaderNote(String value) {
        if (value == null || value.trim().isEmpty()) return;

        driver.switchTo().defaultContent();
        WebElement label = wait.until(
            ExpectedConditions.presenceOfElementLocated(page.headerNoteLabel));
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", label);

        wait.until(ExpectedConditions.visibilityOfElementLocated(page.headerNoteLabel));
        js.executeScript("arguments[0].click();", label);

        wait.until(ExpectedConditions.presenceOfElementLocated(page.headerNote));
        wait.until(ExpectedConditions.visibilityOfElementLocated(page.headerNote));

        typeInWysihtml5(page.headerNote, value);
    }

    public void enterFooterNote(String value) {
        if (value == null || value.trim().isEmpty()) return;

        driver.switchTo().defaultContent();
        WebElement label = wait.until(
            ExpectedConditions.presenceOfElementLocated(page.footerNoteLabel));
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", label);
        wait.until(ExpectedConditions.visibilityOfElementLocated(page.footerNoteLabel));
        js.executeScript("arguments[0].click();", label);
        wait.until(ExpectedConditions.presenceOfElementLocated(page.footerNote));
        wait.until(ExpectedConditions.visibilityOfElementLocated(page.footerNote));

        typeInWysihtml5(page.footerNote, value);
    }

    private void selectSelect2ByJS(By locator, String visibleText) {
        if (visibleText == null || visibleText.trim().isEmpty()) return;

        WebElement select = wait.until(
            ExpectedConditions.presenceOfElementLocated(locator));

        String optionValue = (String) js.executeScript(
            "var s=arguments[0], t=arguments[1].trim();" +
            "for(var i=0;i<s.options.length;i++){" +
            "  if(s.options[i].text.trim()===t||s.options[i].text.trim().indexOf(t)!==-1)" +
            "    return s.options[i].value;" +
            "} return null;",
            select, visibleText);

        if (optionValue == null) return;

        js.executeScript(
            "$(arguments[0]).val(arguments[1]).trigger('change').trigger('select2:select');",
            select, optionValue);

        wait.until(ExpectedConditions.attributeToBe(locator, "value", optionValue));
    }

    public void selectPrescribeBy(String value) {
        selectSelect2ByJS(page.prescribeByDropdown, value);
    }

    public void selectPathology(String value) {
        selectSelect2ByJS(page.pathologyDropdown, value);
    }

    public void selectRadiology(String value) {
        selectSelect2ByJS(page.radiologyDropdown, value);
    }

    public void enterFindingCategory(String value) {
        selectSelect2ByJS(page.findingCategory, value);
    }

    public void enterFindings(String value) {
        if (value == null || value.trim().isEmpty()) return;

        driver.switchTo().defaultContent();
        WebElement input = waitForVisibility(page.findings);
        input.click();
        input.sendKeys(value);

        try {
            waitForClickable(page.findingOption(value)).click();
        } catch (Exception e) {
            input.sendKeys(Keys.ENTER);
        }
    }

    public void enterFindingDescription(String value) {
        if (value == null || value.trim().isEmpty()) return;
        sendKeys(page.findingDescription, value);
    }

    public void selectMedicineCategory(String value) {
        if (value == null || value.trim().isEmpty()) return;

        selectSelect2ByJS(page.medicineCategoryDropdown, value);
        wait.until(d -> d.findElements(page.medicineOptions).size() > 1);
    }

    public void selectMedicine(String value) {
        if (value == null || value.trim().isEmpty()) return;

        WebElement sel = wait.until(
            ExpectedConditions.presenceOfElementLocated(page.medicineDropdown));

        String matchedValue = null;
        for (WebElement opt : sel.findElements(page.dropdownOptions)) {
            String text = opt.getText().trim();
            if (text.equalsIgnoreCase(value.trim()) || text.contains(value.trim())) {
                matchedValue = opt.getAttribute("value");
                break;
            }
        }

        if (matchedValue == null) return;

        js.executeScript(
            "$(arguments[0]).val(arguments[1]).trigger('change');", sel, matchedValue);

        wait.until(ExpectedConditions.attributeToBe(page.medicineDropdown, "value", matchedValue));
    }

    public void selectDose(String value) {
        if (value == null || value.trim().isEmpty()) return;

        WebElement sel = wait.until(
            ExpectedConditions.presenceOfElementLocated(page.doseDropdown));

        String matchedValue = null;
        for (WebElement opt : sel.findElements(page.dropdownOptions)) {
            String text = opt.getText().trim();
            if (text.equalsIgnoreCase(value.trim()) || text.contains(value.trim())) {
                matchedValue = opt.getAttribute("value");
                break;
            }
        }

        if (matchedValue == null) return;

        js.executeScript(
            "$(arguments[0]).val(arguments[1]).trigger('change');", sel, matchedValue);

        wait.until(ExpectedConditions.attributeToBe(page.doseDropdown, "value", matchedValue));
    }

    public void selectDoseInterval(String value) {
        selectSelect2ByJS(page.doseIntervalDropdown, value);
    }

    public void selectDoseDuration(String value) {
        selectSelect2ByJS(page.doseDurationDropdown, value);
    }

    public void enterInstruction(String value) {
        if (value == null || value.trim().isEmpty()) return;
        sendKeys(page.instruction, value);
    }

    public void uploadAttachment(String filePath) {
        if (filePath == null || filePath.trim().isEmpty()) return;

        driver.switchTo().defaultContent();

        String absolutePath = System.getProperty("user.dir")
                + java.io.File.separator
                + filePath.replace("/", java.io.File.separator);

        WebElement input = wait.until(
            ExpectedConditions.refreshed(
                ExpectedConditions.presenceOfElementLocated(page.attachmentInput)));

        input.sendKeys(absolutePath);
    }

    public void clickSave() {
        driver.switchTo().defaultContent();

        try {
            WebElement btn = wait.until(
                ExpectedConditions.refreshed(
                    ExpectedConditions.elementToBeClickable(page.saveButton)));
            js.executeScript("arguments[0].scrollIntoView({block:'center'});", btn);
            js.executeScript("arguments[0].click();", btn);

        } catch (org.openqa.selenium.StaleElementReferenceException e) {
            WebElement btn = waitForClickable(page.saveButton);
            js.executeScript("arguments[0].scrollIntoView({block:'center'});", btn);
            js.executeScript("arguments[0].click();", btn);
        }

        wait.until(ExpectedConditions.or(
        	    ExpectedConditions.visibilityOfElementLocated(page.getPrescriptionTable),
        	    ExpectedConditions.visibilityOfElementLocated(page.errormsg)
        	));
        	wait.until(driver ->
        	        !driver.findElements(page.prescriptionFirstRow).isEmpty()
        	        || !driver.findElements(page.errormsg).isEmpty()
        	);
    }

    public void clickSaveAndPrint() {
        driver.switchTo().defaultContent();

        WebElement btn = wait.until(
            ExpectedConditions.refreshed(
                ExpectedConditions.elementToBeClickable(page.saveAndPrintButton)));
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", btn);
        js.executeScript("arguments[0].click();", btn);

        wait.until(d -> d.getWindowHandles().size() > 1);
    }

    public boolean isPrescriptionSaved() {
        try {
            waitForVisibility(page.getPrescriptionTable);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isPrescriptionInList() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    page.getPrescriptionTable));
            boolean rowLoaded = wait.until(driver ->
                    !driver.findElements(page.prescriptionFirstRow).isEmpty());

            return rowLoaded;

        } catch (Exception e) {
            return false;
        }
    }

    public boolean isPrescriptionUpdated() {
        try {
            waitForVisibility(page.getPrescriptionTable);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isDeleteConfirmationPopupDisplayed() {
        try {
            String alertText = wait.until(ExpectedConditions.alertIsPresent()).getText();
            return alertText.contains("Are You Sure You Want To Delete This?");
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isPrescriptionDeletedSuccessfully() {
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(page.deleteBtn));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isPrintPreviewOpened() {
        try {
            String parent = driver.getWindowHandle();
            wait.until(d -> d.getWindowHandles().size() > 1);

            for (String handle : driver.getWindowHandles()) {
                if (!handle.equals(parent)) {
                    driver.switchTo().window(handle);
                    break;
                }
            }

            wait.until(ExpectedConditions.jsReturnsValue(
                "return document.readyState === 'complete';"));

            String url   = driver.getCurrentUrl().toLowerCase();
            String title = driver.getTitle().toLowerCase();

            return url.contains("print") || title.contains("print")
                || driver.getPageSource().toLowerCase().contains("print-preview");

        } catch (Exception e) {
            return false;
        }
    }

    public String getErrorMessage() {
        try {
            return waitForVisibility(page.errormsg).getText().trim();
        } catch (Exception e) {
            return "";
        }
    }

    public void clickViewPrescription() {
        waitForClickable(page.viewPrescription);
        jsClick(page.viewPrescription);
    }

    public void clickEdit() {
        waitForClickable(page.editBtn);
        jsClick(page.editBtn);
    }

    public void clickDelete() {
        waitForClickable(page.deleteBtn);
        jsClick(page.deleteBtn);
    }

    public void confirmDelete() {
        wait.until(ExpectedConditions.alertIsPresent()).accept();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(page.deleteBtn));
    }

    public void updatePrescriptionDetails() {
        driver.switchTo().defaultContent();

        WebElement iframe = wait.until(
            ExpectedConditions.visibilityOfElementLocated(page.headerNote));
        driver.switchTo().frame(iframe);

        try {
            WebElement body = wait.until(
                ExpectedConditions.presenceOfElementLocated(page.frameBody));
            js.executeScript("arguments[0].innerHTML='';", body);
            body.sendKeys("Updated prescription details");
        } finally {
            driver.switchTo().defaultContent();
        }
    }
}