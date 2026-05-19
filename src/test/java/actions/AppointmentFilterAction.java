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
		try {
			HelperClass.logger.info("clicking reception button");
			jsClickfb(af.recpbtn);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void subbtn() {
		try {
			clickfb(af.subbtn);
			HelperClass.logger.info("clicking submit button");
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickapp() {
		try {
			HelperClass.logger.info("clicking appointment button");
			jsClick(af.appointmentMenu);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clicktdyapp() {
		try {
			HelperClass.logger.info("clicking today application button");
			clickfb(af.todayAppointmentFilter);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickupapp() {
		try {
			HelperClass.logger.info("clicking upcoming appointment button");
			clickfb(af.upcomingAppointmentFilter);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickoldapp() {
		try {
			HelperClass.logger.info("clicking old application button");
			clickfb(af.oldAppointmentFilter);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean verifyrecord() {
		try {
			return af.appointmentRows.size()>0;
		} 
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}