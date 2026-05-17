package actions;

import org.openqa.selenium.WebDriver;

import pages.AppointmentFilter;

public class AppointmentFilterAction extends BaseAction {

	AppointmentFilter af;

	WebDriver driver;

	public AppointmentFilterAction(WebDriver driver) {

		super(driver);

		this.driver = driver;

		af = new AppointmentFilter();
	}

	public void recptbnclick() {

		clickfb(af.recpbtn);
	}

	public void subbtn() {

		clickfb(af.subbtn);
	}

	public void clickapp() {

		clickfb(af.appointmentMenu);
	}

	public void clicktdyapp() {

		clickfb(af.todayAppointmentFilter);
	}

	public void clickupapp() {

		clickfb(af.upcomingAppointmentFilter);
	}

	public void clickoldapp() {

		clickfb(af.oldAppointmentFilter);
	}

	public boolean verifyrecord() {

		return af.appointmentRows.size() > 0;
	}
}