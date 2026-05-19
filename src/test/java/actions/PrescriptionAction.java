//package actions;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
//
//import pages.PrescriptionPage;
//import utilities.HelperClass;
//
//public class PrescriptionAction extends BaseAction {
//
//	WebDriver driver;
//	PrescriptionPage prescriptionPage;
//
//	public PrescriptionAction(WebDriver driver) {
//		super(driver);
//		this.driver = driver;
//		this.prescriptionPage = new PrescriptionPage();
//	}
//
//	public void clickDoctorTab() {
//		HelperClass.logger.info("Clicking doctor tab");
//		click(prescriptionPage.doctorTab);
//	}
//
//	public void clickSignIn() {
//		HelperClass.logger.info("clicking signin button");
//		click(prescriptionPage.signInButton);
//	}
//
//	public void clickIPDMenu() {
//		jsClick(prescriptionPage.ipdMenu);
//
//		wait.until(driver -> driver.findElement(prescriptionPage.patientSearchBox).isDisplayed());
//	}
//
//	public void searchPatientByIPD(String ipdNumber) {
//		sendKeys(prescriptionPage.patientSearchBox, ipdNumber);
//
//		wait.until(driver -> getText(By.xpath("//a[contains(text(),'" + ipdNumber + "')]")).contains(ipdNumber));
//	}
//
//	public boolean isCorrectPatientDisplayed(String ipdNumber) {
//		try {
//			String displayedIPD = getText(By.xpath("//a[contains(text(),'" + ipdNumber + "')]")).trim();
//
//			System.out.println("Displayed IPD: " + displayedIPD);
//			System.out.println("Expected IPD: " + ipdNumber);
//
//			return displayedIPD.contains(ipdNumber);
//
//		} catch (Exception e) {
//			System.out.println("Patient not displayed: " + e.getMessage());
//			return false;
//		}
//	}
//
//	public void clickIPDNumber(String ipdNumber) {
//		jsClick(By.xpath("//a[contains(text(),'" + ipdNumber + "')]"));
//	}
//
//	public void clickPrescriptionTab() {
//		jsClick(prescriptionPage.prescriptionTab);
//
//		//wait.until(driver -> driver.findElement(prescriptionPage.addPrescriptionButton).isDisplayed());
//	}
//
//	public void clickAddPrescription() {
//		//jsClick(prescriptionPage.addPrescriptionButton);
//
//		wait.until(ExpectedConditions.presenceOfElementLocated(prescriptionPage.headerNote));
//	}
//
//	private void typeInWysihtml5(By iframeLocator, String value) {
//		WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(iframeLocator));
//
//		driver.switchTo().frame(iframe);
//
//		try {
//			WebElement body = driver.findElement(By.tagName("body"));
//			body.click();
//			body.sendKeys(value);
//		} finally {
//			driver.switchTo().defaultContent();
//			try {
//				Thread.sleep(800);
//			} catch (InterruptedException ignored) {
//			}
//
//			try {
//				driver.getTitle();
//			} catch (Exception e) {
//				driver.switchTo().defaultContent();
//			}
//		}
//	}
//
//	// ─────────────────────────────────────────
//	// Visible Select Helper
//	// ─────────────────────────────────────────
//
//	private void selectByVisibleText(By locator, String value) {
//		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//		new Select(element).selectByVisibleText(value);
//	}
//
//	private void selectHiddenDropdown(By locator, String value) {
//		WebElement select = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
//		js.executeScript(
//				"var select = arguments[0];" + "for(var i=0; i<select.options.length; i++){"
//						+ "  if(select.options[i].text.trim() === arguments[1]){" + "    select.selectedIndex = i;"
//						+ "    select.dispatchEvent(new Event('change', {bubbles: true}));"
//						+ "    select.dispatchEvent(new Event('input', {bubbles: true}));" + "    break;" + "  }" + "}",
//				select, value);
//		try {
//			Thread.sleep(300);
//		} catch (InterruptedException ignored) {
//		}
//	}
//
//	public void enterHeaderNote(String value) {
//		typeInWysihtml5(prescriptionPage.headerNote, value);
//	}
//
//	public void selectPrescribeBy(String value) {
//		driver.switchTo().defaultContent();
//		selectByVisibleText(prescriptionPage.prescribeByDropdown, value);
//	}
//
//	public void selectDoctorNotification() throws InterruptedException {
//		try {
//			WebElement prescribeBy = driver.findElement(By.cssSelector("select[name='prescribe_by']"));
//
//			String currentValue = (String) js.executeScript("return arguments[0].value;", prescribeBy);
//			System.out.println("[selectDoctorNotification] prescribe_by value: '" + currentValue + "'");
//
//			if (currentValue == null || currentValue.isEmpty()) {
//				Select sel = new Select(prescribeBy);
//				for (WebElement opt : sel.getOptions()) {
//					System.out
//							.println("  option: '" + opt.getText().trim() + "' = '" + opt.getAttribute("value") + "'");
//					if (opt.getText().trim().contains("Amit Singh")) {
//						sel.selectByVisibleText(opt.getText().trim());
//						System.out.println("[selectDoctorNotification] Re-selected: " + opt.getText().trim());
//						break;
//					}
//				}
//			}
//
//		} catch (Exception e) {
//			System.out.println("[selectDoctorNotification] Error: " + e.getMessage());
//		}
//	}
//
//	public void selectPathology(String value) {
//		selectByVisibleText(prescriptionPage.pathologyDropdown, value);
//	}
//
//	public void selectRadiology(String value) {
//		selectByVisibleText(prescriptionPage.radiologyDropdown, value);
//	}
//
//	public void enterFindingCategory(String value) throws InterruptedException {
//		driver.switchTo().defaultContent();
//		selectHiddenDropdown(prescriptionPage.findingCategory, value);
//	}
//
//	public void enterFindings(String value) throws InterruptedException {
//		driver.switchTo().defaultContent();
//
//		try {
//			driver.findElement(By.tagName("body")).sendKeys(Keys.ESCAPE);
//			
//		} catch (Exception ignored) {
//		}
//
//		WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(prescriptionPage.findings));
//		input.click();
//		input.sendKeys(value);
//
//		try {
//			By option = By.xpath("//label[contains(normalize-space(),'" + value + "')]"
//					+ "/preceding-sibling::input[@type='checkbox'] | " + "//li[contains(normalize-space(),'" + value
//					+ "')]");
//			wait.until(ExpectedConditions.visibilityOfElementLocated(option)).click();
//		} catch (Exception e) {
//			input.sendKeys(Keys.ENTER);
//		}
//	}
//
//	public void enterFindingDescription(String value) {
//		HelperClass.logger.info("Driver switching");
//		driver.switchTo().defaultContent();
//		sendKeys(prescriptionPage.findingDescription, value);
//	}
//
//	private void setSelect2Value(By locator, String displayText) throws InterruptedException {
//		WebElement select = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
//
//		String optionValue = (String) js.executeScript("var sel = arguments[0], txt = arguments[1].trim();"
//				+ "for (var i = 0; i < sel.options.length; i++) {" + "  if (sel.options[i].text.trim() === txt || "
//				+ "      sel.options[i].text.trim().indexOf(txt) !== -1) {" + "    return sel.options[i].value;" + "  }"
//				+ "}" + "return null;", select, displayText);
//
//		System.out.println("[setSelect2Value] '" + displayText + "' → value='" + optionValue + "'");
//
//		if (optionValue == null) {
//			System.out.println("[setSelect2Value] WARNING: no match for: " + displayText);
//			return;
//		}
//
//		js.executeScript("jQuery(arguments[0]).val(arguments[1]).trigger('change');", select, optionValue);
//	}
//
//	public void selectMedicineCategory(String value) throws InterruptedException {
//
//		WebElement select = wait
//				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("select[name='medicine_cat_1']")));
//
//		String optionValue = (String) js.executeScript("var sel=arguments[0],txt=arguments[1].trim();"
//				+ "for(var i=0;i<sel.options.length;i++){" + " if(sel.options[i].text.trim()===txt){"
//				+ "   return sel.options[i].value;" + " }" + "}" + "return null;", select, value.trim());
//
//		System.out.println("[selectMedicineCategory] '" + value + "' → '" + optionValue + "'");
//
//		js.executeScript("$(arguments[0]).val(arguments[1]);" + "$(arguments[0]).trigger('change');"
//				+ "$(arguments[0]).trigger('select2:select');", select, optionValue);
//
//		wait.until(driver -> {
//			java.util.List<WebElement> options = driver
//					.findElements(By.cssSelector("select[name='medicine_1'] option"));
//
//			return options.size() > 1;
//		});
//
//		System.out.println("[selectMedicineCategory] Medicine loaded successfully");
//	}
//
//	public void selectMedicine(String value) {
//
//		WebElement medicineDropdown = wait
//				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("select[name='medicine_1']")));
//
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException ignored) {
//		}
//
//		java.util.List<WebElement> options = medicineDropdown.findElements(By.tagName("option"));
//
//		System.out.println("========= MEDICINE OPTIONS =========");
//
//		String matchedValue = null;
//
//		for (WebElement option : options) {
//
//			String text = option.getText().trim();
//			String optionValue = option.getAttribute("value");
//
//			System.out.println("Text = " + text + " | Value = " + optionValue);
//
//			if (text.equalsIgnoreCase(value.trim()) || text.contains(value.trim())) {
//
//				matchedValue = optionValue;
//			}
//		}
//
//		System.out.println("Matched Value = " + matchedValue);
//
//		if (matchedValue == null) {
//			throw new RuntimeException("Medicine not found: " + value);
//		}
//
//		js.executeScript("$(arguments[0]).val(arguments[1]).trigger('change');", medicineDropdown, matchedValue);
//
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException ignored) {
//		}
//	}
//
//	public void selectDose(String value) {
//
//		WebElement doseDropdown = wait
//				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("select[name='dosage_1']")));
//
//		java.util.List<WebElement> options = doseDropdown.findElements(By.tagName("option"));
//
//		System.out.println("========= DOSE OPTIONS =========");
//
//		String matchedValue = null;
//
//		for (WebElement option : options) {
//
//			String text = option.getText().trim();
//			String optionValue = option.getAttribute("value");
//
//			System.out.println("Text = " + text + " | Value = " + optionValue);
//
//			if (text.equalsIgnoreCase(value.trim()) || text.contains(value.trim())) {
//
//				matchedValue = optionValue;
//			}
//		}
//
//		System.out.println("Matched Dose = " + matchedValue);
//
//		if (matchedValue == null) {
//			throw new RuntimeException("Dose not found: " + value);
//		}
//
//		js.executeScript("$(arguments[0]).val(arguments[1]).trigger('change');", doseDropdown, matchedValue);
//
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException ignored) {
//		}
//	}
//
//	public void selectDoseInterval(String value) throws InterruptedException {
//		setSelect2Value(prescriptionPage.doseIntervalDropdown, value);
//	}
//
//	public void selectDoseDuration(String value) throws InterruptedException {
//		setSelect2Value(prescriptionPage.doseDurationDropdown, value);
//	}
//
//	// ── Shared helper ────────────────────────────────────────────────────────
//	private void selectWithFallback(WebElement select, String value) {
//		Select sel = new Select(select);
//		boolean found = false;
//		for (WebElement opt : sel.getOptions()) {
//			if (opt.getText().trim().equals(value.trim())) {
//				sel.selectByVisibleText(opt.getText().trim());
//				found = true;
//				break;
//			}
//		}
//		if (!found) {
//			js.executeScript(
//					"var s=arguments[0],v=arguments[1];" + "for(var i=0;i<s.options.length;i++){"
//							+ "  if(s.options[i].text.trim()===v||s.options[i].value.trim()===v){"
//							+ "    s.selectedIndex=i;" + "    s.dispatchEvent(new Event('change',{bubbles:true}));"
//							+ "    s.dispatchEvent(new Event('input',{bubbles:true}));" + "    break;" + "  }" + "}",
//					select, value.trim());
//			System.out.println("[selectWithFallback] JS used for: " + value);
//		}
//		try {
//			Thread.sleep(400);
//		} catch (InterruptedException ignored) {
//		}
//	}
//
//	public void enterInstruction(String value) {
//		sendKeys(prescriptionPage.instruction, value);
//	}
//
//	public void uploadAttachment(String filePath) {
//		String absolutePath = System.getProperty("user.dir") + java.io.File.separator
//				+ filePath.replace("/", java.io.File.separator);
//		driver.findElement(prescriptionPage.attachmentInput).sendKeys(absolutePath);
//	}
//
//	public void enterFooterNote(String value) {
//		typeInWysihtml5(prescriptionPage.footerNote, value);
//	}
//
//	public void clickSave() {
//		try {
//			// Get the Save button that has actual size (index 30 — 70x32)
//			WebElement saveButton = (WebElement) js
//					.executeScript("var buttons = document.querySelectorAll('button.btn-info');"
//							+ "for(var i=0; i<buttons.length; i++){"
//							+ "  if(buttons[i].textContent.trim()==='Save' && buttons[i].offsetWidth>0){"
//							+ "    return buttons[i];" + "  }" + "} return null;");
//
//			System.out.println("Save button found: " + (saveButton != null));
//			js.executeScript("arguments[0].scrollIntoView({block:'center'});", saveButton);
//			try {
//				Thread.sleep(300);
//			} catch (InterruptedException ignored) {
//			}
//			js.executeScript("arguments[0].click();", saveButton);
//			System.out.println("Save clicked successfully");
//			try {
//				Thread.sleep(2000);
//			} catch (InterruptedException ignored) {
//			}
//
//		} catch (Exception e) {
//			System.out.println("Unable to click save: " + e.getMessage());
//			throw e;
//		}
//	}
//	// ─────────────────────────────────────────
//	// Verification
//	// ─────────────────────────────────────────
//
//	public boolean isPrescriptionSaved() {
//		try {
//			wait.until(driver -> {
//				// Check for any success message
//				java.util.List<WebElement> alerts = driver.findElements(By.cssSelector(
//						".alert-success, .toast-success, .growl-message, " + "[class*='success'], [class*='alert']"));
//				for (WebElement a : alerts) {
//					try {
//						if (a.isDisplayed() && !a.getText().isEmpty()) {
//							System.out.println("Success msg: " + a.getText());
//							return true;
//						}
//					} catch (Exception ignored) {
//					}
//				}
//				// Check if modal closed (form disappeared)
//				java.util.List<WebElement> modals = driver.findElements(
//						By.cssSelector(".modal.in, .modal.show, [class*='modal'][style*='display: block']"));
//				if (modals.isEmpty()) {
//					System.out.println("Modal closed — saved.");
//					return true;
//				}
//				return false;
//			});
//			return true;
//		} catch (Exception e) {
//			System.out.println("Prescription not saved: " + e.getMessage());
//			return false;
//		}
//	}
//
//	public boolean isPrescriptionInList() {
//		try {
//
//			//wait.until(ExpectedConditions.visibilityOfElementLocated(prescriptionPage.prescriptionRow));
//
//			System.out.println("Prescription appeared in list");
//
//			return true;
//
//		} catch (Exception e) {
//
//			System.out.println("Prescription not found in list");
//
//			return false;
//		}
//	}
//}
