package actions;

import org.openqa.selenium.WebDriver;

import pages.IPDPdfDownloadPage;
import utilities.DriverFactory;

public class IPDPdfDownloadAction extends BaseAction {

    WebDriver driver;
    IPDPdfDownloadPage ipdPage;

    public IPDPdfDownloadAction() {

        super(DriverFactory.getDriver());

        this.driver = DriverFactory.getDriver();

        ipdPage = new IPDPdfDownloadPage();
    }

    public void clickIPDMenu() {

        clickfb(ipdPage.getIpdMenu());
    }

    public void clickPdfButton() {

        clickfb(ipdPage.getPdfButton());
    }
}
