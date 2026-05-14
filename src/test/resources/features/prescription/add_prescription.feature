Feature: S_MYTHILY_2026_05_14_SmartHospital_Add Prescription Validation

  Background:
    Given the doctor user is on the login page
    When the user enters valid doctor credentials
    And clicks on Login
    Then the doctor dashboard should be displayed


  @ValidPrescriptionSave
  Scenario Outline: Add prescription with valid details and click Save

    When the user navigates to IPD
    And clicks Show for a specific patient
    And clicks on Prescription
    And clicks on Add Prescription
    And enters header note "<headerNote>"
    And selects prescribe by "<prescribeBy>"
    And selects pathology "<pathology>"
    And selects radiology "<radiology>"
    And enters finding category "<findingCategory>"
    And enters findings "<findings>"
    And enters finding description "<findingDescription>"
    And selects medicine category "<medicineCategory>"
    And selects medicine "<medicine>"
    And selects dose "<dose>"
    And selects dose interval "<doseInterval>"
    And selects dose duration "<doseDuration>"
    And enters instruction "<instruction>"
    And uploads attachment "<attachmentPath>"
    And enters footer note "<footerNote>"
    And clicks on Save
    Then the prescription should be saved successfully
    And the prescription should appear in the prescription list

    Examples:
      | headerNote                                                                                      | prescribeBy     | pathology                  | radiology          | findingCategory | findings                            | findingDescription                            | medicineCategory | medicine    | dose  | doseInterval  | doseDuration | instruction      | attachmentPath                      | footerNote                                                |
      | Patient complains of fever, cough, and body pain for the past 3 days. Patient condition stable. | Amit Singh(9009)| (vitamin) Vitamin B12 Test | (X-RAY) X-Ray Chest| Fever           | Elevated temperature (above 100.4°) | Mild fever with cough and body pain symptoms. | Tablet           | Paracetamol | 1 KHz | Morning       | 1 Week       | Take after food  | src/test/resources/files/report.pdf | Drink plenty of water and continue medication for 5 days. |


  @ValidPrescriptionSaveAndPrint
  Scenario Outline: Add prescription with valid details and click Save And Print

    When the user navigates to IPD
    And clicks Show for a specific patient
    And clicks on Prescription
    And clicks on Add Prescription
    And enters header note "<headerNote>"
    And selects prescribe by "<prescribeBy>"
    And selects pathology "<pathology>"
    And selects radiology "<radiology>"
    And enters finding category "<findingCategory>"
    And enters findings "<findings>"
    And enters finding description "<findingDescription>"
    And selects medicine category "<medicineCategory>"
    And selects medicine "<medicine>"
    And selects dose "<dose>"
    And selects dose interval "<doseInterval>"
    And selects dose duration "<doseDuration>"
    And enters instruction "<instruction>"
    And uploads attachment "<attachmentPath>"
    And enters footer note "<footerNote>"
    And clicks on Save And Print
    Then the prescription should be saved successfully
    And the prescription print preview should be displayed

    Examples:
      | headerNote                                                                                      | prescribeBy     | pathology                  | radiology          | findingCategory | findings                            | findingDescription                            | medicineCategory | medicine    | dose  | doseInterval  | doseDuration | instruction      | attachmentPath                      | footerNote                                                |
      | Patient complains of fever, cough, and body pain for the past 3 days. Patient condition stable. | Amit Singh(9009)| (vitamin) Vitamin B12 Test | (X-RAY) X-Ray Chest| Fever           | Elevated temperature (above 100.4°) | Mild fever with cough and body pain symptoms. | Tablet           | Paracetamol | 1 KHz | Morning       | 1 Week       | Take after food  | src/test/resources/files/report.pdf | Drink plenty of water and continue medication for 5 days. |


  @PartialFillValidation
  Scenario Outline: Add prescription with partially filled details and click Save

    When the user navigates to IPD
    And clicks Show for a specific patient
    And clicks on Prescription
    And clicks on Add Prescription
    And enters header note "<headerNote>"
    And selects prescribe by "<prescribeBy>"
    And clicks on Save
    Then validation messages should be displayed
    And the prescription should not be saved

    Examples:
      | headerNote                                   | prescribeBy    |
      | Patient suffering from mild fever and cough. |Amit Singh(9009)|


  @EmptyPrescriptionValidation
  Scenario: Add prescription with empty credentials and click Save

    When the user navigates to IPD
    And clicks Show for a specific patient
    And clicks on Prescription
    And clicks on Add Prescription
    And clicks on Save
    Then validation messages should be displayed
    And the prescription should not be saved