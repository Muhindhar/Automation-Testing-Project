package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PathologistPage {

    WebDriver driver;

    public PathologistPage(WebDriver driver) {
        this.driver = driver;
    }

    public By pathologistBtn = By.xpath("//a[normalize-space()='Pathologist'] | //button[normalize-space()='Pathologist']");
    public By signInBtn         = By.xpath("//button[normalize-space()='Sign In']");
    public By pathalogist       = By.xpath("//a[@onclick=\"copy('harry@gmail.com', 'password')\"]/following-sibling::a[1]");
    public By messaging         = By.xpath("//a[@href=\"https://demo.smart-hospital.in/admin/notification\"]/child::span");
    public By sendSms           = By.xpath("//a[@href=\"https://demo.smart-hospital.in/admin/notification/add\"]/following-sibling::a");
    public By title             = By.xpath("(//div[@class='form-group']/child::input)[1]");
    public By tempId            = By.xpath("(//label[text()='Template Id']/following-sibling::input)[1]");
    public By sms               = By.xpath("(//label[@class='checkbox-inline']/child::input)[1]");
    public By mobileApp         = By.xpath("(//label[@class='checkbox-inline']/input[@value='push'])[1]");
    public By message           = By.xpath("//label[text()='Message']/following-sibling::textarea[@name='group_message']");
    public By dtr               = By.xpath("//input[@value='3']");
    public By nurse             = By.xpath("//input[@value='9']");
    public By send              = By.xpath("(//div[@class='pull-right']/child::button)[1]");
    public By succMsg           = By.xpath("//div[text()='Record Saved Successfully']");
    public By emptyError        = By.xpath("//div[@class='toast-message']//p[text()='Message To field is required']");
    public By missingFieldError = By.xpath("//div[@class='toast-message']//p[text()='Send Through field is required']");
}