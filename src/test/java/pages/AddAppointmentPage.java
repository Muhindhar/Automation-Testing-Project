package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.HelperClass;

public class AddAppointmentPage {

	public AddAppointmentPage() {
		PageFactory.initElements(HelperClass.getDriver(), this);
	}

	

	@FindBy(xpath = "//a[normalize-space()='Receptionist']")
	public WebElement recpbtn;

	@FindBy(xpath = "//button[@type='submit']")
	public WebElement signinBtn;


	@FindBy(xpath = "//span[contains(text(),'Appointment')]")
	public WebElement appointmentMenu;

	/** Flexible By locator for Add Appointment (handles multiple UI states). */
	public static By addAppointmentBy() {
		return By.xpath(
			"//*[contains(text(),'Add Appointment')] | " +
			"//a[contains(@class,'addappointment')] | " +
			"//a[contains(@data-target,'addappointment')] | " +
			"//button[contains(text(),'Add Appointment')] | " +
			"//a[contains(@href,'appointment/create')]");
	}
	@FindBy(xpath = "//span[@aria-labelledby='select2-addpatient_id-container']")
	public WebElement patientNameDropdown;

	@FindBy(xpath = "//span[@aria-labelledby='select2-doctorid-container']")
	public WebElement doctorDropdown;

	@FindBy(xpath = "//span[@aria-labelledby='select2-global_shift-container']")
	public WebElement shiftDropdown;

	public static By priorityBy() {
		return By.xpath(
			"//span[contains(@aria-labelledby,'select2-priority')] | " +
			"//select[@name='appointment_priority']");
	}

	@FindBy(id = "datetimepicker")
	public WebElement appointmentDate;

	public static final By DATE_BY_NAME = By.cssSelector("input[name='date']");


	@FindBy(xpath = "//select[@name='slot']")
	public WebElement slotDropdown;

	@FindBy(xpath = "//select[@name='status']")
	public WebElement statusDropdown;

	@FindBy(xpath = "//select[@name='live_consult']")
	public WebElement liveConsultDropdown;

	// ==================== Buttons ====================

	@FindBy(xpath = "//button[normalize-space()='Save'] | //button[@id='save'] | //input[@id='save']")
	public WebElement saveBtn;

	// ==================== Messages ====================

	@FindBy(xpath = "//*[contains(text(),'Record Saved Successfully')]")
	public WebElement successMessage;

	@FindBy(xpath = "//*[contains(text(),'required')]")
	public WebElement validationMessage;

	@FindBy(xpath = "//*[contains(text(),'already exists')]")
	public WebElement duplicateMessage;

	// ==================== Select2 By locators (fresh each time) ====================

	public static By select2SearchInput() {
		return By.xpath("//span[contains(@class,'select2-container--open')]//input[contains(@class,'select2-search__field')]");
	}

	public static By select2FirstResult() {
		return By.xpath("//ul[contains(@class,'select2-results__options')]//li[not(contains(@class,'loading')) and not(contains(@class,'message'))]");
	}
}
