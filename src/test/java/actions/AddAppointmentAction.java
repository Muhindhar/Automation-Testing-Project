// ==========================================
// AddAppointmentAction.java
// Package : actions
// ==========================================

package actions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import pages.AddAppointmentPage;
import utilities.HelperClass;

public class AddAppointmentAction {

	AddAppointmentPage ap =
			new AddAppointmentPage();

	WebDriver driver =
			HelperClass.getDriver();

	public void clickReceptionistButton() {

		ap.recpbtn.click();
	}

	public void clickSigninButton() {

		ap.signinBtn.click();
	}

	public void navigateToAppointmentSection() {

		ap.appointmentMenu.click();
	}

	public void clickAddAppointment()
			throws InterruptedException {

		Thread.sleep(3000);

		try {

			ap.addAppointmentBtn.click();

		} catch (Exception e) {

			JavascriptExecutor js =
					(JavascriptExecutor) driver;

			js.executeScript(
					"arguments[0].click();",
					ap.addAppointmentBtn);
		}
	}

	public void enterAppointmentDetails(
			List<Map<String, String>> data)
			throws InterruptedException {

		// =========================
		// Select Patient Name
		// =========================

		ap.patientNameDropdown.click();

		Thread.sleep(2000);

		ap.patientSearchBox.sendKeys(
				"Maria");

		Thread.sleep(3000);

		ap.patientOption.click();

		Thread.sleep(2000);

		// =========================
		// Select Doctor
		// =========================

		ap.doctorDropdown.click();

		Thread.sleep(2000);

		ap.doctorSearchBox.sendKeys(
				data.get(0).get("Doctor"));

		Thread.sleep(3000);

		ap.doctorOption.click();

		Thread.sleep(2000);

		// =========================
		// Shift Dropdown
		// =========================

		Select shift =
				new Select(ap.shiftDropdown);

		shift.selectByVisibleText(
				data.get(0).get("Shift"));

		// =========================
		// Appointment Date
		// =========================

		ap.appointmentDate.clear();

		ap.appointmentDate.sendKeys(
				data.get(0).get("Appointment Date"));

		// =========================
		// Status Dropdown
		// =========================

		Select status =
				new Select(ap.statusDropdown);

		status.selectByVisibleText(
				data.get(0).get("Status"));

		// =========================
		// Live Consultant Dropdown
		// =========================

		Select liveConsult =
				new Select(ap.liveConsultDropdown);

		liveConsult.selectByVisibleText(
				data.get(0).get("Live Consultant"));
	}

	public void clickSaveButton() {

		try {

			ap.saveBtn.click();

		} catch (Exception e) {

			JavascriptExecutor js =
					(JavascriptExecutor) driver;

			js.executeScript(
					"arguments[0].click();",
					ap.saveBtn);
		}
	}

	public boolean verifySuccessMessage() {

		return ap.successMessage.isDisplayed();
	}

	public void leaveMandatoryFieldsEmpty() {

		clickSaveButton();
	}

	public boolean verifyValidationMessage() {

		return ap.validationMessage.isDisplayed();
	}

	public void enterDuplicateAppointmentDetails(
			List<Map<String, String>> data)
			throws InterruptedException {

		enterAppointmentDetails(data);
	}

	public boolean verifyDuplicateAppointmentMessage() {

		return ap.duplicateMessage.isDisplayed();
	}
}