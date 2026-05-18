package actions;

import org.openqa.selenium.WebDriver;
import pages.JoinConsultationPage;

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

	public int findRecordWithStatus(String string) {
		int statusCount = getElements(jp.tableBody).size();
		
		for(int i=1; i<=statusCount; i++)
		{
			String status = getElement(jp.getStatusDropdown(i)).getText();
			if(status.equals(string))
			{
				return i;
			}
		}
		
		return -1;
	}

//	public boolean isActionPresent() {
//		
//	}

}
