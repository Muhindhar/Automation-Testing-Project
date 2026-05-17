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
    public By filter = By.xpath("//*[@id='testreport_info']");
    public By table = By.xpath("//table//tr");
    public By notFound = By.xpath("//tr[@class='odd']//td[text()='No matching records found']");

    //pay
	/*public By paybtn = By.xpath("//button[normalize-space()='Pay']");
	public By payAmt = By.xpath("//input[@id='amount_total_paid']");
	public By makepay = By.xpath("//button[normalize-space()='Make Payment']");
	public By upi = By.xpath("//div[@data-value='upi']");
	public By email = By.xpath("//input[@placeholder='example@okhdfcbank']");
	public By cont = By.xpath("//button[@name='button']");
    public By succ = By.xpath("//div[@class='alert alert-success alert-dismissible']");
    */
}
