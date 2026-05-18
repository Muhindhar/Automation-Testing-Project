package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

import utilities.DriverFactory;

public class AppointmentFilterPage {
	public AppointmentFilterPage() {
		PageFactory.initElements(DriverFactory.getDriver(), this);
	}

	@FindBy(xpath = "//a[normalize-space()='Receptionist']")
	public WebElement recpbtn;
	@FindBy(xpath = "//button[@type='submit']")
	public WebElement subbtn;
//	@FindBy(xpath = "//li[contains(@class,'treeview')][4]")
//	public WebElement appointmentMenu;
	 public By appointmentMenu = By.xpath("//*[contains(text(),'Today Appointment')]");

	@FindBy(xpath = "//*[contains(text(),'Today Appointment')]")
	public WebElement todayAppointmentFilter;
	@FindBy(xpath = "//*[contains(text(),'Upcoming Appointment')]")
	public WebElement upcomingAppointmentFilter;
	@FindBy(xpath = "//*[contains(text(),'Old Appointment')]")
	public WebElement oldAppointmentFilter;
	@FindBy(xpath = "//table/tbody/tr")
	public List<WebElement> appointmentRows;
}