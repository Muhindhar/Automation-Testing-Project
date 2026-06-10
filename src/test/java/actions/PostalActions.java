package actions;

import org.openqa.selenium.WebDriver;

import pages.PostalPages;
import utilities.HelperClass;

public class PostalActions extends BaseAction {

	PostalPages pp;

	WebDriver driver;

	public PostalActions(WebDriver driver) {

		super(driver);

		this.driver = driver;

		pp = new PostalPages();
	}

	public void clickrecp() {

		HelperClass.logger.info("clicking receptionist button");

		click(pp.recbtnfo);
	}

	public void clksign() {

		HelperClass.logger.info("clicking sign in button");

		click(pp.signinfo);
	}

	public void clickfrontoffice() {

		HelperClass.logger.info("clicking front office");

		click(pp.frontofc);
	}

	public void clickpostal() {

		HelperClass.logger.info("clicking postal button");

		click(pp.postbtn);
	}

	public void clickdispatch() {

		HelperClass.logger.info("clicking dispatch button");

		click(pp.dispatch);
	}

	public void clickadddispatch() {

		HelperClass.logger.info("clicking add dispatch button");

		click(pp.adddispatch);
	}

	public void enterdetails() {

		try {

			waitForClickable(pp.title);

			sendKeys(pp.title, "Automation Postal");

		}

		catch (Exception e) {

			System.out.println("Unable to enter title");
		}
	}

	public void clicksave() {

		HelperClass.logger.info("clicking save button");

		click(pp.savebtn);
	}

	public boolean verifypostal() {

		HelperClass.logger.info("verifying postal details");

		return isDisplayed(pp.list);
	}
}