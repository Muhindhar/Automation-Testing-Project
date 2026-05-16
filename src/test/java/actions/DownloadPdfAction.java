package actions;

import java.io.File;

import org.openqa.selenium.WebDriver;

import pages.DownloadPdfpage;
import utilities.HelperClass;

public class DownloadPdfAction {

	DownloadPdfpage dp = new DownloadPdfpage();
	WebDriver driver = HelperClass.getDriver();

	public void clickrecp() {
		driver.findElement(dp.recbtn).click();
	}

	public void clicksign() {
		driver.findElement(dp.signin).click();
	}

	public void clickappbtn() {
		driver.findElement(dp.appbtn).click();
	}

	public void tdyapp() {
		driver.findElement(dp.tdyapp).click();
	}

	public void tdyexcel() {
		driver.findElement(dp.tdyxcel).click();
	}

	public void upcapp() {
		driver.findElement(dp.upcapp).click();
	}

	public void upcsv() {
		driver.findElement(dp.upcsv).click();
	}

	public void oldapp() {
		driver.findElement(dp.oldapp).click();
	}

	public void oldpdf() {
		driver.findElement(dp.oldpdf).click();
	}

	public boolean veridown() throws InterruptedException {

		Thread.sleep(3000);

		return true;
	}
}
