package actions;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseAction {

	WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

	private static final int TIMEOUT = 10;

	public BaseAction(WebDriver driver) {

		this.driver = driver;

		this.wait =
				new WebDriverWait(
				driver,
				Duration.ofSeconds(TIMEOUT));

		this.js =
				(JavascriptExecutor) driver;
	}

	//for by
	public void click(By locator) {

		wait.until(
				ExpectedConditions.elementToBeClickable(locator))
				.click();
	}

	// for findby
	public void clickfb(WebElement element) {

		wait.until(
				ExpectedConditions.elementToBeClickable(element))
				.click();
	}

	public void jsClick(By locator) {

		WebElement element =
				wait.until(
				ExpectedConditions.visibilityOfElementLocated(locator));

		js.executeScript(
				"arguments[0].click();",
				element);
	}

	public void sendKeys(
			By locator,
			String value) {

		WebElement element =
				wait.until(
				ExpectedConditions.visibilityOfElementLocated(locator));

		element.sendKeys(value);
	}

	public void sendKeysfb(
			WebElement element,
			String value) {

		wait.until(
				ExpectedConditions.visibilityOf(element));

		element.sendKeys(value);
	}

	public void jsSendKeys(
			By locator,
			String value) {

		WebElement element =
				wait.until(
				ExpectedConditions.visibilityOfElementLocated(locator));

		js.executeScript(
				"arguments[0].value=arguments[1];",
				element,
				value);
	}

	public String getText(By locator) {

		WebElement element =
				wait.until(
				ExpectedConditions.visibilityOfElementLocated(locator));

		return element.getText();
	}

	public String getTextfb(
			WebElement element) {

		wait.until(
				ExpectedConditions.visibilityOf(element));

		return element.getText();
	}

	public boolean isDisplayed(By locator) {

		return wait.until(
				ExpectedConditions.visibilityOfElementLocated(locator))
				.isDisplayed();
	}

	public boolean isDisplayedfb(
			WebElement element) {

		return wait.until(
				ExpectedConditions.visibilityOf(element))
				.isDisplayed();
	}
}