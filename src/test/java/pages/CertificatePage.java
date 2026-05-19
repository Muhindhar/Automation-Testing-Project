package pages;

import org.openqa.selenium.By;

public class CertificatePage {

    public By certificateMenu =
            By.xpath("//span[normalize-space()='Certificate']");

    public By certificateSubMenu =
            By.xpath("//a[contains(@href,'generatecertificate')]");

    public By moduleDropdown =
            By.id("module");

    public By patientStatusDropdown =
            By.id("patient_status");

    public By certificateTemplateDropdown =
            By.name("certificate_id");

    public By searchButton =
            By.xpath("//button[contains(.,'Search')]");

    public By generateButton =
            By.xpath("//button[contains(@title,'generate')]");
}