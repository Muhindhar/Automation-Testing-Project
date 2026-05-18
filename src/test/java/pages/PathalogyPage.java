package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PathalogyPage {

    WebDriver driver;

    public PathalogyPage(WebDriver driver) {
        this.driver = driver;
    }
    //search and filter
    public By login = By.xpath("//a[text()='Login']");
    public By userlog = By.xpath("//a[normalize-space()='User Login']");
    public By signup = By.xpath("//button[@type='submit'] | //button[contains(text(),'Sign')]");
    public By pathlogyMenu = By.xpath("//a[normalize-space()='Pathology']");
    public By search = By.xpath("//input[@type='search' or @placeholder='Search...']");
    public By filter = By.xpath("//div[text()='Records: 1 to 1 of 1 (filtered from 14 total records)']");
    public By table = By.xpath("//table//tr");
    public By notFound = By.xpath("//tr[@class='odd']//td[text()='No matching records found']");

    //pay
	public By paybtn = By.xpath("//td[@class='text-right']//button[normalize-space()='Pay']");
	public By payAmt = By.xpath("//input[@id='amount_total_paid']");
	public By add = By.xpath("//div[@class='modal-footer']//button[@id='pay_button']");
	public By makepay = By.xpath("//button[normalize-space()='Make Payment']");
	public By mobile = By.xpath("//input[@type='tel']");
	public By cont = By.xpath("//div[@class='bg-surface p-4 d:mt-2 d:px-0 px-0']//button[@type='button']");
	public By upi = By.xpath("//*[self::a or self::li or self::div or self::span][normalize-space()='UPI']");
	public By email = By.xpath("//input[contains(@placeholder,'upi') or contains(@placeholder,'UPI') or contains(@placeholder,'okhdfcbank') or contains(@placeholder,'@')]");
	public By verify = By.xpath("//button[contains(normalize-space(),'Verify') or contains(normalize-space(),'Pay') or contains(normalize-space(),'verify')]");
	public By succ = By.xpath("//div[contains(@class,'alert-success')]");
    
}
