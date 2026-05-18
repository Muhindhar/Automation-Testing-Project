package actions;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import pages.JoinConsultationPage;
import utilities.DriverFactory;

public class JoinConsultationAction extends BaseAction {

	JoinConsultationPage jp;

	public JoinConsultationAction(WebDriver driver) {
		super(driver);
		jp = new JoinConsultationPage();
	}

	public void clickLiveConsultationDropDown() {
		jsClick(jp.liveConsultation);
	}

	public void clickLiveConsultationOption() {
		jsClick(jp.liveConsultationOption);
	}

	public int findRecordWithStatus(String string) {
		int statusCount = getElements(jp.tableBody).size();

		for (int i = 1; i <= statusCount; i++) {
			Select select = new Select(getElement(jp.getStatusDropdown(i)));

			String status = select.getFirstSelectedOption().getText();
			
			if (status.equals(string)) {
				return i;
			}
		}

		return -1;
	}

	public boolean isActionPresent(int index) {
		if (index != -1)
			return getElements(jp.getActionButtons(index)).size() == 2;
		else
			return true;
	}

	public boolean isActionClickable(int index) {
		return wait
				.until(ExpectedConditions.elementToBeClickable(getElements(jp.getActionButtons(index)).get(0))) != null;
	}

	public int findRecordNotWithStatus(String string) {
		int statusCount = getElements(jp.tableBody).size();

		for (int i = 1; i <= statusCount; i++) {
			Select select = new Select(getElement(jp.getStatusDropdown(i)));

			String status = select.getFirstSelectedOption().getText();
			if (!status.equals(string)) {
				return i;
			}
		}

		return -1;
	}

	public boolean isActionNotPresent(int index) {
		if (index != -1)
			return getElements(jp.getActionButtons(index)).size() == 1;
		else
			return true;
	}

	public void clickJoinButton(int index) {
		jsClickElement(getElements(jp.getActionButtons(index)).get(0));
	}

	public boolean isPopUpDisplayed() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(jp.popUp)).isDisplayed();
	}

	public boolean isStartNowButtonDisplayed() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(jp.startNow)).isDisplayed();
	}

	public void clickStartNowButton() {
		click(jp.startNow);
	}

	public boolean isNewBrowserOpened() {
		return DriverFactory.getDriver().getWindowHandles().size() > 1;
	}

	public boolean isURLContains(String expectedText) {

		Set<String> tabs = DriverFactory.getDriver().getWindowHandles();

		for (String tab : tabs) {

			DriverFactory.getDriver().switchTo().window(tab);

			String currentURL = DriverFactory.getDriver().getCurrentUrl();

			if (currentURL.contains(expectedText)) {
				return true;
			}
		}

		return false;
	}

	public void clickAddButton() {
		click(jp.addButton);
	}

	public void setPatient(String patient) {
		Actions action = (Actions) DriverFactory.getDriver();
		
		action.click(getElement(jp.patientName)).perform();
		action.moveToElement(getElement(jp.patientNameInput)).sendKeys(patient).build().perform();
	}
	
	

}
