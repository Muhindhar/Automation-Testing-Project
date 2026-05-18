package actions;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseAction {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected JavascriptExecutor js;

    private static final int TIMEOUT = 20;

    public BaseAction(WebDriver driver) {

        this.driver = driver;

        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(TIMEOUT));

        this.js = (JavascriptExecutor) driver;
    }

    // Click using By locator
    public void click(By locator) {

        WebElement element =
                wait.until(
                        ExpectedConditions.elementToBeClickable(locator));

        element.click();
    }

    // Click using WebElement
    public void clickfb(WebElement element) {

        wait.until(
                ExpectedConditions.elementToBeClickable(element));

        element.click();
    }

    // JavaScript click
    public void jsClick(By locator) {

        WebElement element =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(locator));

        js.executeScript(
                "arguments[0].click();",
                element);
    }

    // Send keys using By
    public void sendKeys(
            By locator,
            String value) {

        WebElement element =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(locator));

        element.clear();
        element.sendKeys(value);
    }

    // Send keys using WebElement
    public void sendKeysfb(
            WebElement element,
            String value) {

        wait.until(
                ExpectedConditions.visibilityOf(element));

        element.clear();
        element.sendKeys(value);
    }

    // JavaScript SendKeys
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

    // Get text using By
    public String getText(By locator) {

        WebElement element =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(locator));

        return element.getText();
    }

    // Get text using WebElement
    public String getTextfb(
            WebElement element) {

        wait.until(
                ExpectedConditions.visibilityOf(element));

        return element.getText();
    }

    // Check display using By
    public boolean isDisplayed(By locator) {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator))
                .isDisplayed();
    }

    // Check display using WebElement
    public boolean isDisplayedfb(
            WebElement element) {

        return wait.until(
                ExpectedConditions.visibilityOf(element))
                .isDisplayed();
    }

    // Explicit wait for visibility
    public void waitForVisibility(By locator) {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator));
    }
}