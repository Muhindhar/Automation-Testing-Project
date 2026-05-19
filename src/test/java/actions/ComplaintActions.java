package actions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.ComplaintFoPages;
import utilities.HelperClass;

public class ComplaintActions extends BaseAction{
	ComplaintFoPages cp;
	WebDriverWait wait;
	WebDriver driver;
	public ComplaintActions(WebDriver driver) {
		super(driver);
		cp = new ComplaintFoPages();
		 wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		 this.driver = driver;
		// TODO Auto-generated constructor stub
	}

	public void clickrescp() {
		HelperClass.logger.info("clicking reception button");
		click(cp.recbtnfo);
		HelperClass.logger.info("clicking signin button");
		click(cp.signinfo);
	}
	public void clkfo() {
		HelperClass.logger.info("clicking front office button");
		click(cp.frontofc);
	}
	public void clkcom() {
		HelperClass.logger.info("clicking complaint button");
		click(cp.complaint);
	}
	public void addcomp() {
		HelperClass.logger.info("clicking add complaint button");
		click(cp.addcomp);
	}
	public void compdet(String complainttype,String source,String phone,String description) {
		Select com = new Select(driver.findElement(cp.comtype));
		com.selectByVisibleText(complainttype);
		Select src = new Select(driver.findElement(cp.src));
		src.selectByVisibleText(source);
		sendKeys(cp.phone,phone);
		sendKeys(cp.desc,description);
	}
	public void savebtn() {
		HelperClass.logger.info("clicking save button");
		click(cp.savebtn);
	}
	public String checklistcom() {
		HelperClass.logger.info("checking the list ");
		return getText(cp.checklistcomp);
	}
	public void emptyfields() {
		HelperClass.logger.info("checking whether the fields are empty");
		 isDisplayed(cp.emptyfields);
	}

}
