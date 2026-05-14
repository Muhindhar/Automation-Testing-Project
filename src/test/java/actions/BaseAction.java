package actions;

import org.openqa.selenium.WebDriver;

public class BaseAction {
	WebDriver driver;
	
	public BaseAction(WebDriver driver) {
		this.driver = driver;
	}

}
