package pages;

import org.openqa.selenium.By;

public class AddVisitorPages {

	public By frontofc =
			By.xpath("//span[normalize-space()='Front Office']");

	public By addVisitorBtn =
			By.xpath("//a[contains(@class,'addvisitor')]");

	public By visitorName =
			By.xpath("//input[contains(@name,'name')]");

	public By phoneNumber =
			By.xpath("//input[contains(@type,'tel')]");

	public By purpose =
			By.xpath("(//select)[1]");

	public By personToVisit =
			By.xpath("(//select)[2]");

	public By checkinDate =
			By.xpath("//input[contains(@id,'date')]");

	public By noOfPersons =
			By.xpath("//input[contains(@id,'pepple')]");

	public By idCard =
			By.xpath("//input[contains(@id,'id_card')]");

	public By note =
			By.xpath("//textarea");

	public By saveBtn =
			By.xpath("//button[@type='submit']");

	public By successMessage =
			By.xpath("//*[contains(text(),'Record Saved Successfully')]");

	public By validationMessage =
			By.xpath("//*[contains(@class,'text-danger')]");
}