package pages;

import org.openqa.selenium.By;

public class BloodComponentPage {
	public By billing = By.xpath("//span[text()=' Billing']");
	public By bloodcomp = By.xpath("//p[text()='Blood Component Issue']");
	public By details = By.xpath("(//a[i[@class='fa fa-reorder']])[1]");
	public By patientpopup = By.xpath("//h4[text()='Blood Component Issue Details']");;

}
