package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverFactory;

public class AppointmentFilterPage {

    public AppointmentFilterPage() {
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class = 'form-bottom']//a[text() = 'Receptionist']")
    public WebElement recpbtn;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement subbtn;
    public By appointmentMenu = By.xpath("//li//a//span[text() = 'Appointment']");
    @FindBy(xpath = "//ul[contains(@class,'navlistscroll')]//a[normalize-space()='Today Appointment']")
    public WebElement todayAppointmentFilter;
    @FindBy(xpath = "//ul[contains(@class,'navlistscroll')]//a[normalize-space()='Upcoming Appointment']")
    public WebElement upcomingAppointmentFilter;
    @FindBy(xpath = "//ul[contains(@class,'navlistscroll')]//a[normalize-space()='Old Appointment']")
    public WebElement oldAppointmentFilter;
    @FindBy(xpath = "//table/tbody/tr")
    public List<WebElement> appointmentRows;
    @FindBy(xpath="//span[@class='logo-lg']")
    public WebElement verify;
    
}