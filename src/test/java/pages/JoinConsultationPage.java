package pages;

import org.openqa.selenium.By;

public class JoinConsultationPage {
	public By liveConsultation = By.xpath("//li[contains(@class ,\"treeview\")][28]");
	public By liveConsultationOption = By.xpath("//li[contains(@class ,\"treeview\")][28]/ul/li/a");
	public By table = By.xpath("//div/table");
	
	public By getStatusDropdown(int rowIndex) {
	    return By.xpath("//tbody/tr[" + rowIndex + "]/td[8]/form/select");
	}

	public By getActionButtons(int rowIndex) {
	    return By.xpath("//tbody/tr[" + rowIndex + "]/td[9]/a");
	}
	

}
