package pages;

import org.openqa.selenium.By;

public class JoinConsultationPage {
	public By liveConsultation = By.xpath("//li[contains(@class ,\"treeview\")][28]");
	public By liveConsultationOption = By.xpath("//li[contains(@class ,\"treeview\")][28]/ul/li/a");
	public By tableBody = By.xpath("//div/table/tbody/tr");
	public By popUp = By.xpath("//div[@id = \"modal-chkstatus\"]");
	public By startNow = By.xpath("//a[contains(@href , \"zoom\") and @class = \"btn btn-outline-success btn-sm pull-right\"]");
	public By addButton = By.xpath("//button[@class=\"btn btn-primary btn-sm addappointment\"]");
	public By patientName = By.xpath("//span[@id = \"select2-addpatient_id-container\"]");
	public By patientNameInput =By.cssSelector("input.select2-search__field");
	
	public By getStatusDropdown(int rowIndex) {
	    return By.xpath("//tbody/tr[" + rowIndex + "]/td[8]/form/select");
	}

	public By getActionButtons(int rowIndex) {
	    return By.xpath("//tbody/tr[" + rowIndex + "]/td[9]/a");
	}
	

}
