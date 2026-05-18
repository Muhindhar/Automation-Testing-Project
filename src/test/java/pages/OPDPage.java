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
}