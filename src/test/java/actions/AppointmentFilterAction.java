package actions;

import org.openqa.selenium.WebDriver;

import pages.AppointmentFilter;
import utilities.HelperClass;

public class AppointmentFilterAction {

	AppointmentFilter af = new AppointmentFilter();
	WebDriver driver = HelperClass.getDriver();
	
	public void recptbnclick() {
		af.recpbtn.click();
	}
	public void subbtn() {
		af.subbtn.click();
	}
	public void clickAppointmentSection() {
		af.appointmentMenu.click();
	}

	public void clickTodayAppointmentFilter() {
		af.todayAppointmentFilter.click();
	}

	public void clickUpcomingAppointmentFilter() {
		af.upcomingAppointmentFilter.click();
	}

	public void clickOldAppointmentFilter() {
		af.oldAppointmentFilter.click();
	}

	public boolean verifyAppointmentRecordsPresent() {
		return af.appointmentRows.size() > 0;
	}
}