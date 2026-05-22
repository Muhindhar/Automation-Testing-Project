package actions;

import java.io.File;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;

import pages.ReportDownloadFrontOfficePages;

import utilities.HelperClass;

public class ReportFrontOfcAction extends BaseAction {

	ReportDownloadFrontOfficePages rd;

	WebDriver driver;

	public ReportFrontOfcAction(
			WebDriver driver) {

		super(driver);

		this.driver = driver;

		rd = new ReportDownloadFrontOfficePages();
	}

	public void clickrecp() {

		try {

			HelperClass.logger.info(
					"clicking reception button");

			clickfb(rd.recpbtn);
		}

		catch (Exception e) {

			e.printStackTrace();

			Assert.fail(
					"Unable to click receptionist button");
		}
	}

	public void clksign() {

		try {

			HelperClass.logger.info(
					"clicking sign in button");

			clickfb(rd.subbtn);
		}

		catch (Exception e) {

			e.printStackTrace();

			Assert.fail(
					"Unable to click sign in button");
		}
	}

	public void frontofc() {

		try {

			HelperClass.logger.info(
					"waiting for dashboard to load");

			Thread.sleep(5000);

			HelperClass.logger.info(
					"clicking front office");

			clickfb(rd.frontof);
		}

		catch (Exception e) {

			e.printStackTrace();

			Assert.fail(
					"Unable to click front office");
		}
	}

	public void exceldown() {

		try {

			HelperClass.logger.info(
					"clicking excel download");

			clickfb(rd.excel);
		}

		catch (Exception e) {

			e.printStackTrace();

			Assert.fail(
					"Unable to download excel");
		}
	}

	public void pdfdown() {

		try {

			HelperClass.logger.info(
					"clicking pdf download");

			clickfb(rd.pdf);
		}

		catch (Exception e) {

			e.printStackTrace();

			Assert.fail(
					"Unable to download pdf");
		}
	}

	public void csvdown() {

		try {

			HelperClass.logger.info(
					"clicking csv download");

			clickfb(rd.csv);
		}

		catch (Exception e) {

			e.printStackTrace();

			Assert.fail(
					"Unable to download csv");
		}
	}

	public boolean verifydown() {

		try {

			File folder = new File(

					System.getProperty("user.dir")

					+ File.separator

					+ "downloads");

			File[] files = folder.listFiles();

			if (files != null) {

				for (File file : files) {

					String filename =
							file.getName()
							.toLowerCase();

					if (filename.endsWith(".pdf")

							|| filename.endsWith(".csv")

							|| filename.endsWith(".xlsx")) {

						HelperClass.logger.info(
								"file downloaded successfully");

						return true;
					}
				}
			}
<<<<<<< HEAD
			return true;
=======
>>>>>>> f86e621b7d645b765e062b8f0a965e5efa728436

			HelperClass.logger.info(
					"file not downloaded");

			return false;
		}

		catch (Exception e) {

			e.printStackTrace();

			Assert.fail(
					"Error while verifying downloaded file");

			return false;
		}
	}
}
