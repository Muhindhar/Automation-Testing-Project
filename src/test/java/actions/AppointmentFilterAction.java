package actions;

import org.openqa.selenium.WebDriver;

import pages.AppointmentFilterPage;
import utilities.HelperClass;

public class AppointmentFilterAction extends BaseAction {

	AppointmentFilterPage af;
	WebDriver driver;
	public AppointmentFilterAction(WebDriver driver) {
		super(driver);
		this.driver = driver;
		af = new AppointmentFilterPage();
	}

	public void recptbnclick() {
		HelperClass.logger.info("clicking reception button");
		jsClickfb(af.recpbtn);
	}

	public void subbtn() {
		clickfb(af.subbtn);
		HelperClass.logger.info("clicking submit button");
	}

	public void clickapp() {
		HelperClass.logger.info("clicking appointment button");
		jsClick(af.appointmentMenu);
	}

	public void clicktdyapp() {
		HelperClass.logger.info("clicking today application button");
		clickfb(af.todayAppointmentFilter);
	}

	public void clickupapp() {
		HelperClass.logger.info("clicking upcoming appointment button");
		clickfb(af.upcomingAppointmentFilter);
	}

	public void clickoldapp() {
		HelperClass.logger.info("clicking old application button");
		clickfb(af.oldAppointmentFilter);
	}

	public boolean verifyrecord() {
		return af.appointmentRows.size() > 0;
	}
}