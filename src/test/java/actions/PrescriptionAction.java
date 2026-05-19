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
        wait.until(d -> d.findElement(page.patientSearchBox).isDisplayed());
    }

    public void searchPatientByIPD(String ipdNumber) {
        sendKeys(page.patientSearchBox, ipdNumber);

        wait.until(d ->
                getText(By.xpath("//a[contains(text(),'" + ipdNumber + "')]"))
                        .contains(ipdNumber));
    }

    public boolean isCorrectPatientDisplayed(String ipdNumber) {
        try {
            String displayed = getText(By.xpath("//a[contains(text(),'" + ipdNumber + "')]")).trim();
            System.out.println("[isCorrectPatientDisplayed] displayed=" + displayed + " | expected=" + ipdNumber);
            return displayed.contains(ipdNumber);
        } catch (Exception e) {
            System.out.println("[isCorrectPatientDisplayed] not found: " + e.getMessage());
            return false;
        }
    }

    public void clickIPDNumber(String ipdNumber) {
        try {
            jsClick(page.click128Tab);
            System.out.println("[clickIPDNumber] Clicked via click128Tab locator.");
        } catch (Exception e) {
            jsClick(By.xpath("//tr[@class='odd']//a[contains(text(),'IPDN" + ipdNumber + "')]"));
            System.out.println("[clickIPDNumber] Clicked via fallback locator for: " + ipdNumber);
        }
    }

    public void clickPrescriptionTab() {
        jsClick(page.prescriptionTab);
        wait.until(ExpectedConditions.elementToBeClickable(page.prescriptionButton));
        jsClick(page.prescriptionButton);
        wait.until(ExpectedConditions.visibilityOfElementLocated(page.addprescbtn));
    }

    public void clickAddPrescription() {
        wait.until(ExpectedConditions.elementToBeClickable(page.addprescbtn));
        jsClick(page.addprescbtn);
        wait.until(ExpectedConditions.presenceOfElementLocated(page.headerNote));
        System.out.println("[clickAddPrescription] Prescription form loaded.");
    }

    private void typeInWysihtml5(By iframeLocator, String value) {
        if (value == null || value.trim().isEmpty()) return;

        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(iframeLocator));
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", iframe);
        sleep(300);

        driver.switchTo().frame(iframe);
        try {
            WebElement body = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
            js.executeScript("arguments[0].innerHTML='';", body);
            body.sendKeys(value);
        } finally {
            driver.switchTo().defaultContent();
            sleep(300);
        }
    }

    private void selectSelect2ByJS(By locator, String visibleText) {
        if (visibleText == null || visibleText.trim().isEmpty()) return;

        WebElement select = wait.until(ExpectedConditions.presenceOfElementLocated(locator));

        String optionValue = (String) js.executeScript(
                "var s = arguments[0], t = arguments[1].trim();" +
                        "for (var i = 0; i < s.options.length; i++) {" +
                        "  if (s.options[i].text.trim() === t || s.options[i].text.trim().indexOf(t) !== -1) {" +
                        "    return s.options[i].value;" +
                        "  }" +
                        "} return null;",
                select, visibleText);

        if (optionValue == null) {
            System.out.println("[selectSelect2ByJS] WARNING: no match for '" + visibleText + "'");
            return;
        }

        js.executeScript(
                "$(arguments[0]).val(arguments[1]).trigger('change').trigger('select2:select');",
                select, optionValue);
        sleep(500);
    }

    public void enterHeaderNote(String value) {
        typeInWysihtml5(page.headerNote, value);
    }

    public void enterFooterNote(String value) {
        typeInWysihtml5(page.footerNote, value);
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
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(page.findings));
        input.click();
        input.sendKeys(value);
        sleep(500);

        try {
            By option = By.xpath("//label[contains(normalize-space(),'" + value + "')]" +
                    "/preceding-sibling::input[@type='checkbox'] | " +
                    "//li[contains(normalize-space(),'" + value + "')]");
            wait.until(ExpectedConditions.elementToBeClickable(option)).click();
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

        wait.until(d -> {
            List<WebElement> opts = d.findElements(By.cssSelector("select[name='medicine_1'] option"));
            return opts.size() > 1;
        });
        sleep(1000);
    }

    public void selectMedicine(String value) {
        if (value == null || value.trim().isEmpty()) return;

        WebElement sel = wait.until(ExpectedConditions.presenceOfElementLocated(page.medicineDropdown));
        List<WebElement> options = sel.findElements(By.tagName("option"));

        String matchedValue = null;
        for (WebElement opt : options) {
            String text = opt.getText().trim();
            if (text.equalsIgnoreCase(value.trim()) || text.contains(value.trim())) {
                matchedValue = opt.getAttribute("value");
                break;
            }
        }

        if (matchedValue == null) {
            System.out.println("[selectMedicine] WARNING: Not found - " + value);
            return;
        }

        js.executeScript("$(arguments[0]).val(arguments[1]).trigger('change');", sel, matchedValue);
        sleep(1000);
    }

    public void selectDose(String value) {
        if (value == null || value.trim().isEmpty()) return;

        WebElement sel = wait.until(ExpectedConditions.presenceOfElementLocated(page.doseDropdown));
        List<WebElement> options = sel.findElements(By.tagName("option"));

        String matchedValue = null;
        for (WebElement opt : options) {
            String text = opt.getText().trim();
            if (text.equalsIgnoreCase(value.trim()) || text.contains(value.trim())) {
                matchedValue = opt.getAttribute("value");
                break;
            }
        }

        if (matchedValue == null) {
            System.out.println("[selectDose] WARNING: Not found - " + value);
            return;
        }

        js.executeScript("$(arguments[0]).val(arguments[1]).trigger('change');", sel, matchedValue);
        sleep(1000);
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

        String absolutePath = System.getProperty("user.dir")
                + java.io.File.separator
                + filePath.replace("/", java.io.File.separator);

        driver.findElement(page.attachmentInput).sendKeys(absolutePath);
    }

    public void clickSave() {
        wait.until(ExpectedConditions.elementToBeClickable(page.saveButton));
        WebElement saveBtn = driver.findElement(page.saveButton);
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", saveBtn);
        sleep(300);
        js.executeScript("arguments[0].click();", saveBtn);
        System.out.println("[clickSave] Clicked Save.");
        sleep(2000);
    }

    public void clickSaveAndPrint() {
        wait.until(ExpectedConditions.elementToBeClickable(page.saveAndPrintButton));
        WebElement savePrintBtn = driver.findElement(page.saveAndPrintButton);
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", savePrintBtn);
        sleep(300);
        js.executeScript("arguments[0].click();", savePrintBtn);
        System.out.println("[clickSaveAndPrint] Clicked Save & Print.");
        sleep(3000);
    }

    public boolean isPrescriptionSaved() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(page.getPrescriptionTable));
            System.out.println("[isPrescriptionSaved] Prescription list table visible — save confirmed.");
            return true;
        } catch (Exception e) {
            System.out.println("[isPrescriptionSaved] Prescription list table not found: " + e.getMessage());
            return false;
        }
    }

    public boolean isPrescriptionInList() {
        try {
            By firstRow = By.xpath("//table[@id='DataTables_Table_2']//tbody/tr[not(contains(@class,'dataTables_empty'))]");
            wait.until(ExpectedConditions.visibilityOfElementLocated(firstRow));

            List<WebElement> rows = driver.findElements(firstRow);
            System.out.println("[isPrescriptionInList] Row count: " + rows.size());

            if (!rows.isEmpty()) {
                String prescNo = rows.get(0).findElement(By.xpath("td[1]")).getText().trim();
                String date = rows.get(0).findElement(By.xpath("td[2]")).getText().trim();
                System.out.println("[isPrescriptionInList] Latest Prescription No: " + prescNo + " | Date: " + date);
            }
            return !rows.isEmpty();
        } catch (Exception e) {
            System.out.println("[isPrescriptionInList] No rows found: " + e.getMessage());
            return false;
        }
    }

    public boolean isPrintPreviewOpened() {
        try {
            String parentHandle = driver.getWindowHandle();
            
            wait.until(d -> d.getWindowHandles().size() > 1);

            for (String handle : driver.getWindowHandles()) {
                if (!handle.equals(parentHandle)) {
                    driver.switchTo().window(handle);
                    break;
                }
            }

            sleep(2000);

            String currentUrl = driver.getCurrentUrl().toLowerCase();
            String title = driver.getTitle().toLowerCase();

            System.out.println("[isPrintPreviewOpened] URL: " + currentUrl + " | Title: " + title);

            boolean isPrintPage = currentUrl.contains("print") ||
                    title.contains("print") ||
                    driver.getPageSource().toLowerCase().contains("print-preview");

            // Switch back to parent window (optional)
            // driver.switchTo().window(parentHandle);

            return isPrintPage;

        } catch (Exception e) {
            System.out.println("[isPrintPreviewOpened] Print preview not opened: " + e.getMessage());
            return false;
        }
    }

    public String getErrorMessage() {
        try {
            WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(page.errormsg));
            String msg = error.getText().trim();
            System.out.println("[getErrorMessage] Error: " + msg);
            return msg;
        } catch (Exception e) {
            System.out.println("[getErrorMessage] Error message not found.");
            return "";
        }
    }
    
    public void clickViewPrescription() {
        wait.until(ExpectedConditions.elementToBeClickable(page.getPrescriptionButtonDel));
        jsClick(page.getPrescriptionButtonDel);
        System.out.println("[clickViewPrescription] Clicked View Prescription.");
    }
    
    public void clickEdit() {
        wait.until(ExpectedConditions.elementToBeClickable(page.editBtn));
        jsClick(page.editBtn);
        System.out.println("[clickEdit] Clicked Edit.");
    }
    
    public void updatePrescriptionDetails() {
        try {
            driver.switchTo().defaultContent();

            WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(page.headerNote));
            driver.switchTo().frame(iframe);
            WebElement body = driver.findElement(By.tagName("body"));

            body.clear();
            body.sendKeys("Updated prescription details");

            driver.switchTo().defaultContent();
            System.out.println("[updatePrescriptionDetails] Updated Header Note.");

        } catch (Exception e) {
            System.out.println("[updatePrescriptionDetails] Failed: " + e.getMessage());
        }
    }
    
    public boolean isPrescriptionUpdated() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(page.getPrescriptionTable));
            System.out.println("[isPrescriptionUpdated] Prescription updated successfully.");
            return true;
        } catch (Exception e) {
            System.out.println("[isPrescriptionUpdated] Failed: " + e.getMessage());
            return false;
        }
    }
    
    public void clickDelete() {
        wait.until(ExpectedConditions.elementToBeClickable(page.deleteBtn));
        jsClick(page.deleteBtn);
        System.out.println("[clickDelete] Clicked Delete.");
    }
    
    public boolean isDeleteConfirmationPopupDisplayed() {

        try {

            wait.until(ExpectedConditions.alertIsPresent());
            String alertText =driver.switchTo().alert().getText();
            System.out.println("[Delete Popup] Alert text: "+ alertText);
            return alertText.contains("Are You Sure You Want To Delete This?");

        } catch (Exception e) {
            System.out.println("[Delete Popup] NOT displayed: "+ e.getMessage());
            return false;
        }
    }
    
    public void confirmDelete() {

        try {

            wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert().accept();
            System.out.println( "[confirmDelete] Alert accepted.");
            wait.until(ExpectedConditions.invisibilityOfElementLocated(page.deleteBtn));

        } catch (Exception e) {
            System.out.println("[confirmDelete] Failed: "+ e.getMessage());
        }
    }
    
    public boolean isPrescriptionDeletedSuccessfully() {

        try {

            wait.until(ExpectedConditions.invisibilityOfElementLocated(page.deleteBtn));
            System.out.println("[Delete Success] Prescription deleted successfully.");
            return true;
        } catch (Exception e) {

            System.out.println("[Delete Success] Validation failed: " + e.getMessage());
            return false;
        }
    }
}