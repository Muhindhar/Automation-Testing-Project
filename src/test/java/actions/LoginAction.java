package actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import definitions.Helper;
import definitions.Hooks;
import pages.DashboardPage;
import pages.LoginPage;
import utilities.DriverFactory;
import utilities.HelperClass;

public class LoginAction extends BaseAction{
	
	LoginPage lp;
	DashboardPage dp;

	public LoginAction(WebDriver driver) {
		super(driver);
		lp = new LoginPage();
		dp = new DashboardPage();
		this.driver = driver;
	}
	
	public void setUsername(String username)
	{
		HelperClass.logger.info("entering username");
		sendKeys(lp.emailInput, username);
	}
	
	public void setPassword(String password)
	{
		HelperClass.logger.info("entering password");
		sendKeys(lp.passwordInput, password);
	}
	
	public void clickLoginButton()
	{
		HelperClass.logger.info("clicking login button");
		click(lp.signInButton);
	}
	
	public String getInvalidErrorMessage()
	{
		HelperClass.logger.info("getting invalid message");
		return getText(lp.invalidErrorMessage);
	}
	
	public String getUsernameErrorMessage()
	{
		HelperClass.logger.info("username error message");
		return getText(lp.usernameErrorMessage);
	}
	
	public String getPasswordErrorMessage()
	{
		HelperClass.logger.info("password error message");
		return getText(lp.passwordErrorMessage);
	}
	
	public void clickLogin(String role)
	{
		switch(role)
		{
			case "Super Admin":
				HelperClass.logger.info("clicking super admin");
				click(lp.superAdmin);
				break;
			case "Admin":
				HelperClass.logger.info("clicking admin");
				click(lp.admin);
				break;
			case "Doctor":
				HelperClass.logger.info("clicking doctor");
				click(lp.doctor);
				break;
			case "Nurse":
				HelperClass.logger.info("clicking nurse");
				click(lp.nurse);
				break;
			case "Pharmacist":
				HelperClass.logger.info("clicking pharmacist");
				click(lp.pharmacist);
				break;
			case "Pathologist":
				HelperClass.logger.info("clicking pathologist");
				click(lp.pathologist);
				break;
			case "Radiologist":
				HelperClass.logger.info("clicking radiologist");
				click(lp.radiologist);
				break;
			case "Accountant":
				HelperClass.logger.info("clicking accountant");
				click(lp.accountant);
				break;
			case "Receptionist":
				HelperClass.logger.info("clicking receptionist");
				click(lp.receptionist);
				break;
			
		}
	}
	
	public String getUserRole()
	{
		click(dp.profileIcon);
		return getText(dp.role);
	}
	
	public void goToLoginPage()
	{

		DriverFactory.getDriver().get(Helper.getPropertyFile().getProperty("loginUrl"));
	}

}
