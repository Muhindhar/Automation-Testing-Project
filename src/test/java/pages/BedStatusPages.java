package pages;

import org.openqa.selenium.By;

public class BedStatusPages {

	public By recpbtn = By.xpath("//div[@class='btn-group btn-group-justified']//child::a[contains(text(),'Reception')]");
	public By signin = By.xpath("//form//child::button[@type='submit']");
	public By appbtn = By.xpath("//span[normalize-space()='Appointment']");
	public By bedsts = By.xpath("//i[contains(@class,'fa-bed')]/parent::a");
	public By room = By.xpath("(//div/child::i[contains(@class,'fa-bed')])[5]");
	public By check = By.xpath("//td[contains(text(),'Gender')]/following-sibling::td");
}