package actions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.CallLogFrontofcPages;
import utilities.HelperClass;

public class CallLogFrontofcActions {
	WebDriver driver = HelperClass.getDriver();
	CallLogFrontofcPages cfp = new CallLogFrontofcPages();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	public void clckrecp() {
		wait.until(ExpectedConditions.elementToBeClickable(cfp.recbtnfo)).click();

	}

	public void clksign() {
		wait.until(ExpectedConditions.elementToBeClickable(cfp.signinfo)).click();
	}

	public void frontofclink() {
		wait.until(ExpectedConditions.elementToBeClickable(cfp.frontofc)).click();

	}

	public void phcalllog() {
		wait.until(ExpectedConditions.elementToBeClickable(cfp.phcalllog)).click();
	}

	public void addcall() {
		wait.until(ExpectedConditions.elementToBeClickable(cfp.addlog)).click();
	}

	public void enterdet(String name, String phone, String description, String calltype) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(cfp.name)).sendKeys(name);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cfp.desc)).sendKeys(description);
		if (calltype.equalsIgnoreCase("Incoming")) {
			wait.until(ExpectedConditions.elementToBeClickable(cfp.incom)).click();

		} else if (calltype.equalsIgnoreCase("Outgoing")) {
			wait.until(ExpectedConditions.elementToBeClickable(cfp.outgng)).click();

		}
	}

	public void clicksave() {
		wait.until(ExpectedConditions.elementToBeClickable(cfp.savebtn)).click();

	}

	public String checklist() {

		return driver.findElement(cfp.checklist).getText();
	}

	public boolean errorcheck() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(cfp.error)).isDisplayed();
	}

}
