package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IPDSearchPage {

    WebDriver driver;
    public IPDSearchPage(WebDriver driver) {
        this.driver = driver;
    }


    By ipdModule = By.xpath("//span[normalize-space()='IPD - In Patient']");

    By searchBox = By.xpath("//input[@placeholder='Search...']");

    public void clickIPDModule() {
        driver.findElement(ipdModule).click();
    }

    public void enterPatientName(String patientName) {

        driver.findElement(searchBox).clear();

        driver.findElement(searchBox).sendKeys(patientName);
    }
}