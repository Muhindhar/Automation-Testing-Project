package pages;

import org.openqa.selenium.By;

public class CallLogFrontofcPages {
	public By recbtnfo = By
			.cssSelector(".btn.btn-primary.width50[href='#'][onclick=\\\"copy('maria@gmail.com', 'password')\\\"]");
	public By signinfo = By.xpath("//button[@type='submit']");
	public By frontofc = By.xpath("//span[normalize-space()='Front Office'] | //li//a//span[text()='Front Office']");
	public By phcalllog = By.xpath(
			"//div[@class = 'box-tools pull-right']//a[@href = 'https://demo.smart-hospital.in/admin/generalcall']");
	public By addlog = By.xpath("//a[@class='btn btn-primary btn-sm call_log']");
	public By name = By.xpath("//form[@id='formadd']//input[@name='name']");
	public By phone = By.xpath("//form[@id='formadd']//input[@name='contact']");
	public By desc = By.xpath("//label[text()='Description']//following-sibling::textarea[@id='description']");
	public By callduration = By.xpath("//form[@id='formadd']//input[@name='call_dureation']	");
	//public By callduration = By.xpath("//label[text()='Call Duration']//following-sibling::*[@fdprocessedid='ggf30t']");
	public By note = By.xpath("//label[text()='Note']//following-sibling::textarea[@id='description']");
	public By incom = By.xpath("//form[@id='formadd']//input[@name='call_type' and @value='Incoming']");
	public By outgng = By.xpath("//form[@id='formadd']//input[@name='call_type' and @value='Outgoing']");
	public By savebtn = By.xpath("//button[@id='formaddbtn']");
	public By checklist = By.xpath("//h3[@class='box-title titlefix']");
	public By error = By.xpath("//h3[@class='box-title titlefix']");
}
