package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.DriverFactory;

public class IPDPdfDownloadPage {

    public IPDPdfDownloadPage() {

        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    @FindBy(xpath = "//span[normalize-space()='IPD - In Patient']")
    private WebElement ipdMenu;

    @FindBy(xpath = "//i[@class='fa fa-file-pdf-o']")
    private WebElement pdfButton;

    public WebElement getIpdMenu() {

        return ipdMenu;
    }

    public WebElement getPdfButton() {

        return pdfButton;
    }
}
