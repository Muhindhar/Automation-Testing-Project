package actions;

import org.openqa.selenium.WebDriver;

import pages.NoticeBoardPages;
import utilities.HelperClass;

public class NoticeBoardActions extends BaseAction {

	WebDriver driver;
	NoticeBoardPages nbp;

	public NoticeBoardActions(WebDriver driver) {

		super(driver);

		this.driver = driver;

		nbp = new NoticeBoardPages();
	}

	public void clknotice() {

		HelperClass.logger.info(
				"Clicking notice");

		jsClick(nbp.notice);
	}

	public boolean noticedisplayed() {

		HelperClass.logger.info(
				"Checking Notice Board page visibility");

		return isDisplayed(nbp.noticedispl);
	}
}