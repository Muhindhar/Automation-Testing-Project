package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class OPDPage {

    WebDriver driver;

    public OPDPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // Search
    public By opdButton   = By.xpath("//ul[@class='sidebar-menu verttop']/li[5]/a");
    public By oldOpdTab   = By.xpath("//ul[@class='nav nav-tabs navlistscroll']//li[3]/a");
    public By searchBox   = By.xpath("//div[@id='DataTables_Table_1_filter']/label/input");
    public By patientname = By.xpath("//table[@id='DataTables_Table_1']/tbody/tr[1]/td[text()='Maria Taylor']");
    public By searchFailed = By.xpath("//td[@class='dataTables_empty']");

    // Report Download
    public By opdOutPatientNavLink = By.xpath("//table[@id='DataTables_Table_1']/tbody/tr/td[1]");
    public By showIconFirstPatient = By.xpath("//table[@id='DataTables_Table_1']/tbody[1]/tr[1]/td[1]/a");
    public By visitsTab            = By.xpath("//ul[@class='nav nav-tabs border-0 navlistscroll']/li[2]/a");
    public By printIcon            = By.xpath("//a[contains(@class,'buttons-pdf') and @aria-controls='DataTables_Table_1']");
    
 // User Story 4.2 - Add Patient
    public By addPatientButton  = By.xpath("//a[contains(text(),'Add Patient') or contains(@href,'OpdPatient/create')]");
    public By addIcon           = By.xpath("//a[@title='Add' or contains(@class,'btn-success')][1]");

    public By nameField         = By.xpath("//input[@id='patient_name' or @name='patient_name']");
    public By genderDropdown    = By.xpath("//select[@id='sex' or @name='sex']");
    public By yearField         = By.xpath("//input[@id='age' or @name='age']");
    public By monthField        = By.xpath("//input[@id='age_month' or @name='age_month']");
    public By dayField          = By.xpath("//input[@id='age_day' or @name='age_day']");

    public By saveButton        = By.xpath("//button[@type='submit' and contains(text(),'Save')]");
    public By successMessage    = By.xpath("//*[contains(text(),'Record Saved Successfully')]");
    public By nameErrorMessage  = By.xpath("//*[contains(text(),'Name field is required') or contains(@class,'error') and contains(text(),'Name')]");
}