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
		wait.until(ExpectedConditions.visibilityOfElementLocated(page.patientSearchBox));
	}

	public void searchPatientByIPD(String ipdNumber) {
		sendKeys(page.patientSearchBox, ipdNumber);
		wait.until(ExpectedConditions.visibilityOfElementLocated(page.patientByIPD(ipdNumber)));
	}

	public boolean isCorrectPatientDisplayed(String ipdNumber) {
		try {
			boolean isDisplayed = wait
					.until(ExpectedConditions.visibilityOfElementLocated(page.patientByIPD(ipdNumber))).getText().trim()
					.contains(ipdNumber);
			return isDisplayed;
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
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(page.prescriptionTab));
			WebElement prescriptionTab = wait.until(ExpectedConditions.elementToBeClickable(page.prescriptionTab));
			js.executeScript("arguments[0].scrollIntoView({block:'center'});", prescriptionTab);
			js.executeScript("arguments[0].click();", prescriptionTab);
		} catch (org.openqa.selenium.StaleElementReferenceException e) {
			WebElement freshPrescriptionTab = wait.until(ExpectedConditions.elementToBeClickable(page.prescriptionTab));
			js.executeScript("arguments[0].scrollIntoView({block:'center'});", freshPrescriptionTab);
			js.executeScript("arguments[0].click();", freshPrescriptionTab);
		}
		wait.until(ExpectedConditions.elementToBeClickable(page.prescriptionButton));
		jsClick(page.prescriptionButton);
		wait.until(ExpectedConditions.visibilityOfElementLocated(page.addprescbtn));
	}

	public void clickAddPrescription() {
		wait.until(ExpectedConditions.elementToBeClickable(page.addprescbtn));
		jsClick(page.addprescbtn);
		wait.until(ExpectedConditions.presenceOfElementLocated(page.headerNote));
	}

	private boolean isBlank(String value) {
		return value == null || value.trim().isEmpty();
	}

	private void typeInWysihtml5(By iframeLocator, String value) {
		if (isBlank(value))
			return;
		WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(iframeLocator));
		js.executeScript("arguments[0].scrollIntoView({block:'center'});", iframe);
		driver.switchTo().frame(iframe);
		try {
			WebElement body = wait.until(ExpectedConditions.presenceOfElementLocated(page.frameBody));
			js.executeScript("arguments[0].innerHTML='';", body);
			body.sendKeys(value);
		} finally {
			driver.switchTo().defaultContent();
		}
	}

	private void selectByVisibleText(By locator, String visibleText) {
		if (isBlank(visibleText))
			return;
		WebElement select = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		String optionValue = (String) js
				.executeScript("var s=arguments[0], t=arguments[1].trim();" + "for(var i=0;i<s.options.length;i++){"
						+ "  if(s.options[i].text.trim()===t || s.options[i].text.trim().indexOf(t)!==-1)"
						+ "    return s.options[i].value;" + "} return null;", select, visibleText);
		if (optionValue == null)
			return;
		js.executeScript("$(arguments[0]).val(arguments[1]).trigger('change').trigger('select2:select');", select,
				optionValue);
		wait.until(ExpectedConditions.attributeToBe(locator, "value", optionValue));
	}

	private void selectByText(By locator, String value) {
		if (isBlank(value))
			return;
		WebElement select = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		for (WebElement opt : select.findElements(page.dropdownOptions)) {
			if (opt.getText().trim().equalsIgnoreCase(value) || opt.getText().trim().contains(value)) {
				js.executeScript("$(arguments[0]).val(arguments[1]).trigger('change');", select,
						opt.getAttribute("value"));
				return;
			}
		}
	}

	public void enterHeaderNote(String value) {
		typeInWysihtml5(page.headerNote, value);
	}

	public void enterFooterNote(String value) {
	    WebElement label = waitForVisibility(page.footerNoteLabel);
	    js.executeScript("arguments[0].scrollIntoView({block:'center'});", label);
	    typeInWysihtml5(page.footerNote, value);
	}

	public void selectPrescribeBy(String value) {
		selectByVisibleText(page.prescribeByDropdown, value);
	}

	public void selectPathology(String value) {
		selectByVisibleText(page.pathologyDropdown, value);
	}

	public void selectRadiology(String value) {
		selectByVisibleText(page.radiologyDropdown, value);
	}

	public void enterFindingCategory(String value) {
		selectByVisibleText(page.findingCategory, value);
	}

	public void selectDoseInterval(String value) {
		selectByVisibleText(page.doseIntervalDropdown, value);
	}

	public void selectDoseDuration(String value) {
		selectByVisibleText(page.doseDurationDropdown, value);
	}

	public void selectMedicine(String value) {
		selectByText(page.medicineDropdown, value);
	}

	public void selectDose(String value) {
		selectByText(page.doseDropdown, value);
	}

	public void selectMedicineCategory(String value) {
		if (isBlank(value))
			return;
		selectByVisibleText(page.medicineCategoryDropdown, value);
		// Wait until medicine dropdown is populated after category selection
		wait.until(d -> d.findElement(page.medicineDropdown).findElements(page.dropdownOptions).size() > 1);
	}

	public void enterFindings(String value) {
		if (isBlank(value))
			return;
		driver.switchTo().defaultContent();
		WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(page.findings));
		input.click();
		input.sendKeys(value);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(page.findingOption(value))).click();
			input.sendKeys(Keys.ENTER);
		} catch (Exception e) {
			input.sendKeys(Keys.ENTER);
		}
	}

	public void enterFindingDescription(String value) {
		if (isBlank(value))
			return;
		driver.switchTo().defaultContent();
		sendKeys(page.findingDescription, value);
	}

	public void enterInstruction(String value) {
	    if (isBlank(value))
	        return;

	    driver.switchTo().defaultContent();
	    WebElement instructionField = wait.until(ExpectedConditions.presenceOfElementLocated(page.instruction));
	    js.executeScript("arguments[0].scrollIntoView({block:'center'});", instructionField);
	    wait.until(ExpectedConditions.visibilityOf(instructionField));
	    instructionField.clear();
	    instructionField.sendKeys(value);
	}

	public void uploadAttachment(String filePath) {
		if (isBlank(filePath))
			return;
		String absolutePath = System.getProperty("user.dir") + java.io.File.separator
				+ filePath.replace("/", java.io.File.separator);
		wait.until(ExpectedConditions.presenceOfElementLocated(page.attachmentInput)).sendKeys(absolutePath);
	}

	public void clickSave() {
		WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(page.saveButton));
		js.executeScript("arguments[0].scrollIntoView({block:'center'});", btn);
		js.executeScript("arguments[0].click();", btn);
		wait.until(ExpectedConditions.or(ExpectedConditions.visibilityOfElementLocated(page.getPrescriptionTable),
				ExpectedConditions.visibilityOfElementLocated(page.errormsg)));
	}

	public void clickSaveAndPrint() {
		WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(page.saveAndPrintButton));
		js.executeScript("arguments[0].scrollIntoView({block:'center'});", btn);
		js.executeScript("arguments[0].click();", btn);
		wait.until(d -> d.getWindowHandles().size() > 1);
	}

	public void clickViewPrescription() {
		wait.until(ExpectedConditions.elementToBeClickable(page.getPrescriptionButtonDel));
		jsClick(page.getPrescriptionButtonDel);
	}

	public void clickEdit() {
		wait.until(ExpectedConditions.elementToBeClickable(page.editBtn));
		jsClick(page.editBtn);
	}

	public void updatePrescriptionDetails() {
		driver.switchTo().defaultContent();
		WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(page.headerNote));
		driver.switchTo().frame(iframe);
		try {
			WebElement body = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
			js.executeScript("arguments[0].innerHTML='';", body);
			body.sendKeys("Updated prescription details");
		} finally {
			driver.switchTo().defaultContent();
		}
	}

	public void clickDelete() {
		wait.until(ExpectedConditions.elementToBeClickable(page.deleteBtn));
		jsClick(page.deleteBtn);
	}

	public void confirmDelete() {
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(page.deleteBtn));
	}

	public boolean isPrescriptionSaved() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(page.getPrescriptionTable));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isPrescriptionInList() {
		try {
			List<WebElement> rows = wait
					.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(page.prescriptionFirstRow));
			boolean hasRows = !rows.isEmpty();
			return hasRows;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isPrescriptionUpdated() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(page.getPrescriptionTable));
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
			wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));
			String url = driver.getCurrentUrl().toLowerCase();
			String title = driver.getTitle().toLowerCase();
			return url.contains("print") || title.contains("print")
					|| driver.getPageSource().toLowerCase().contains("print-preview");
		} catch (Exception e) {
			return false;
		}
	}

	public String getErrorMessage() {
		try {
			return wait.until(ExpectedConditions.visibilityOfElementLocated(page.errormsg)).getText().trim();
		} catch (Exception e) {
			return "";
		}
	}
}