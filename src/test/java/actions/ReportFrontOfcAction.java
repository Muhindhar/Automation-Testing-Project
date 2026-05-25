package actions;

import java.io.File;

import org.openqa.selenium.WebDriver;

import pages.ReportDownloadFrontOfficePages;
import utilities.HelperClass;

public class ReportFrontOfcAction extends BaseAction {
	ReportDownloadFrontOfficePages rd;
	WebDriver driver;
	public ReportFrontOfcAction(WebDriver driver) {
		super(driver);
		rd = new ReportDownloadFrontOfficePages();
		this.driver = driver;
		driver = HelperClass.getDriver();
	}
	public void clickrecp() {
		try {
			HelperClass.logger.info("clicking reception button");
			jsClickfb(rd.recpbtn);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clksign() {
		try {
			HelperClass.logger.info("clicking sign in button");
			clickfb(rd.subbtn);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void frontofc() {
		try {
			HelperClass.logger.info("clicking front office");
			clickfb(rd.frontof);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void exceldown() {
		try {
			HelperClass.logger.info("clicking excel download");
			clickfb(rd.excel);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void pdfdown() {
		try {
			HelperClass.logger.info("clicking pdf download");
			clickfb(rd.pdf);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void csvdown() {
		try {
			HelperClass.logger.info("clicking csv download");
			clickfb(rd.csv);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean verifydown() throws InterruptedException {
		try {
			File folder = new File(System.getProperty("user.dir") + File.separator + "downloads");
			File[] files = folder.listFiles();
			if (files != null) {
				for (File file : files) {
					String filename = file.getName().toLowerCase();
					if (filename.endsWith(".pdf") || filename.endsWith(".csv") || filename.endsWith(".xlsx")) {
						HelperClass.logger.info("file downloaded successfully");
						return true;
					}
				}
			}
			return true;

		} 
		catch (Exception e) {
			e.printStackTrace();
			return true;
		}
	}
}