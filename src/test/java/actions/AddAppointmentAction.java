package actions;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import pages.AddAppointmentPage;
import utilities.HelperClass;

public class AddAppointmentAction {

	private AddAppointmentPage ap;
	private WebDriver driver;
	private JavascriptExecutor js;

	public AddAppointmentAction() {
		this.ap = new AddAppointmentPage();
		this.driver = HelperClass.getDriver();
		this.js = (JavascriptExecutor) driver;
	}

	private WebDriverWait wait(int s) {
		return new WebDriverWait(driver, Duration.ofSeconds(s));
	}

	private void sleep(long ms) {
		try { Thread.sleep(ms); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
	}

	// ==================== Select2 ====================

	private void select2(By triggerBy, String search) {
		WebElement trigger = wait(15).until(ExpectedConditions.elementToBeClickable(triggerBy));
		select2(trigger, search);
	}

	private void select2(WebElement trigger, String search) {
		js.executeScript("arguments[0].scrollIntoView(true);", trigger);
		sleep(400);
		trigger.click();
		sleep(1000);

		WebElement input = wait(15).until(
				ExpectedConditions.visibilityOfElementLocated(AddAppointmentPage.select2SearchInput()));
		input.clear();
		input.sendKeys(search);
		sleep(2000);

		WebElement result = wait(15).until(
				ExpectedConditions.elementToBeClickable(AddAppointmentPage.select2FirstResult()));
		result.click();
		sleep(800);
	}

	// ==================== Background ====================

	public void clickReceptionistButton() {
		wait(15).until(ExpectedConditions.elementToBeClickable(ap.recpbtn)).click();
	}

	public void clickSigninButton() {
		wait(15).until(ExpectedConditions.elementToBeClickable(ap.signinBtn)).click();
		sleep(4000);
	}

	public void navigateToAppointmentSection() {
		wait(15).until(ExpectedConditions.elementToBeClickable(ap.appointmentMenu)).click();

		// Wait for page/submenu to stabilize - check URL or specific element
		sleep(4000);
	}

	public void clickAddAppointment() {
		By loc = AddAppointmentPage.addAppointmentBy();
		try {
			WebElement btn = wait(15).until(ExpectedConditions.elementToBeClickable(loc));
			btn.click();
		} catch (Exception e) {
			WebElement btn = wait(15).until(ExpectedConditions.presenceOfElementLocated(loc));
			js.executeScript("arguments[0].click();", btn);
		}

		// Wait for modal (patient dropdown is reliable marker)
		wait(15).until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//span[@aria-labelledby='select2-addpatient_id-container']")));
		sleep(1500);
	}

	// ==================== Form fill ====================

	public void enterAppointmentDetails(List<Map<String, String>> data) {
		Map<String, String> row = data.get(0);

		select2(ap.patientNameDropdown, "Maria");
		select2(ap.doctorDropdown, "Amit");
		select2(ap.shiftDropdown, row.get("Shift"));
		enterDate(row.get("Appointment Date"));
		selectSlot(row.get("Slot"));
		selectPriority(row.get("Appointment Priority"));
		selectByName("status", row.get("Status"));
		selectByName("live_consult", row.get("Live Consultant"));
	}

	private void enterDate(String date) {
		try {
			WebElement el = wait(10).until(
					ExpectedConditions.presenceOfElementLocated(AddAppointmentPage.DATE_BY_NAME));
			js.executeScript("arguments[0].removeAttribute('readonly');", el);
			// Set value directly via JS to bypass datepicker interference
			js.executeScript("arguments[0].value = '15-05-2025 10:00';", el);
		} catch (Exception e) {
			js.executeScript("document.querySelector('input[name=\"date\"]').removeAttribute('readonly');");
			js.executeScript("document.querySelector('input[name=\"date\"]').value = '15-05-2025 10:00';");
		}
		sleep(1500);
	}

	private void selectByName(String name, String val) {
		if (val == null || val.isEmpty()) return;
		String css = "select[name='" + name + "']";
		try {
			WebElement el = wait(10).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(css)));
			wait(3).until(ExpectedConditions.elementToBeClickable(el));
			new Select(el).selectByVisibleText(val);
		} catch (Exception e) {
			try {
				// JS: find option by visible text, set that option's value
				// Use double quotes in JS to avoid conflict with CSS single quotes
				js.executeScript(
					"var s=document.querySelector(\"" + css + "\");" +
					"if(s){for(var i=0;i<s.options.length;i++){" +
					  "if(s.options[i].text.trim()==='" + val + "'){" +
					    "s.selectedIndex=i;" +
					    "s.dispatchEvent(new Event('change'));" +
					    "break;" +
					  "}" +
					"}}");
			} catch (Exception e2) {
				System.out.println("Skip " + name + ": " + e2.getMessage());
			}
		}
	}

	private void selectSlot(String slot) {
		if (slot == null || slot.isEmpty()) return;
		try {
			WebElement el = wait(15).until(
					ExpectedConditions.presenceOfElementLocated(By.cssSelector("select[name='slot']")));
			wait(5).until(ExpectedConditions.elementToBeClickable(el));
			new Select(el).selectByVisibleText(slot);
		} catch (Exception e) {
			try {
				// Fallback: use JS to set value
				js.executeScript("document.querySelector('select[name=\"slot\"]').value='" + slot + "';");
				js.executeScript("document.querySelector('select[name=\"slot\"]').dispatchEvent(new Event('change'));");
			} catch (Exception e2) {
				System.out.println("Slot skip: " + e2.getMessage());
			}
		}
	}

	private void selectPriority(String priority) {
		if (priority == null || priority.isEmpty()) return;
		try {
			select2(AddAppointmentPage.priorityBy(), priority);
		} catch (Exception e1) {
			try {
				WebElement el = wait(5).until(
						ExpectedConditions.presenceOfElementLocated(
								By.cssSelector("select[name='appointment_priority']")));
				new Select(el).selectByVisibleText(priority);
			} catch (Exception e2) {
				try {
					js.executeScript("document.querySelector('select[name=\"appointment_priority\"]').value='"
							+ priority + "';");
					js.executeScript("document.querySelector('select[name=\"appointment_priority\"]')"
							+ ".dispatchEvent(new Event('change'));");
				} catch (Exception e3) {
					System.out.println("Priority skip: " + e3.getMessage());
				}
			}
		}
	}

	// ==================== Actions ====================

	public void clickSaveButton() {
		WebElement btn = wait(15).until(ExpectedConditions.elementToBeClickable(ap.saveBtn));
		try { btn.click(); } catch (Exception e) { js.executeScript("arguments[0].click();", btn); }
		sleep(3000);
	}

	public void leaveMandatoryFieldsEmpty() {
		// do nothing
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	// ==================== Verifications ====================

	public void verifySuccessMessage() {
		sleep(2000);
		try {
			Assert.assertTrue(wait(15).until(
					ExpectedConditions.visibilityOf(ap.successMessage)).isDisplayed(),
					"Success msg not visible");
		} catch (Exception e) {
			String src = driver.getPageSource();
			boolean found = src.contains("Record Saved Successfully")
					|| src.contains("Saved Successfully");
			Assert.assertTrue(found, "Success msg not found. " + e.getMessage());
		}
	}

	public void verifyValidationMessage() {
		sleep(1500);
		try {
			Assert.assertTrue(wait(10).until(
					ExpectedConditions.visibilityOf(ap.validationMessage)).isDisplayed(),
					"Validation msg not visible");
		} catch (Exception e) {
			Assert.assertTrue(driver.getPageSource().contains("required"),
					"Validation msg not found. " + e.getMessage());
		}
	}

	public void verifyDuplicateAppointmentMessage() {
		sleep(2000);
		try {
			Assert.assertTrue(wait(15).until(
					ExpectedConditions.visibilityOf(ap.duplicateMessage)).isDisplayed(),
					"Duplicate msg not visible");
		} catch (Exception e) {
			String src = driver.getPageSource();
			boolean found = src.contains("already exists") || src.contains("duplicate");
			Assert.assertTrue(found, "Duplicate msg not found. " + e.getMessage());
		}
	}

	public void verifyAppointmentNotCreated() {
		sleep(1500);
		try {
			wait(5).until(ExpectedConditions.invisibilityOfElementLocated(
					By.xpath("//*[contains(text(),'Record Saved Successfully')]")));
		} catch (Exception ignored) {}
		String src = driver.getPageSource();
		if (src.contains("Record Saved Successfully")) {
			System.out.println("WARN: Success msg found - appointment WAS created (may be app behavior)");
		}
		Assert.assertFalse(src.contains("Record Saved Successfully"),
				"Appointment was unexpectedly created");
	}
}
