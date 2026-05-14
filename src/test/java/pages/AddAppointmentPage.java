// ==========================================
// AddAppointmentPage.java
// Package : pages
// ==========================================

package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.HelperClass;

public class AddAppointmentPage {

	public AddAppointmentPage() {

		PageFactory.initElements(
				HelperClass.getDriver(), this);
	}

	// Receptionist Button
	@FindBy(xpath =
	"//a[normalize-space()='Receptionist']")
	public WebElement recpbtn;

	// Sign In Button
	@FindBy(xpath =
	"//button[@type='submit']")
	public WebElement signinBtn;

	// Appointment Menu
	@FindBy(xpath =
	"//span[contains(text(),'Appointment')]")
	public WebElement appointmentMenu;

	// Add Appointment Button
	@FindBy(xpath =
	"//div[@id='tab_1']//a[@class='btn btn-primary btn-sm addappointment'][normalize-space()='Add Appointment']")
	public WebElement addAppointmentBtn;

	// =========================
	// Patient Name Dropdown
	// =========================

	@FindBy(xpath =
	"//span[@aria-labelledby='select2-patient_id-container']")
	public WebElement patientNameDropdown;

	@FindBy(xpath =
	"//input[@class='select2-search__field']")
	public WebElement patientSearchBox;

	@FindBy(xpath =
	"//li[contains(text(),'Maria Taylor (121)')]")
	public WebElement patientOption;

	// =========================
	// Doctor Dropdown
	// =========================

	@FindBy(xpath =
	"//span[@aria-labelledby='select2-doctor_select-container']")
	public WebElement doctorDropdown;

	@FindBy(xpath =
	"//input[@class='select2-search__field']")
	public WebElement doctorSearchBox;

	@FindBy(xpath =
	"//li[contains(text(),'Amit Singh (9009)')]")
	public WebElement doctorOption;

	// Shift Dropdown
	@FindBy(xpath =
	"//select[@name='global_shift']")
	public WebElement shiftDropdown;

	// Appointment Date
	@FindBy(id = "date")
	public WebElement appointmentDate;

	// Status Dropdown
	@FindBy(xpath =
	"//select[@name='status']")
	public WebElement statusDropdown;

	// Live Consultant Dropdown
	@FindBy(xpath =
	"//select[@name='live_consult']")
	public WebElement liveConsultDropdown;

	// Save Button
	@FindBy(xpath =
	"//button[contains(.,'Save')]")
	public WebElement saveBtn;

	// Success Message
	@FindBy(xpath =
	"//*[contains(text(),'Record Saved Successfully')]")
	public WebElement successMessage;

	// Validation Message
	@FindBy(xpath =
	"//*[contains(text(),'required')]")
	public WebElement validationMessage;

	// Duplicate Message
	@FindBy(xpath =
	"//*[contains(text(),'already exists')]")
	public WebElement duplicateMessage;
}