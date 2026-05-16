package actions;

import org.openqa.selenium.WebDriver;

import pages.ReportDownloadFo;
import utilities.HelperClass;

public class ReportFrontOfcAct {
	ReportDownloadFo rd = new ReportDownloadFo();
	WebDriver driver = HelperClass.getDriver();
	
	public void clickrecp() {
		rd.recpbtn.click();
	}
	public void clksign() {
		rd.subbtn.click();
	}
	public void frontofc() {
		rd.frontof.click();
	}
	public void exceldown() {
		rd.excel.click();
	}
	

}
