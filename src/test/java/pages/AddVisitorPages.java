package pages;

import org.openqa.selenium.By;

public class AddVisitorPages {

    public By frontofc         = By.xpath("//span[normalize-space()='Front Office']");
    public By addVisitorBtn    = By.xpath("//a[contains(@class,'addvisitor')]");
    public By select = By.xpath("//select[@fdprocessedid='bmihev']");
    public By visitorName      = By.xpath("(//input[@type='text'])[1]");
    public By phoneNumber      = By.xpath("(//input[@type='text'])[2]");
    public By purpose          = By.xpath("(//select)[1]");
    public By personToVisit    = By.xpath("(//select)[2]");
    public By checkinDate      = By.xpath("//input[contains(@id,'date')]");
    public By noOfPersons      = By.xpath("//input[contains(@id,'pepple')]");
    public By idCard           = By.xpath("//input[contains(@id,'id_card')]");
    public By note             = By.xpath("//textarea");
    public By saveBtn          = By.xpath("//button[@type='submit']");
    public By successmsg       = By.xpath("//*[contains(text(),'Record Saved Successfully')]");
    public By validationMessage = By.xpath("//*[contains(@class,'text-danger')]");
}