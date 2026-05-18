package actions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import pages.PathalogyPage;
import utilities.HelperClass;

public class PathalogyAction extends BaseAction {

    PathalogyPage pathoPage;

    public PathalogyAction(WebDriver driver) {
        super(driver);
        this.pathoPage = new PathalogyPage(driver);
    }
    
    public void clickLogin() {
    	HelperClass.logger.info("Clicking login ");
    	click(pathoPage.login);
    }

    public void clickUserlog() {
    	HelperClass.logger.info("clicking login");
        click(pathoPage.userlog);
        waitForVisibility(pathoPage.signup);
        System.out.println("After User Login click URL: "+ driver.getCurrentUrl());
    }

    public void clickSignup() {
    	
        waitForVisibility(pathoPage.signup);

        System.out.println("Current URL before Sign In: "+ driver.getCurrentUrl());
        HelperClass.logger.info("Getting url");
        click(pathoPage.signup);
        System.out.println("Clicked Sign In button");
    }

    public void clickPathology() {
    	HelperClass.logger.info("Clicking pathology");
        click(pathoPage.pathlogyMenu);
    }

    public void searchreport(String billNo) {
        sendKeys(pathoPage.search, billNo);
    }

    public void isRecDisplayed(String billNo) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(pathoPage.table));
        List<WebElement> rows = driver.findElements(pathoPage.table);
        int actualRows = rows.size();

        if (actualRows <= 1) {
            System.out.println("No records found");
        } else {
            System.out.println("Records found: " + (actualRows - 1));
        }

        wait.until(ExpectedConditions.presenceOfElementLocated(
            By.xpath("//*[contains(text(),'" + billNo + "')]")));

        boolean isPresent = driver.getPageSource().contains(billNo);
        Assert.assertTrue(isPresent, "Bill number not displayed in results");
    }
    
    public void invalidSearch(String BillNo) {
    	sendKeys(pathoPage.search,BillNo);
    }
    
    public String getErrorTxt() {
    	return getText(pathoPage.notFound);
    }
}