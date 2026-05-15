package pages;

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
	
	@FindBy(xpath = "//ul[@class='sidebar-menu verttop']/li[5]")
	public WebElement opdButton;
	
	@FindBy(xpath = "//ul[@class='nav nav-tabs navlistscroll']//li[3]")
	public WebElement oldOpdTab;

    @FindBy(xpath = "//div[@id='DataTables_Table_1_filter']/label/input") 
    public WebElement searchBox;
    
    @FindBy(xpath = "//table[@id='DataTables_Table_1']/tbody[1]/tr[1]/td[2]") 
    public WebElement patientname;
    
    @FindBy(xpath = "//table[@id='DataTables_Table_1']/tbody[1]/tr[1]/td[1]/a") 
    public WebElement patientid;
    
    @FindBy(xpath = "//td[@class='dataTables_empty']/div")
    public WebElement searchFailed;
    
    


}
