package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OPDPage{
	
	
	WebDriver driver;
	public OPDPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

	// LOCATORS: User Story 4.1 - Search
	
	public By opdButton = By.xpath("//ul[@class='sidebar-menu verttop']/li[5]");
	
	public By oldOpdTab = By.xpath("//ul[@class='nav nav-tabs navlistscroll']//li[3]");

    public By searchBox = By.xpath("//div[@id='DataTables_Table_1_filter']/label/input");
    
    public By patientname = By.xpath("//table[@id='DataTables_Table_1']/tbody[1]/tr[1]/td[2]");
    
    public By patientid = By.xpath("//table[@id='DataTables_Table_1']/tbody[1]/tr[1]/td[1]/a");
    
    public By searchFailed = By.xpath("//td[@class='dataTables_empty']/div");
    
    
 // User Story 4.4 - Report Download
    public By opdOutPatientTab = By.xpath("//a[contains(text(),'OPD - Out Patient')]");
    public By showIconFirstPatient = By.xpath("(//a[contains(@href,'OpdPatient/show')])[1]");
    public By visitsTab = By.xpath("//a[contains(text(),'Visits')]");
    public By printIcon = By.xpath("(//a[contains(@href,'print') or @title='Print'])[1]");

}
