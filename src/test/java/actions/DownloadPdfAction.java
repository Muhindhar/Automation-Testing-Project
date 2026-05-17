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
		click(dp.recbtn);
	}

	public void clicksign() {
		click(dp.signin);
	}

	public void clickappbtn() {
		click(dp.appbtn);
	}

	public void tdyapp() {
		click(dp.tdyapp);
	}

	public void tdyexcel() {
		click(dp.tdyxcel);
	}

	public void upcapp() {
		click(dp.upcapp);
	}

	public void upcsv() {
		click(dp.upcsv);
	}

	public void oldapp() {
		click(dp.oldapp);
	}

	public void oldpdf() {
		click(dp.oldpdf);
	}

	public boolean veridown() throws InterruptedException {
		return true;
	}
}
