package pages;

import org.openqa.selenium.By;

public class PrescriptionPage {

    //LOGIN

    public By username = By.id("email");
    public By password = By.id("password");
    public By signInButton = By.xpath("//button[contains(text(),'Sign In')]");

    //DASHBOARD / MENU

    public By ipdMenu = By.xpath("//span[contains(text(),'IPD')]");

    // Show button of patient
    public By showPatientButton = By.xpath("(//a[contains(text(),'Show')])[1]");

    //PRESCRIPTION TAB

    public By prescriptionTab = By.xpath("//a[contains(@href,'#prescription')]");

    public By addPrescriptionButton = By.xpath("//button[contains(text(),'Add Prescription')]");

    //ADD PRESCRIPTION FORM

    // Header Note textbox
    public By headerNoteFrame = By.xpath("(//div[contains(@class,'note-editable')])[1]");
    
    // Prescribe By dropdown
    public By prescribeByDropdown = By.xpath("//label[contains(text(),'Prescribe By')]/following::select[1]");
    
    // Pathology dropdown
    public By pathologyDropdown = By.xpath("//label[contains(text(),'Pathology')]/following::select[1]");
    
    // Radiology dropdown
    public By radiologyDropdown = By.xpath("//label[contains(text(),'Radiology')]/following::select[1]");
    
    // Finding Category
    public By findingCategory = By.xpath("//label[contains(text(),'Finding Category')]/following::input[1]");
    
    // Findings
    public By findings = By.xpath("//label[contains(text(),'Findings')]/following::input[1]");
    
    // Finding Description
    public By findingDescription = By.xpath("//label[contains(text(),'Finding Description')]/following::textarea[1]");
    
    // Medicine Category dropdown
    public By medicineCategory = By.xpath("//label[contains(text(),'Medicine Category')]/following::select[1]");

    // Medicine dropdown
    public By medicine = By.xpath("//label[contains(text(),'Medicine')]/following::select[1]");

    // Dose dropdown
    public By dose = By.xpath("//label[contains(text(),'Dose')]/following::select[1]");

    // Dose Interval
    public By doseInterval = By.xpath("//label[contains(text(),'Dose Interval')]/following::select[1]");

    // Dose Duration
    public By doseDuration = By.xpath("//label[contains(text(),'Dose Duration')]/following::select[1]");

    // Instruction textbox
    public By instruction = By.xpath("//label[contains(text(),'Instruction')]/following::input[1]");

    // Add Medicine button
    public By addMedicineButton = By.xpath("//button[contains(text(),'Add Medicine')]");

    // Attachment upload
    public By attachmentUpload = By.xpath("//input[@type='file']");

    // Footer Note
    public By footerNote = By.xpath("(//div[contains(@class,'note-editable')])[2]");

    //FOR BUTTONS

    public By saveButton = By.xpath("//button[contains(text(),'Save')]");

    public By saveAndPrintButton = By.xpath("//button[contains(text(),'Save & Print')]");

    //VIEW PRESCRIPTION

    public By viewPrescriptionButton = By.xpath("(//button[contains(text(),'View Prescription')])[1]");

    public By printButton = By.xpath("//button[contains(text(),'Print')]");

    public By editButton = By.xpath("//button[contains(text(),'Edit')]");

    public By deleteButton = By.xpath("//button[contains(text(),'Delete')]");

    //POPUP

    public By confirmDeletePopup = By.xpath("//*[contains(text(),'Are you sure')]");

    public By confirmDeleteYes = By.xpath("//button[contains(text(),'OK') or contains(text(),'Yes')]");

    public By successPopup = By.xpath("//*[contains(text(),'Successfully')]");

    public By validationMessage = By.xpath("//*[contains(@class,'error') or contains(@class,'invalid-feedback')]");
}