package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverFactory;

public class ReportDownloadFrontOfficePages {
	public ReportDownloadFrontOfficePages() {
		PageFactory.initElements(DriverFactory.getDriver(), this);
	}

//	@FindBy(css = ".btn.btn-primary.width50[href='#'][onclick=\"copy('maria@gmail.com', 'password')\"]")
//	public WebElement recpbtn;
//	@FindBy(xpath ="//a[contains(@onclick,'maria@gmail.com')]")
//	public WebElement recpbtn;
	@FindBy(xpath ="//a[contains(text(),'Receptionist')]")
	public WebElement recpbtn;

	@FindBy(xpath = "//button[@type='submit']")
	public WebElement subbtn;
	@FindBy(xpath = "//li//a//span[text() = 'Front Office']")
	public WebElement frontof;
	@FindBy(xpath = "//a[contains(@class,'buttons-pdf')]")
	public WebElement pdf;
	@FindBy(xpath = "//a[contains(@class,'buttons-csv')]")
	public WebElement csv;
	@FindBy(xpath = "//a[contains(@class,'buttons-excel')]")
	public WebElement excel;
}