package pages;

import org.openqa.selenium.By;

public class PrescriptionPage {

    public final By doctorTab    = By.xpath("//a[normalize-space()='Doctor']");
    public final By signInButton = By.xpath("//button[contains(normalize-space(),'Sign In')]");
    public final By ipdMenu = By.xpath("//span[normalize-space()='IPD - In Patient']");
    public final By patientSearchBox = By.xpath("//label//input[@type='search']");
    public final By prescriptionTab    = By.xpath("(//a[@href='#prescription'])[1]");
    public final By click128Tab        = By.xpath("//tr[@class='odd']//a[text() = 'IPDN128']");
    public final By prescriptionButton = By.xpath("//li//a[@href='#prescription']");
    public final By addprescbtn        = By.xpath("//a[text() = ' Add Prescription']");
    public final By getPrescriptionTable = By.xpath("//table[@id = 'DataTables_Table_2']");
    public final By headerNote = By.xpath(
            "//label[normalize-space()='Header Note']"
                    + "/ancestor::div[contains(@class,'form-group')]"
                    + "//iframe[contains(@class,'wysihtml5-sandbox')]");


    public final By footerNote = By.xpath(
            "//label[normalize-space()='Footer Note']"
                    + "/ancestor::div[contains(@class,'form-group')]"
                    + "//iframe[contains(@class,'wysihtml5-sandbox')]");

  
    public final By prescribeByDropdown = By.name("prescribe_by");
    public final By pathologyDropdown   = By.name("pathology[]");
    public final By radiologyDropdown   = By.name("radiology[]");
    public final By findingCategory = By.cssSelector("select.findingtype");
    public final By findings = By.xpath(
            "//select[contains(@class,'findingtype')]"
                    + "/ancestor::td/following-sibling::td[1]//input[@type='text']");

    public final By findingDescription = By.id("finding_description");
    public final By medicineCategoryDropdown = By.cssSelector("select[name='medicine_cat_1']");
    public final By medicineDropdown         = By.cssSelector("select[name='medicine_1']");
    public final By doseDropdown             = By.cssSelector("select[name='dosage_1']");
    public final By doseIntervalDropdown     = By.cssSelector("select[name='interval_dosage_1']");
    public final By doseDurationDropdown     = By.cssSelector("select[name='duration_dosage_1']");
    public final By instruction     = By.cssSelector("input[name='instruction_1'], textarea[name='instruction_1']");
    public final By attachmentInput = By.name("document");
    public final By footerNoteLabel = By.xpath("//label[normalize-space()='Footer Note']");
    public final By saveButton = By.xpath("//form[@id = 'form_prescription']//div[@class = 'pull-right']//button[@value = 'save']");
    public final By saveAndPrintButton = By.xpath("//button[@name = 'save_print']");
    public final By errormsg = By.xpath("//p[text() = 'Please select any one pathology, radiology or medicine details']");
    public final By getPrescriptionButtonDel = By.xpath("//td[@class='text-right']//a[@href='#prescription']");
    public final By editBtn = By.xpath("//div[@id='edit_deleteprescription']//a[@data-original-title='Edit']");
    public final By deleteBtn = By.xpath("//div[@id='edit_deleteprescription']//a[@data-original-title='Delete']");
    public final By confirmDeleteBtn = By.xpath(
    	    "//button[contains(text(),'Yes')] | " +
    	    "//button[contains(text(),'OK')] | " +
    	    "//button[contains(text(),'delete')] | " +
    	    "//button[contains(@class,'swal-button--confirm')] | " +
    	    "//button[contains(@class,'confirm')]"
    	);
    public final By deleteSuccessMessage = By.xpath("//*[contains(text(),'Record Deleted Successfully') or contains(text(),'Deleted Successfully')]");
    public final By updateSaveBtn = By.xpath("//form[@id='form_prescription']//button[@value='save']");

    public By patientByIPD(String ipdNumber) {
        return By.xpath("//a[contains(text(),'" + ipdNumber + "')]");
    }
    
    public final By dropdownOptions = By.tagName("option");

    public By ipdNumber(String ipdNumber) {
        return By.xpath(
            "//tr[@class='odd']//a[contains(text(),'IPDN" 
            + ipdNumber + "')]");
    }

    public final By frameBody = By.tagName("body");

    public final By prescriptionFirstRow = By.xpath(
        "//table[@id='DataTables_Table_2']" +
        "//tbody/tr[not(contains(@class,'dataTables_empty'))]"
    );
    public By findingOption(String value) {
        return By.xpath(
            "//label[contains(normalize-space(),'" + value + "')]" +
            "/preceding-sibling::input[@type='checkbox']" +
            " | //li[contains(normalize-space(),'" + value + "')]"
        );
    }
}