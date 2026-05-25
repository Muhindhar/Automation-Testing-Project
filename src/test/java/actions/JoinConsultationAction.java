package actions;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import pages.JoinConsultationPage;
import utilities.DriverFactory;
import utilities.HelperClass;

public class JoinConsultationAction extends BaseAction {

	JoinConsultationPage jp;

	public JoinConsultationAction(WebDriver driver) {
		super(driver);
		jp = new JoinConsultationPage();
	}

	public void clickLiveConsultationDropDown() {
		try {
			HelperClass.logger.info("Clicking live consultation dropdown");
			jsClick(jp.liveConsultation);
		} catch (Exception e) {
			HelperClass.logger.error("Failed to click live consultation dropdown: " + e.getMessage());
			throw e;
		}
	}

	public void clickLiveConsultationOption() {
		try {
			HelperClass.logger.info("Clicking live consultation option");
			jsClick(jp.liveConsultationOption);
		} catch (Exception e) {
			HelperClass.logger.error("Failed to click live consultation option: " + e.getMessage());
			throw e;
		}
	}

	public int findRecordWithStatus(String string) {
		try {
			int statusCount = getElements(jp.tableBody).size();

			for (int i = 1; i <= statusCount; i++) {

				Select select = new Select(getElement(jp.getStatusDropdown(i)));

				String status = select.getFirstSelectedOption().getText();

				if (status.equals(string)) {
					return i;
				}
			}

			return -1;

		} catch (Exception e) {
			HelperClass.logger.error("Failed to find record with status: " + e.getMessage());
			throw e;
		}
	}

	public boolean isActionPresent(int index) {
		try {
			if (index != -1)
				return getElements(jp.getActionButtons(index)).size() == 2;
			else
				return true;

		} catch (Exception e) {
			HelperClass.logger.error("Failed to verify action presence: " + e.getMessage());
			throw e;
		}
	}

	public boolean isActionClickable(int index) {
		try {
			return wait.until(
					ExpectedConditions.elementToBeClickable(
							getElements(jp.getActionButtons(index)).get(0))) != null;

		} catch (Exception e) {
			HelperClass.logger.error("Failed to verify action clickable: " + e.getMessage());
			throw e;
		}
	}

	public int findRecordNotWithStatus(String string) {
		try {
			int statusCount = getElements(jp.tableBody).size();

			for (int i = 1; i <= statusCount; i++) {

				Select select = new Select(getElement(jp.getStatusDropdown(i)));

				String status = select.getFirstSelectedOption().getText();

				if (!status.equals(string)) {
					return i;
				}
			}

			return -1;

		} catch (Exception e) {
			HelperClass.logger.error("Failed to find record not with status: " + e.getMessage());
			throw e;
		}
	}

	public boolean isActionNotPresent(int index) {
		try {
			if (index != -1)
				return getElements(jp.getActionButtons(index)).size() == 1;
			else
				return true;

		} catch (Exception e) {
			HelperClass.logger.error("Failed to verify action not present: " + e.getMessage());
			throw e;
		}
	}

	public void clickJoinButton(int index) {
		try {
			HelperClass.logger.info("Clicking join button");
			jsClickElement(getElements(jp.getActionButtons(index)).get(0));

		} catch (Exception e) {
			HelperClass.logger.error("Failed to click join button: " + e.getMessage());
			throw e;
		}
	}

	public boolean isPopUpDisplayed() {
		try {
			return wait.until(
					ExpectedConditions.visibilityOfElementLocated(jp.popUp))
					.isDisplayed();

		} catch (Exception e) {
			HelperClass.logger.error("Failed to verify popup displayed: " + e.getMessage());
			throw e;
		}
	}

	public boolean isStartNowButtonDisplayed() {
		try {
			return wait.until(
					ExpectedConditions.visibilityOfElementLocated(jp.startNow))
					.isDisplayed();

		} catch (Exception e) {
			HelperClass.logger.error("Failed to verify start now button displayed: " + e.getMessage());
			throw e;
		}
	}

	public void clickStartNowButton() {
		try {
			HelperClass.logger.info("Clicking start now button");
			click(jp.startNow);

		} catch (Exception e) {
			HelperClass.logger.error("Failed to click start now button: " + e.getMessage());
			throw e;
		}
	}

	public boolean isNewBrowserOpened() {
		try {
			return DriverFactory.getDriver().getWindowHandles().size() > 1;

		} catch (Exception e) {
			HelperClass.logger.error("Failed to verify new browser opened: " + e.getMessage());
			throw e;
		}
	}

	public boolean isURLContains(String expectedText) {

		try {

			Set<String> tabs = DriverFactory.getDriver().getWindowHandles();

			for (String tab : tabs) {

				DriverFactory.getDriver().switchTo().window(tab);

				String currentURL = DriverFactory.getDriver().getCurrentUrl();

				if (currentURL.contains(expectedText)) {
					return true;
				}
			}

			return false;

		} catch (Exception e) {
			HelperClass.logger.error("Failed to verify URL contains expected text: " + e.getMessage());
			throw e;
		}
	}

	public void clickAddButton() {
		try {
			HelperClass.logger.info("Clicking add button");
			click(jp.addButton);

		} catch (Exception e) {
			HelperClass.logger.error("Failed to click add button: " + e.getMessage());
			throw e;
		}
	}

	public void setPatient(String patient) {

	    try {

	        HelperClass.logger.info("Setting patient name");

	        Actions actions = new Actions(DriverFactory.getDriver());

	        WebElement dropdown = getElement(jp.patientName);

	        WebElement input = getElement(jp.patientNameInput);

	        actions.moveToElement(dropdown)
	               .click()
	               .pause(Duration.ofSeconds(1))
	               .moveToElement(input)
	               .click()
	               .sendKeys(patient)
	               .pause(Duration.ofSeconds(1))
	               .sendKeys(Keys.ENTER)
	               .build()
	               .perform();

	    } catch (Exception e) {

	        HelperClass.logger.error(
	                "Failed to set patient: "
	                + e.getMessage());

	        throw e;
	    }
	}

	public void setDescription(String description) {

		try {

			HelperClass.logger.info("Setting description");


		} catch (Exception e) {
			HelperClass.logger.error("Failed to set description: " + e.getMessage());
			throw e;
		}
	}

	public void setClientVideo(String clientVideo) {

		try {

			HelperClass.logger.info("Setting client video");


		} catch (Exception e) {
			HelperClass.logger.error("Failed to set client video: " + e.getMessage());
			throw e;
		}
	}

	public void setHostVideo(String hostVideo) {

		try {

			HelperClass.logger.info("Setting host video");

			

		} catch (Exception e) {
			HelperClass.logger.error("Failed to set host video: " + e.getMessage());
			throw e;
		}
	}

	public void setConsultantDoctor(String consultantDoctor) {

		try {

			HelperClass.logger.info("Setting consultant doctor");

			

		} catch (Exception e) {
			HelperClass.logger.error("Failed to set consultant doctor: " + e.getMessage());
			throw e;
		}
	}

	public void setOpdIpdNo(String opdIpdNo) {

		try {

			HelperClass.logger.info("Setting OPD/IPD number");

			

		} catch (Exception e) {
			HelperClass.logger.error("Failed to set OPD/IPD number: " + e.getMessage());
			throw e;
		}
	}

	public void setConsultationTitle(String consultationTitle) {

		try {

			HelperClass.logger.info("Setting consultation title");

			

		} catch (Exception e) {
			HelperClass.logger.error("Failed to set consultation title: " + e.getMessage());
			throw e;
		}
	}

	public void setConsultationDate(String consultationDate) {

		try {

			HelperClass.logger.info("Setting consultation date");

			

		} catch (Exception e) {
			HelperClass.logger.error("Failed to set consultation date: " + e.getMessage());
			throw e;
		}
	}

	public void setDuration(String duration) {

		try {

			HelperClass.logger.info("Setting duration");

			

		} catch (Exception e) {
			HelperClass.logger.error("Failed to set duration: " + e.getMessage());
			throw e;
		}
	}

	public void setOpdOrIpd(String opdOrIpd) {

		try {

			HelperClass.logger.info("Setting OPD or IPD");

			

		} catch (Exception e) {
			HelperClass.logger.error("Failed to set OPD/IPD: " + e.getMessage());
			throw e;
		}
	}
	
	public void clickAddCredentialButton() {

	    click(jp.addCredentialButton);
	}

	public void enterZoomApiKey(String apiKey) {

	    sendKeys(jp.zoomApiKeyField, apiKey);
	}

	public void enterZoomApiSecret(String apiSecret) {

	    sendKeys(jp.zoomApiSecretField, apiSecret);
	}

	public void clickSaveCredentialButton() {

	    click(jp.saveCredentialButton);
	}

	public String getToastMessage() {

	    return getText(jp.successToastMessage);
	}
	
	public String getZoomApiKeyValue() {

	    return getElement(jp.zoomApiKeyField)
	            .getAttribute("value");
	}

	public String getZoomApiSecretValue() {

	    return getElement(jp.zoomApiSecretField)
	            .getAttribute("value");
	}
	
	public void clearCredentialFields() {

	    WebElement apiKey =
	            getElement(jp.zoomApiKeyField);

	    WebElement apiSecret =
	            getElement(jp.zoomApiSecretField);

	    apiKey.sendKeys(Keys.CONTROL + "a");
	    apiKey.sendKeys(Keys.DELETE);
	    apiKey.sendKeys(Keys.TAB);

	    apiSecret.sendKeys(Keys.CONTROL + "a");
	    apiSecret.sendKeys(Keys.DELETE);
	    apiSecret.sendKeys(Keys.TAB);
	}

	public void clickSaveButton() {
		click(jp.saveConsultationButton);
	}

}