package actions;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import pages.JoinConsultationPage;
import utilities.DriverFactory;

public class JoinConsultationAction extends BaseAction{
	
	JoinConsultationPage jp;

	public JoinConsultationAction(WebDriver driver) {
		super(driver);
		jp = new JoinConsultationPage();
	}
	
	public void clickLiveConsultationDropDown()
	{
		click(jp.liveConsultation);
	}
	
	public void clickLiveConsultationOption()
	{
		click(jp.liveConsultationOption);
	}

}
