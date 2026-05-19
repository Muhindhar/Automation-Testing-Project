package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.DriverFactory;

public class AddVisitorPages {
	public By frontofc = By.xpath("//li//a//span[text() = 'Front Office']");
	public By purposeDropdown = By.xpath("//select[@name='purpose']");
	public By addVisitorBtn = By.xpath("//a[@class='btn btn-primary btn-sm addvisitor']");
	public By visitorName = By.xpath("//form[@id='formadd']//input[@name='name']");
	public By phoneNumber = By.xpath("//form[@id='formadd']//input[@name='contact']");
	public By purpose = By.xpath("//select[@fdprocessedid='kvhvzp']");
	public By personToVisit = By.xpath("//select[@id='visit_to']");
	public By checkinDate = By.id("date");
	public By noOfPersons = By.id("no_of_pepple");
	public By idCard = By.id("id_card");
	public By note = By.id("description");
	public By saveBtn = By.xpath("//button[@type='submit']");
	public By successMessage = By.xpath("//*[contains(text(),'Record Saved Successfully')]");
	public By validationMessage = By.xpath("//span[contains(@class,'text-danger')]");

}
