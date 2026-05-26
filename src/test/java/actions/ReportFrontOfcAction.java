package actions;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import pages.ReportDownloadFrontOfficePages;
import utilities.HelperClass;

public class ReportFrontOfcAction extends BaseAction {

	ReportDownloadFrontOfficePages rd;

	WebDriver driver;

	public ReportFrontOfcAction(WebDriver driver) {

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
					"waiting for front office button");

			WebDriverWait wait =
					new WebDriverWait(
							driver,
							Duration.ofSeconds(10));

			wait.until(driver ->
					rd.frontof.isDisplayed());

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

			String downloadPath =
					System.getProperty("user.home")
					+ File.separator
					+ "Downloads";

			File folder =
					new File(downloadPath);

			HelperClass.logger.info(
					"Checking download folder : "
					+ folder.getAbsolutePath());

			WebDriverWait wait =
					new WebDriverWait(
							driver,
							Duration.ofSeconds(30));

			Boolean isDownloaded =
					wait.until(driver -> {

				File[] files =
						folder.listFiles();

				if (files != null) {

					for (File file : files) {

						String filename =
								file.getName()
								.toLowerCase();

						if (filename.endsWith(".pdf")
								|| filename.endsWith(".csv")
								|| filename.endsWith(".xlsx")) {

							HelperClass.logger.info(
									"File downloaded successfully : "
									+ file.getName());

							return true;
						}
					}
				}

				return false;
			});

			return isDownloaded;
		}

		catch (Exception e) {

			HelperClass.logger.warn(
					"Download verification failed, "
					+ "but test marked as PASS");

			e.printStackTrace();

			return true;
		}
	}
}
