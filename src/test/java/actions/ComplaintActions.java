package actions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.ComplaintFoPages;
import utilities.HelperClass;

public class ComplaintActions {
	ComplaintFoPages cp = new ComplaintFoPages();
	WebDriver driver = HelperClass.getDriver();
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	public void clickrescp() {
		driver.findElement(cp.recbtnfo).click();
		driver.findElement(cp.signinfo).click();
	}
	public void clkfo() {
		driver.findElement(cp.frontofc).click();
	}
	public void clkcom() {
		wait.until(ExpectedConditions.elementToBeClickable(cp.complaint)).click();
	}
	public void addcomp() {
		wait.until(ExpectedConditions.elementToBeClickable(cp.addcomp)).click();
	}
	public void compdet(String complainttype,String source,String phone,String description) {
		Select com = new Select(driver.findElement(cp.comtype));
		com.selectByVisibleText(complainttype);
		Select src = new Select(driver.findElement(cp.src));
		src.selectByVisibleText(source);
		driver.findElement(cp.phone).sendKeys(phone);
		driver.findElement(cp.desc).sendKeys(description);
	}
	public void savebtn() {
		driver.findElement(cp.savebtn).click();
	}
	public String checklistcom() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(cp.checklistcomp)).getText();
	}

}
