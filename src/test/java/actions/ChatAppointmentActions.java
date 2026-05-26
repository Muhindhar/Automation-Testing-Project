package actions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.ChatAppointmentPages;
import utilities.HelperClass;

public class ChatAppointmentActions extends BaseAction {

	WebDriver driver;

	WebDriverWait wait;

	ChatAppointmentPages cap;

	public ChatAppointmentActions(WebDriver driver) {

		super(driver);

		this.driver = driver;

		wait = new WebDriverWait(
				driver,
				Duration.ofSeconds(10));

		cap = new ChatAppointmentPages();
	}

	public void clickrecp() {

		HelperClass.logger.info(
				"clicking receptionist");

		click(cap.recbtn);
	}

	public void clicksignin() {

		HelperClass.logger.info(
				"clicking signin");

		click(cap.signin);
	}

	public void clickappointment() {

		HelperClass.logger.info(
				"clicking appointment section");

		click(cap.appbtn);
	}

	public void clickchaticon() {

		HelperClass.logger.info(
				"clicking chat icon");

		click(cap.chatbtn);
	}

	public void selectdoctor() {

		HelperClass.logger.info(
				"selecting doctor");

		click(cap.person);
	}

	public void sendmessage() {

		HelperClass.logger.info(
				"sending message");

		sendKeys(
				cap.msg,
				"Hello Doctor");

		click(cap.sendmsg);
	}

	public boolean verifymessage() {

		HelperClass.logger.info(
				"verifying message");

		return isDisplayed(cap.check);
	}
}
