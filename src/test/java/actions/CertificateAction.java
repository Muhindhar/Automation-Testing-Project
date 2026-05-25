package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import pages.CertificatePage;
import utilities.ExcelUtility;

public class CertificateAction extends BaseAction {

    CertificatePage certificatePage;

    String filePath =
            System.getProperty("user.dir")
            + "/src/test/resources/testdata/CertificateData.xlsx";

    public CertificateAction(WebDriver driver) {
        super(driver);
        this.certificatePage = new CertificatePage(); 
    }

    public void clickCertificateMenu() {
        try {
            click(certificatePage.certificateMenu);
        } catch (Exception e) {
            System.out.println("Unable to click Certificate menu");
            e.printStackTrace();
        }
    }

    public void clickCertificateSubMenu() {
        try {
            click(certificatePage.certificateSubMenu);
        } catch (Exception e) {
            System.out.println("Unable to click Certificate submenu");
            e.printStackTrace();
        }
    }

    public void selectValidCertificateDetails() {
        try {
            String module   = ExcelUtility.getCellData(filePath, "Sheet1", 1, 0);
            String status   = ExcelUtility.getCellData(filePath, "Sheet1", 1, 1);
            String template = ExcelUtility.getCellData(filePath, "Sheet1", 1, 2);

            Select moduleDD = new Select(waitForVisibility(certificatePage.moduleDropdown));
            moduleDD.selectByVisibleText(module);

            Select statusDD = new Select(waitForVisibility(certificatePage.patientStatusDropdown));
            statusDD.selectByVisibleText(status);

            Select templateDD = new Select(waitForVisibility(certificatePage.certificateTemplateDropdown));
            templateDD.selectByVisibleText(template);

        } catch (Exception e) {
            System.out.println("Error selecting VALID certificate details");
            e.printStackTrace();
        }
    }

    public void selectInvalidCertificateDetails() {
        try {
            String module   = ExcelUtility.getCellData(filePath, "Sheet1", 2, 0);
            String status   = ExcelUtility.getCellData(filePath, "Sheet1", 2, 1);
            String template = ExcelUtility.getCellData(filePath, "Sheet1", 2, 2);

            Select moduleDD = new Select(waitForVisibility(certificatePage.moduleDropdown));
            moduleDD.selectByVisibleText(module);

            Select statusDD = new Select(waitForVisibility(certificatePage.patientStatusDropdown));
            statusDD.selectByVisibleText(status);

            Select templateDD = new Select(waitForVisibility(certificatePage.certificateTemplateDropdown));
            templateDD.selectByVisibleText(template);

        } catch (Exception e) {
            System.out.println("Error selecting INVALID certificate details");
            e.printStackTrace();
        }
    }

    public void clickSearchButton() {
        try {
            click(certificatePage.searchButton);
        } catch (Exception e) {
            System.out.println("Unable to click Search button");
            e.printStackTrace();
        }
    }

    public void selectPatient() {
        try {
            String patientName = ExcelUtility.getCellData(filePath, "Sheet1", 1, 3);

            By patient = By.xpath(
                "//tr[td[contains(normalize-space(),'" + patientName + "')]]//input[@type='checkbox']"
            );

            click(patient);

        } catch (Exception e) {
            System.out.println("Unable to select patient");
            e.printStackTrace();
        }
    }

    public void clickGenerateButton() {
        try {
            click(certificatePage.generateButton);
        } catch (Exception e) {
            System.out.println("Unable to click Generate button");
            e.printStackTrace();
        }
    }

    public void closePatientDetailsPage() {
        try {
            By closeBtn = By.xpath(
                "//button[contains(text(),'Cancel') or contains(text(),'Close')]"
            );
            click(closeBtn); 
            System.out.println("Popup closed successfully");
        } catch (Exception e) {
            System.out.println("Error while closing popup");
            e.printStackTrace();
        }
    }
}