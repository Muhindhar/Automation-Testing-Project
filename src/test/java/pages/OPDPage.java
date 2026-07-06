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
    public By opdButton   = By.xpath("//ul[@class='sidebar-menu verttop']/li[5]/child::a");
    public By oldOpdTab   = By.xpath("//ul[@class='nav nav-tabs navlistscroll']/li[3]/child::*");
    public By searchBox   = By.xpath("//div[@id='DataTables_Table_1_filter']/label/input");
    public By patientname = By.xpath("//table[@id='DataTables_Table_1']/tbody/tr[1]/td[text()='Maria Taylor']");
    public By searchFailed = By.xpath("//td[@class='dataTables_empty']");

    // Report Download
    public By opdOutPatientNavLink = By.xpath("//table[@id='DataTables_Table_1']/tbody/tr[1]/td[1]/child::a");
    public By visitsTab            = By.xpath("//ul[@class='nav nav-tabs border-0 navlistscroll']/li[2]/child::a");
    public By printIcon            = By.xpath("//a[contains(@class,'buttons-pdf') and @aria-controls='DataTables_Table_1']");
    
 // Add Patient
    public By addPatientButton  = By.xpath("//div[@id='tab_2']/child::div/a");
    public By addIcon           = By.xpath("//div[@id='myModal']/child::div/div/div/div/div/a");

    public By nameField         = By.id("name");
    public By genderDropdown    = By.id("addformgender");
    public By yearField         = By.id("age_year");
    public By monthField        = By.id("age_month");
    public By dayField          = By.id("age_day");

    public By saveButton        = By.cssSelector("div.pull-right button#formaddpabtn");
    public By successMessage    = By.cssSelector("div#toast-container div.toast-success");
    public By nameErrorMessage  = By.cssSelector("div#toast-container div.toast-error");
    
    //discharge
    public By revert =By.xpath("//div[@class='editviewdelete-icon pt8 text-center']/child::a[4]");
    public By dischargeIcon = By.xpath("//div[@class='pull-right']/div/child::a[3]");
    public By dateField = By.xpath("//form[@id='patient_discharge']/child::div[2]/child::div[1]/child::*/child::input");
    public By reasonDropDown = By.xpath("//form[@id='patient_discharge']/child::div[2]/child::div[2]/child::*/child::select");
    public By noteField = By.xpath("//textarea[@id='note']");
    public By operationField = By.xpath("//textarea[@id='operation']");
    public By diagnosisField = By.xpath("//textarea[@id='diagnosis']");
    public By investigationField = By.xpath("//textarea[@id='investigations']");
    public By saveDischargeButton = By.xpath("//div[@class='pull-right']/button[@id='add_paymentbtn']");
    
}