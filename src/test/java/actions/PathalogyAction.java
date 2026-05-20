package actions;

import java.util.List;

import org.jspecify.annotations.NonNull;
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
    
   //for search
    
    public void clickLogin() {
    	click(pathoPage.login);
    }

    public void clickUserlog() {
        click(pathoPage.userlog);
        waitForVisibility(pathoPage.signup);
    }

    public void clickSignup() {
    	
        waitForVisibility(pathoPage.signup);
        click(pathoPage.signup);
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

        wait.until(ExpectedConditions.presenceOfElementLocated(pathoPage.billNumber(billNo)));
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
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.tagName("iframe")));
    }
    
    public void enterMob(String mobile) {
    
        try {
            WebElement mobileField = wait.withTimeout(java.time.Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(pathoPage.mobile));
            mobileField.clear();
            mobileField.sendKeys(mobile);
        } catch (org.openqa.selenium.TimeoutException e) {
        	System.out.println("Mobile field not displayed");
        }
    }

    public void clickContinue() {

        try {
            WebElement continueBtn = wait.withTimeout(java.time.Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(pathoPage.cont));
            continueBtn.click();
        } catch (org.openqa.selenium.TimeoutException e) {
        	 System.out.println("Continue button not clickable");
        }
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

        try {
            driver.switchTo().defaultContent();
        } catch (Exception e) {
            System.out.println("Already on main page — no iframe switch needed");
        }

        wait.withTimeout(java.time.Duration.ofSeconds(30))
            .until(ExpectedConditions.visibilityOfElementLocated(pathoPage.succ));

        return getText(pathoPage.succ);
    }
    
    public String getPayErrorTxt() {
        try {

            WebElement errorEl = wait.withTimeout(java.time.Duration.ofSeconds(8))
                .until(ExpectedConditions.visibilityOfElementLocated(pathoPage.payError));
            String errorTxt = errorEl.getText().trim();
            return errorTxt;
        } catch (org.openqa.selenium.TimeoutException e) {
            String pageSource = driver.getPageSource();
            boolean hasExceed = pageSource.contains("Amount Should Not Be Greater Than Balance");
            boolean hasInvalid = pageSource.contains("Invalid Amount");
            if (hasExceed) return "Amount Should Not Be Greater Than Balance";
            if (hasInvalid) return "Invalid Amount";
            return "";
        }
    }
}