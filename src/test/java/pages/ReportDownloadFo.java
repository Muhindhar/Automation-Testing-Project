package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.HelperClass;

public class ReportDownloadFo {
	public ReportDownloadFo(){
		PageFactory.initElements(HelperClass.getDriver(), this);
	}
	@FindBy(xpath="//a[normalize-space()='Receptionist']")
	public WebElement recpbtn;
	@FindBy(xpath="//button[@type='submit']")
	public WebElement subbtn;
	@FindBy(xpath="//span[normalize-space()='Front Office']")
	public WebElement frontof;
	@FindBy(xpath="//i[@class='fa fa-file-excel-o']")
	public WebElement excel;
	@FindBy(xpath="//i[@class='fa fa-file-text-o']")
	public WebElement csv;
	@FindBy(xpath="//a[@title='PDF']//span")
	public WebElement pdf;
	
	
}
