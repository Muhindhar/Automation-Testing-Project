package actions;


import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.ProfilePage;

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
		click(dp.profileIcon);
	}
	
	public String getRole() {
		return getText(pp.role);
	}
	
	
	
	public void clickProfileButton() {
		click(pp.profileButton);
		
	}
	
	public void clickLeaveButton() {
		click(pp.leaveButton);
	}
	
	public boolean isLeaveTable() {
	    return !driver.findElements(pp.leaveTable).isEmpty();
	}
	
	
}
