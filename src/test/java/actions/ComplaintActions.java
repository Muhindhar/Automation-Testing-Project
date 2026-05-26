package actions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.ComplaintFoPages;
import utilities.HelperClass;

public class ComplaintActions extends BaseAction {
	ComplaintFoPages cp;
	WebDriverWait wait;
	WebDriver driver;
	public ComplaintActions(WebDriver driver) {
		super(driver);
		cp = new ComplaintFoPages();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.driver = driver;
	}

	public void clickrescp() {
		try {
			HelperClass.logger.info("clicking reception button");
			click(cp.recbtnfo);
			HelperClass.logger.info("clicking signin button");
			click(cp.signinfo);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clkfo() {
		try {
			HelperClass.logger.info("clicking front office button");
			click(cp.frontofc);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clkcom() {
		try {
			HelperClass.logger.info("clicking complaint button");
			click(cp.complaint);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addcomp() {
		try {
			HelperClass.logger.info("clicking add complaint button");
			click(cp.addcomp);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void compdet(String complainttype, String source, String phone, String description) {
		try {
			Select com = new Select(driver.findElement(cp.comtype));
			com.selectByVisibleText(complainttype);
			Select src = new Select(driver.findElement(cp.src));
			src.selectByVisibleText(source);
			sendKeys(cp.phone, phone);
			sendKeys(cp.desc, description);
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void savebtn() {
		try {
			HelperClass.logger.info("clicking save button");
			click(cp.savebtn);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String checklistcom() {
		try {
			HelperClass.logger.info("checking the list");
			return getText(cp.checklistcomp);
		}
		catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	public void emptyfields() {
		try {
			HelperClass.logger.info("checking whether the fields are empty");
			isDisplayed(cp.emptyfields);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}