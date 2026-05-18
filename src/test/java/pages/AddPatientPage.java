package pages;

import org.openqa.selenium.By;

public class AddPatientPage {

    public static By inPatientMenu =
            By.xpath("//span[normalize-space()='IPD - In Patient']");

    public static By addPatientButton =
            By.xpath("//a[@id='addp']");

    public static By newPatientButton =
            By.xpath("//span[normalize-space()='New Patient']");

    public static By patientName =
            By.xpath("//input[@id='name']");

    public static By guardianName =
            By.xpath("//div[@class='col-lg-6 col-md-6 col-sm-6']//input[@name='guardian_name']");

    public static By genderDropdown =
            By.xpath("//select[@id='addformgender']");

    public static By dobField =
            By.xpath("//input[@id='birth_date']");

    public static By phoneField =
            By.xpath("//input[@id='number']");

    public static By emailField =
            By.xpath("//input[@id='addformemail']");

    public static By addressField =
            By.xpath("//input[@name='address']");

    public static By saveButton =
            By.xpath("//button[@id='formaddpabtn']");

    public static By successMessage =
            By.xpath("//div[@class='toast-message']");
    public static By validationMessage =
            By.xpath("//div[@class='toast toast-error']");

}