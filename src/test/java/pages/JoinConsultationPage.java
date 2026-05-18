package pages;

import org.openqa.selenium.By;

public class JoinConsultationPage {
	public By liveConsultation = By.xpath("//li[contains(@class ,\"treeview\")][28]");
	public By liveConsultationOption = By.xpath("//li[contains(@class ,\"treeview\")][28]/ul/li/a");
	public By tableBody = By.xpath("//div/table/tbody/tr");
	public By popUp = By.xpath("//div[@id = \"modal-chkstatus\"]");
	public By startNow = By.xpath("//a[contains(@href , \"zoom\") and @class = \"btn btn-outline-success btn-sm pull-right\"]");
	
	public By getStatusDropdown(int rowIndex) {
	    return By.xpath("//tbody/tr[" + rowIndex + "]/td[8]/form/select");
	}

	public By getActionButtons(int rowIndex) {
	    return By.xpath("//tbody/tr[" + rowIndex + "]/td[9]/a");
	}
	

}
