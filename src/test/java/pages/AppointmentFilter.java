package pages;

import java.util.List;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

import utilities.DriverFactory;

public class AppointmentFilter {
	public AppointmentFilter() {
		PageFactory.initElements(DriverFactory.getDriver(), this);
	}
	@FindBy(xpath = "//a[normalize-space()='Receptionist']")
	public WebElement recpbtn;
	@FindBy(xpath = "//button[@type='submit']")
	public WebElement subbtn;
	@FindBy(xpath = "//li[contains(@class,'treeview')][4]")
	public WebElement appointmentMenu;
	@FindBy(xpath = "//ul[@class='nav nav-tabs navlistscroll']//li[1]")
	public WebElement todayAppointmentFilter;
	@FindBy(xpath = "//ul[@class='nav nav-tabs navlistscroll']//li[2]")
	public WebElement upcomingAppointmentFilter;
	@FindBy(xpath = "//ul[@class='nav nav-tabs navlistscroll']//li[3]")
	public WebElement oldAppointmentFilter;
	@FindBy(xpath = "//table/tbody/tr")
	public List<WebElement> appointmentRows;
}