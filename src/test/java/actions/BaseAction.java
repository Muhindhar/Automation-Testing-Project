package actions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.DriverFactory;

public class BaseAction {

	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	private static final int TIMEOUT = 10;
	public BaseAction(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
		this.js = (JavascriptExecutor) driver;
	}

	public void click(By locator) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		js.executeScript("arguments[0].scrollIntoView({block:'center'});", element);
		js.executeScript("arguments[0].click();", element);
	}

	public void clickfb(WebElement element) {
		WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(element));
		js.executeScript("arguments[0].scrollIntoView({block:'center'});", ele);
		js.executeScript("arguments[0].click();", ele);
	}

	public void jsClick(By locator) {
		
		js.executeScript("arguments[0].scrollIntoView({block:'center'});", DriverFactory.getDriver().findElement(locator));
		js.executeScript("arguments[0].click();", DriverFactory.getDriver().findElement(locator));
	}

	public void jsClickfb(WebElement w) {
		js.executeScript("arguments[0].scrollIntoView({block:'center'});", w);
		js.executeScript("arguments[0].click();", w);
	}

	public void sendKeys(By locator, String value) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.clear();
		element.sendKeys(value);
	}

	public void sendKeysfb(WebElement element, String value) {
		WebElement ele = wait.until(ExpectedConditions.visibilityOf(element));
		ele.clear();
		ele.sendKeys(value);
	}

	public void jsSendKeys(By locator, String value) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		js.executeScript("arguments[0].value=arguments[1];", element, value);
	}

	public String getText(By locator) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return element.getText();
	}

	public String getTextfb(WebElement element) {
		WebElement ele = wait.until(ExpectedConditions.visibilityOf(element));
		return ele.getText();
	}

	public boolean isDisplayed(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
	}

	public boolean isDisplayedfb(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
	}

	public WebElement waitForVisibility(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public WebElement waitForClickable(By locator) {
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public List<WebElement> getElements(By locator) {
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}

	public WebElement getElement(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void jsClickElement(WebElement webElement) {
		js.executeScript("arguments[0].scrollIntoView({block:'center'});", webElement);
		js.executeScript("arguments[0].click();", webElement);
	}

	public void selectByVisibleText(By locator, String text) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	public void selectByValue(By locator, String value) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		Select select = new Select(element);
		select.selectByValue(value);
	}

	public void selectByIndex(By locator, int index) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public void customDropdown(By locator, String value) {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		js.executeScript("arguments[0].scrollIntoView({block:'center'});", element);
		element.click();
		element.sendKeys(value);
		element.sendKeys(Keys.ENTER);
	}
	
	public void switchToFrame(By locator) {
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
	}
}