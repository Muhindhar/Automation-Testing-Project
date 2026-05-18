package actions;

import java.io.File;

import org.openqa.selenium.WebDriver;

import pages.DownloadPdfpage;
import utilities.HelperClass;

public class DownloadPdfAction extends BaseAction {
	DownloadPdfpage dp;
	WebDriver driver;
	public DownloadPdfAction(WebDriver driver) {
		super(driver);
		dp = new DownloadPdfpage();
		driver = HelperClass.getDriver();
		this.driver = driver;
		// TODO Auto-generated constructor stub
	}

	public void clickrecp() {
		jsClick(dp.recbtn);
	}

	public void clicksign() {
		jsClick(dp.signin);
	}

	public void clickappbtn() {
		jsClick(dp.appbtn);
	}

	public void tdyapp() {
		jsClick(dp.tdyapp);
	}

	public void tdyexcel() {
		jsClick(dp.tdyxcel);
	}

	public void upcapp() {
		jsClick(dp.upcapp);
	}

	public void upcsv() {
		jsClick(dp.upcsv);
	}

	public void oldapp() {
		jsClick(dp.oldapp);
	}

	public void oldpdf() {
		jsClick(dp.oldpdf);
	}

	public boolean veridown() throws InterruptedException {
		return true;
	}
}
