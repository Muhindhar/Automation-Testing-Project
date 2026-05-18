package actions;

import java.util.List;

import org.jspecify.annotations.NonNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import pages.PathalogyPage;

public class PathalogyAction extends BaseAction {

    PathalogyPage pathoPage;

    public PathalogyAction(WebDriver driver) {
        super(driver);
        this.pathoPage = new PathalogyPage(driver);
    }
    
   //for search
    
    public void clickLogin() {
    	click(pathoPage.login);
    }

    public void clickUserlog() {

        click(pathoPage.userlog);
        waitForVisibility(pathoPage.signup);
        System.out.println("After User Login click URL: "+ driver.getCurrentUrl());
    }

    public void clickSignup() {
    	
        waitForVisibility(pathoPage.signup);

        System.out.println("Current URL before Sign In: "+ driver.getCurrentUrl());
        click(pathoPage.signup);
        System.out.println("Clicked Sign In button");
    }

    public void clickPathology() {
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
    
    //for payment
    
    public void clickpay() {
    	click(pathoPage.paybtn);
    }
    
    public void enterAmt(String amt) {
    	sendKeys(pathoPage.payAmt, amt);
    }
    
    public void clickadd() {
    	click(pathoPage.add);
    }
    
    public void ensure_makepay() {

        click(pathoPage.makepay);

        System.out.println("Clicked Make Payment");
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.tagName("iframe")));
        System.out.println("Switched to Razorpay iframe");
    }
    
    public void enterMob(String mobile) {

        WebElement mobileField = wait.until(ExpectedConditions.visibilityOfElementLocated(pathoPage.mobile));
        mobileField.clear();
        mobileField.sendKeys(mobile);

        System.out.println("Entered mobile number");
    }
    
    public void clickContinue() {
    	click(pathoPage.cont);
    }
    
    public void chooseUpi() {
    	click(pathoPage.upi);
    }
    
    public void sendUpiId(String upiId) {
    	sendKeys(pathoPage.email,upiId);
    }
    
    public void clickVerify() {
    	click(pathoPage.verify);
    }
    
    public String getSuccessTxt() {
    	return getText(pathoPage.succ);
    }
}