package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverFactory;

public class ReportDownloadFo {
	public ReportDownloadFo() {
		PageFactory.initElements(DriverFactory.getDriver(), this);
	}

	@FindBy(xpath = "//*[contains(text(),'Receptionist')]")
	public WebElement recpbtn;
	@FindBy(xpath = "//button[@type='submit']")
	public WebElement subbtn;
	@FindBy(xpath = "//li[contains(@class,'treeview')][12]")
	public WebElement frontof;
	@FindBy(xpath = "//a[contains(@class,'buttons-pdf')]")
	public WebElement pdf;
	@FindBy(xpath = "//a[contains(@class,'buttons-csv')]")
	public WebElement csv;
	@FindBy(xpath = "//a[contains(@class,'buttons-excel')]")
	public WebElement excel;
}