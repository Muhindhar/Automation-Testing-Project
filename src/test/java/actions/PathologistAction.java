package actions;

import org.openqa.selenium.WebDriver;
import pages.PathologistPage;

public class PathologistAction extends BaseAction {

    PathologistPage pathologyPage;

    public PathologistAction(WebDriver driver) {
        super(driver);
        this.pathologyPage = new PathologistPage(driver);
    }
    
    public void navigateToAdminLogin() {
        driver.get("https://demo.smart-hospital.in/site/login");
    }
    
    public void clickPathologistBtn() {
        waitForVisibility(pathologyPage.pathologistBtn);
        click(pathologyPage.pathologistBtn);
    }

    public void clickSignIn() {
        waitForVisibility(pathologyPage.signInBtn);
        click(pathologyPage.signInBtn);
    }

    public void clickPathologist() {
        click(pathologyPage.pathalogist);
    }

    public void clickmsg() {
        waitForVisibility(pathologyPage.messaging);
        click(pathologyPage.messaging);
    }

    public void clickSms() {
        click(pathologyPage.sendSms);
    }

    public void enterTitle(String title) {
        waitForVisibility(pathologyPage.title);
        sendKeys(pathologyPage.title, title);
    }

    public void enterTempId(String tempId) {
        sendKeys(pathologyPage.tempId, tempId);
    }

    public void sendthrough() {
        click(pathologyPage.sms);
        click(pathologyPage.mobileApp);
    }

    public void enterMessage(String message) {
        waitForVisibility(pathologyPage.message);
        sendKeys(pathologyPage.message, message);
    }

    public void msgTo() {
        click(pathologyPage.dtr);
        click(pathologyPage.nurse);
    }

    public void clickSend() {
        click(pathologyPage.send);
    }

    public String getSuccessMsg() {
        try {
            return getText(pathologyPage.succMsg);
        } catch (Exception e) {
            System.out.println("Success message not found: " + e.getMessage());
            return null;
        }
    }
    
    public String getErrorMsg() {
        try {
            waitForVisibility(pathologyPage.emptyError);
            return getText(pathologyPage.emptyError);
        } catch (Exception e) {
            System.out.println("Error toast not found: " + e.getMessage());
            return null;
        }
    }

    public String getMissingFieldMsg() {
        try {
            waitForVisibility(pathologyPage.missingFieldError);
            return getText(pathologyPage.missingFieldError);
        } catch (Exception e) {
            System.out.println("Missing field toast not found: " + e.getMessage());
            return null;
        }
    }
}