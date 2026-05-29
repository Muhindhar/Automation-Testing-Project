package actions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.BedStatusPages;
import utilities.HelperClass;

public class BedStatusAppointmentActions extends BaseAction {
	BedStatusPages psp;

	public BedStatusAppointmentActions(WebDriver driver) {
		super(driver);
		this.driver = driver;
		psp = new BedStatusPages();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// TODO Auto-generated constructor stub
	}

	public void clickrecp() {
		try {
			HelperClass.logger.info("Clicking reception button");
			click(psp.recpbtn);
		} catch (Exception e) {
			HelperClass.logger.error("Error");
			System.out.println(e.getMessage());
		}
	}
	public void signin() {
		try {
			HelperClass.logger.info("clicking signin");
			click(psp.signin);
		}
		catch(Exception e) {
			HelperClass.logger.error("Error");
			System.out.println(e.getMessage());
		}
	}
	public void appointment() {
		try {
			HelperClass.logger.info("clicking appointment button");
			click(psp.appbtn);
		}
		catch(Exception e) {
			HelperClass.logger.error("Error");
			System.out.println(e.getMessage());
		}
	}
	public void clickbed() {
		try {
			HelperClass.logger.info("clicking bed status");
			click(psp.bedsts);
		}
		catch(Exception e) {
			HelperClass.logger.error("Error");
			System.out.println(e.getMessage());
		}
	}
	public void clickroom() {
		try {
			click(psp.room);
			HelperClass.logger.info("clicking room whether available or not");
		}
		catch(Exception e) {
			HelperClass.logger.error("Error");
			System.out.println(e.getMessage());
		}
	}
	public boolean check() {
		try {
			HelperClass.logger.info("Checking");
			click(psp.check);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			HelperClass.logger.error("Error");
		}
		return true;
	}
	

}
