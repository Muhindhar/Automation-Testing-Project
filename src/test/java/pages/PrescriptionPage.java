package pages;

import org.openqa.selenium.By;

public class PrescriptionPage {

    // ── Admin/Doctor Login Page ──────────────────────────────────────────────
    public By doctorTab    = By.xpath("//a[normalize-space()='Doctor']");
    public By signInButton = By.xpath("//button[contains(normalize-space(),'Sign In')]");

    // ── IPD Menu ──────────────────────────────────────────────────────────────
    public By ipdMenu = By.xpath("//span[normalize-space()='IPD - In Patient']");

    // ── IPD Patient List ──────────────────────────────────────────────────────
    public By patientSearchBox = By.xpath("//input[@type='search']");

    // ── IPD Patient Detail Tabs ───────────────────────────────────────────────
    public By prescriptionTab = By.xpath(
            "//a[normalize-space()='Prescription'"
                    + " or .//span[normalize-space()='Prescription']]");

    public By addPrescriptionButton = By.xpath(
            "//a[@class='btn btn-sm btn-primary dropdown-toggle addprescription']");

    // ── Wysihtml5 Rich Text Editors ───────────────────────────────────────────
    public By headerNote =
            By.xpath("(//iframe[contains(@class,'wysihtml5-sandbox')])[1]");

    public By footerNote =
            By.xpath("(//iframe[contains(@class,'wysihtml5-sandbox')])[2]");

    // ── Prescribe By, Pathology, Radiology ───────────────────────────────────
    public By prescribeByDropdown = By.name("prescribe_by");
    public By pathologyDropdown   = By.name("pathology[]");
    public By radiologyDropdown   = By.name("radiology[]");

    // ── Finding Fields ────────────────────────────────────────────────────────
    // Finding Category and Findings have NO id/name/placeholder.
    // Screenshot showed index [1] lands on Findings, so Category is [2], Findings is [3].
 // Finding Category — anchored to its own column header
 // Finding Category — hidden <select> with class 'findingtype'
    public By findingCategory = By.xpath(
            "//select[contains(@class,'findingtype')]");
    
 // Findings — plain text input in the td next to Finding Category td
    public By findings = By.xpath(
            "//select[contains(@class,'findingtype')]"
            + "/ancestor::td/following-sibling::td[1]//input[@type='text'] | "
            + "//select[contains(@class,'findingtype')]"
            + "/ancestor::td/following-sibling::td[1]//input");

    // Finding Description — confirmed id from earlier console: finding_description
    public By findingDescription = By.id("finding_description");

 // Target the ADD medicine row specifically (first occurrence in the add form)
 // Replace these four locators:
    public By medicineCategoryDropdown = By.cssSelector("select[name='medicine_cat_1']");
    public By medicineDropdown = By.cssSelector("select[name='medicine_1']");
    public By doseDropdown     = By.cssSelector("select[name='dosage_1']");
    public By doseIntervalDropdown     = By.cssSelector("select[name='interval_dosage_1']");
    public By doseDurationDropdown     = By.cssSelector("select[name='duration_dosage_1']");
    // ── Other Form Fields ─────────────────────────────────────────────────────
    public By instruction     = By.name("instruction_1");
    public By attachmentInput = By.name("document");


    public By saveButton =
            By.xpath("//button[normalize-space()='Save' and not(contains(text(),'Print'))]");
    
    // ── Verification ───────────────────────────────────────────────────────────
    public By prescriptionSuccessMessage =
            By.xpath("//*[contains(text(),'Record Saved Successfully') or contains(text(),'Prescription added successfully')]");

    public By prescriptionRow =
            By.xpath("//table//tbody/tr");

}