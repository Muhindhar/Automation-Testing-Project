//package pages;
//
//import org.openqa.selenium.By;
//
//public class ComplaintFoPages {
//	public By recbtnfo = By.xpath("//*[contains(text(),'Receptionist')]");
//	// public By recbtnfo = By.xpath("//div[@class = 'form-bottom']//a[text() =
//	// 'Receptionist']");
//	public By signinfo = By.xpath("//button[@type='submit']");
//	public By frontofc = By.xpath("//li//a//span[text() = 'Front Office']");
//	public By complaint = By.xpath("//div[@class='box-tools pull-right']//a[3]");
//	public By addcomp = By.xpath("//a[@class='btn btn-primary btn-sm complain']");
//	public By comtype = By.xpath("//div[@class='ptt10']//select[@name='complaint']");
//	public By src = By.xpath("//div[@class='ptt10']//select[@name='source']");
//	public By phone = By.xpath("//div[@class='ptt10']//input[@name='contact']");
//	public By desc = By.xpath("//div[@id='myModal']//div[6]//div[1]//textarea[1]");
//	public By savebtn = By.xpath("//button[@id='formaddbtn']");
//	public By checklistcomp = By.xpath("//h3[@class='box-title titlefix']");
//	public By emptyfields = By.xpath("//div[@class='toast-message']");
//
//}
package pages;

import org.openqa.selenium.By;
public class ComplaintFoPages {
	public By recbtnfo = By.xpath("//a[normalize-space()='Receptionist']");
	public By signinfo = By.xpath("//button[@type='submit']");
	public By frontofc = By.xpath("//span[text()='Front Office']");
	public By complaint = By.xpath("//a[contains(text(),'Complain')]");
	public By addcomp = By.xpath("//a[contains(@class,'complain')]");
	public By comtype = By.xpath("//select[@name='complaint']");
	public By src = By.xpath("//select[@name='source']");
	public By phone = By.xpath("//input[@name='contact']");
	public By desc = By.xpath("//textarea");
	public By savebtn = By.xpath("//button[@id='formaddbtn']");
	public By checklistcomp = By.xpath("//h3[contains(@class,'titlefix')]");
	public By emptyfields = By.xpath("//div[contains(@class,'toast-message')]");
}