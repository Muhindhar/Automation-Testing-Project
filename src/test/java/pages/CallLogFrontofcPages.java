package pages;

import org.openqa.selenium.By;

public class CallLogFrontofcPages {
	public By recbtnfo = By.xpath("//a[normalize-space()='Receptionist']");
	public By signinfo = By.xpath("//button[@type='submit']");
	public By frontofc = By.xpath("//li[contains(@class,'treeview')][12]");
	public By phcalllog = By.xpath("//a[contains(normalize-space(),'Phone Call Log')]");
	public By addlog = By.xpath("//a[@class='btn btn-primary btn-sm call_log']");
	public By name = By.xpath("//form[@id='formadd']//input[@name='name']");
	public By phone = By.xpath("//input[@fdprocessedid='panood']");
	public By desc = By.xpath("//div[@id='myModal']//div[2]//div[1]//textarea[1]");
	public By incom = By.xpath("//form[@id='formadd']//input[@name='call_type' and @value='Incoming']");
	public By outgng = By.xpath("//form[@id='formadd']//input[@name='call_type' and @value='Outgoing']");
	public By savebtn = By.xpath("//button[@id='formaddbtn']");
	public By checklist = By.xpath("//h3[@class='box-title titlefix']");
	public By error = By.xpath("//h3[@class='box-title titlefix']");
}
