package pages;

import org.openqa.selenium.By;

public class JoinConsultationPage {
	public By liveConsultation = By.xpath("//li[contains(@class ,\"treeview\")][19]");
	public By liveConsultationOption = By.xpath("//li[contains(@class ,\"treeview\")][19]/ul/li/a");
	public By tableBody = By.xpath("//div/table/tbody/tr");
	public By popUp = By.xpath("//div[@id = \"modal-chkstatus\"]");
	public By startNow = By.xpath("//a[contains(@href , \"zoom\") and @class = \"btn btn-outline-success btn-sm pull-right\"]");
	public By addButton = By.xpath("//div[@class = \"box-tools pull-right box-tools-md\"]/button[1]");
	public By patientName = By.xpath("//select[@id = \"addpatient_id\"]/following-sibling::span/span/span/span[2]");
	public By firstPatientoption = By.xpath("//span[@class = \"select2-results\"]/ul/li[1]");
	public By patientNameInput =By.cssSelector("input.select2-search__field");
	public By title = By.xpath("//input[@name = \"title\"]");
	public By date = By.cssSelector("input#datetimepicker");
	public By duration = By.cssSelector("input#duration");
	public By ipdOrOpd = By.xpath("//select[@class = \"form-control module_type\"]");
	public By description = By.cssSelector("textarea#description");
	public By addCredentialButton = By.xpath("//div[@class= \"box-tools pull-right box-tools-md\"]/button[2]");
	public By zoomApiKeyField = By.xpath("//input[@id = \"zoom_api_key\"]");
	public By zoomApiSecretField = By.xpath("//input[@id = \"zoom_api_secret\"]");
	public By saveCredentialButton = By.xpath("//button[@id = \"submit-btn-credential\"][2]");
	public By successToastMessage = By.xpath("//div[@class = \"toast-message\"]");
	public By saveConsultationButton = By.xpath("//div[@class = \"pull-right mrminus8\"]/button[@class = \"btn btn-primary\"]");

	
	public By getStatusDropdown(int rowIndex) {
	    return By.xpath("//tbody/tr[" + rowIndex + "]/td[8]/form/select");
	}

	public By getActionButtons(int rowIndex) {
	    return By.xpath("//tbody/tr[" + rowIndex + "]/td[9]/a");
	}
	

}
