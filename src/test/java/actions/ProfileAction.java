package actions;


import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.ProfilePage;
import utilities.HelperClass;

public class ProfileAction extends BaseAction{
	
	public ProfileAction(WebDriver driver) {
		super(driver);
		dp= new DashboardPage();
		pp= new ProfilePage();
		// TODO Auto-generated constructor stub
	}
	DashboardPage dp;
	ProfilePage pp;
	public void clickProfileIcon() {
		HelperClass.logger.info("Clicking profile icon");
		click(dp.profileIcon);
	}
	
	public String getRole() {
		HelperClass.logger.info("Getting role");
		return getText(pp.role);
	}
	
	
	
	public void clickProfileButton() {
		HelperClass.logger.info("Clicking profile button");
		click(pp.profileButton);
		
	}
	
	public void clickLeaveButton() {
		HelperClass.logger.info("clicking leave button");
		click(pp.leaveButton);
	}
	
	public boolean isLeaveTable() {
		HelperClass.logger.info("checking table is empty ");
	    return !driver.findElements(pp.leaveTable).isEmpty();
	}
	
	
}
