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

public class LoginAction extends BaseAction{
	
	WebDriverWait wait;
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
		sendKeys(lp.emailInput, username);
	}
	
	public void setPassword(String password)
	{
		sendKeys(lp.passwordInput, password);
	}
	
	public void clickLoginButton()
	{
		click(lp.signInButton);
	}
	
	public String getInvalidErrorMessage()
	{
		return getText(lp.invalidErrorMessage);
	}
	
	public String getUsernameErrorMessage()
	{
		return getText(lp.usernameErrorMessage);
	}
	
	public String getPasswordErrorMessage()
	{
		return getText(lp.passwordErrorMessage);
	}
	
	public void clickLogin(String role)
	{
		switch(role)
		{
			case "Super Admin":
				click(lp.superAdmin);
				break;
			case "Admin":
				click(lp.admin);
				break;
			case "Doctor":
				click(lp.doctor);
				break;
			case "Nurse":
				click(lp.nurse);
				break;
			case "Pharmacist":
				click(lp.pharmacist);
				break;
			case "Pathologist":
				click(lp.pathologist);
				break;
			case "Radiologist":
				click(lp.radiologist);
				break;
			case "Accountant":
				click(lp.accountant);
				break;
			case "Receptionist":
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
