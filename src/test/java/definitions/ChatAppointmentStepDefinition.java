package definitions;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;

import actions.ChatAppointmentActions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import utilities.DriverFactory;

public class ChatAppointmentStepDefinition {

	WebDriver driver = DriverFactory.getDriver();

	ChatAppointmentActions caa = new ChatAppointmentActions(driver);

	@When("user clicks on appointment section")
	public void user_clicks_on_appointment_section() {

		caa.clickappointment();
	}

	@When("clicks on chat icon in the appointment page")
	public void clicks_on_chat_icon_in_the_appointment_page() {

		caa.clickchaticon();
	}

	@When("user selects the doctor in the chat page")
	public void user_selects_the_doctor_in_the_chat_page() {

		caa.selectdoctor();
	}

	@When("user sends the message in the chatbox")
	public void user_sends_the_message_in_the_chatbox() {

		caa.sendmessage();
	}

	@Then("user should be able to send the message")
	public void user_should_be_able_to_send_the_message() {

		Assert.assertTrue(caa.verifymessage(),

				"Message not sent successfully");
	}
}
