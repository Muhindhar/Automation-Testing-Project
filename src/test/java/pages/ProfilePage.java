package pages;

import org.openqa.selenium.By;

public class ProfilePage {

	public By profileButton = By.xpath("//div[@class='sspass']//a[1]");  
	
	public By role = By.xpath("//div[@class='col-lg-2 col-md-4 col-sm-4 border-right'][2]/span");
	
	public By leaveButton = By.xpath("//ul[@class='nav nav-tabs navlistscroll']//child::li[2]/child::a");
	
	public By leaveTable = By.id("DataTables_Table_2");
	
}
