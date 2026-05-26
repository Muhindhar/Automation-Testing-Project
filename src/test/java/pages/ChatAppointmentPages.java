package pages;

import org.openqa.selenium.By;

public class ChatAppointmentPages {
	public By recbtn = By.xpath("//a[normalize-space()='Receptionist']");
	public By signin = By.xpath("//button[@type='submit']");
	public By appbtn = By.xpath("//span[normalize-space()='Appointment']");
	public By chatbtn = By.xpath("//i[@class='fa fa-whatsapp']");
	public By person = By.xpath("//p[contains(text(),'Super Admin')]");
	public By msg = By.xpath("//input[@placeholder='Write Your Message...']");
	public By sendmsg = By.xpath("//i[@class='fa fa-paper-plane']");
	public By check = By.xpath("//p[@class='name'][contains(text(),'Super Admin')]");

}
