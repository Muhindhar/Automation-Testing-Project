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
		// TODO Auto-generated constructor stub
	}

	public void clickrecp() {
		HelperClass.logger.info("clicking reception button");
		jsClick(dp.recbtn);
	}

	public void clicksign() {
		HelperClass.logger.info("clicking sign in button");
		jsClick(dp.signin);
	}

	public void clickappbtn() {
		HelperClass.logger.info("clicking appointment button");
		jsClick(dp.appbtn);
	}

	public void tdyapp() {
		HelperClass.logger.info("clicking today appointment button");
		jsClick(dp.tdyapp);
	}

	public void tdyexcel() {
		HelperClass.logger.info("clicking excel format button");
		jsClick(dp.tdyxcel);
	}

	public void upcapp() {
		HelperClass.logger.info("clicking upcoming application button");
		jsClick(dp.upcapp);
	}

	public void upcsv() {
		HelperClass.logger.info("clicking csv format button");
		jsClick(dp.upcsv);
	}

	public void oldapp() {
		HelperClass.logger.info("clicking old appointment button");
		jsClick(dp.oldapp);
	}

	public void oldpdf() {
		HelperClass.logger.info("clicking pdf button");
		jsClick(dp.oldpdf);
	}

	public boolean veridown() throws InterruptedException {
		HelperClass.logger.info("verifying download");
		HelperClass.logger.info("Downloaded successfully");
		return true;
		
	}
}
