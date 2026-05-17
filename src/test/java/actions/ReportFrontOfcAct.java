package actions;

import java.io.File;

import org.openqa.selenium.WebDriver;

import pages.ReportDownloadFo;
import utilities.HelperClass;

public class ReportFrontOfcAct extends BaseAction {
	ReportDownloadFo rd;
	WebDriver driver;

	public ReportFrontOfcAct(WebDriver driver) {
		super(driver);
		rd = new ReportDownloadFo();
		this.driver = driver;
		driver = HelperClass.getDriver();
		// TODO Auto-generated constructor stub
	}

	public void clickrecp() {
		clickfb(rd.recpbtn);
	}

	public void clksign() {
		clickfb(rd.subbtn);
	}

	public void frontofc() {
		clickfb(rd.frontof);
	}

	public void exceldown() {
		clickfb(rd.excel);
	}

	public void pdfdown() {
		clickfb(rd.pdf);
	}

	public void csvdown() {
		clickfb(rd.csv);
	}

	public boolean verifydown() throws InterruptedException {

		Thread.sleep(3000);

		File folder = new File(System.getProperty("user.dir") + File.separator + "downloads");

		File[] files = folder.listFiles();

		if (files != null) {

			for (File file : files) {

				String filename = file.getName().toLowerCase();

				if (filename.endsWith(".pdf") || filename.endsWith(".csv") || filename.endsWith(".xlsx")) {

					return true;
				}
			}
		}

		return false;
	}

}
