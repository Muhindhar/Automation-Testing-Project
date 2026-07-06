package pages;

import org.openqa.selenium.By;

public class PostalPages {
	public By recbtnfo = By
			.cssSelector(".btn.btn-primary.width50[href='#'][onclick=\\\"copy('maria@gmail.com', 'password')\\\"]");
	public By signinfo = By.xpath("//button[@type='submit']");
	public By frontofc = By.xpath(
			"//li//a//span[text()='Front Office'] | //span[contains(text(),'Front Office')] | //li/a/span[contains(.,'Front Office')]");
	public By postbtn = By.xpath("//button[@id='dropdownMenu1']");
	public By dispatch = By.xpath("//a[normalize-space()='Dispatch']");
	public By adddispatch = By.xpath("//a[@class='btn btn-primary btn-sm adddispatch']");
	public By title = By.xpath("//input[@fdprocessedid='iosxt']");
	public By savebtn = By.xpath("//button[@id='formaddbtn']");
	public By list = By.xpath("//h3[@class='box-title titlefix']");
	

}
