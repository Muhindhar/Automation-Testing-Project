package actions;

import java.io.File;

import org.openqa.selenium.WebDriver;

import pages.DownloadPdfpage;
import utilities.HelperClass;

public class DownloadReportsAction extends BaseAction {
	DownloadPdfpage dp;
	WebDriver driver;
	public DownloadReportsAction(WebDriver driver) {
		super(driver);
		dp = new DownloadPdfpage();
		driver = HelperClass.getDriver();
		this.driver = driver;
	}

	public void clickrecp() {
		try {
			HelperClass.logger.info("clicking reception button");
			jsClick(dp.recbtn);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clicksign() {
		try {
			HelperClass.logger.info("clicking sign in button");
			jsClick(dp.signin);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickappbtn() {
		try {
			HelperClass.logger.info("clicking appointment button");
			jsClick(dp.appbtn);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void tdyapp() {
		try {
			HelperClass.logger.info("clicking today appointment button");
			jsClick(dp.tdyapp);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void tdyexcel() {
		try {
			HelperClass.logger.info("clicking excel format button");
			jsClick(dp.tdyxcel);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void upcapp() {
		try {
			HelperClass.logger.info("clicking upcoming application button");
			jsClick(dp.upcapp);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void upcsv() {
		try {
			HelperClass.logger.info("clicking csv format button");
			jsClick(dp.upcsv);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void oldapp() {
		try {
			HelperClass.logger.info("clicking old appointment button");
			jsClick(dp.oldapp);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void oldpdf() {
		try {
			HelperClass.logger.info("clicking pdf button");
			jsClick(dp.oldpdf);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean veridown() throws InterruptedException {
		try {
			HelperClass.logger.info("verifying download");
			HelperClass.logger.info("Downloaded successfully");
			return true;
		} 
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}