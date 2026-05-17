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
		click(cp.recbtnfo);
		click(cp.signinfo);
	}
	public void clkfo() {
		click(cp.frontofc);
	}
	public void clkcom() {
		click(cp.complaint);
	}
	public void addcomp() {
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
		click(cp.savebtn);
	}
	public String checklistcom() {
		return getText(cp.checklistcomp);
	}

}
