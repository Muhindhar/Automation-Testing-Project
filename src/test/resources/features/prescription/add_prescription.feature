Feature: S_MYTHILY_2026_05_14_SmartHospital_Add Prescription Validation
  Background:
    Given the user launches the application
    And the user is on the login page
    When the user clicks the "Doctor" button
    And clicks on the Login button
    Then the user should be redirected to the dashboard

  @ValidPrescriptionSave
  Scenario: Add prescription with valid details and click Save

    When clicks the IPD -In Patient menu
    And searches patient by IPD Number "128"
    Then only patient "128" IPD should be displayed
    When clicks the IPD Number "128"
    And clicks on Prescription
    And clicks on Add Prescription
    And enters prescription details
      | headerNote                                                                                      | prescribeBy      | pathology                  | radiology           | findingCategory | findings                            | findingDescription                            | medicineCategory | medicine            | dose    | doseInterval   | doseDuration | instruction     | attachmentPath                      | footerNote                                                |
      | Patient complains of fever, cough, and body pain for the past 3 days. Patient condition stable. | Amit Singh(9009) | (vitamin) Vitamin B12 Test | (X-RAY) X-Ray Chest | Fever           | Elevated temperature (above 100.4°) | Mild fever with cough and body pain symptoms. | Tablet           | AUSTELL-PARACETAMOL | 1/2 HVL | Only one a day | 1 Week        | Take after food | src/test/resources/files/report.pdf | Drink plenty of water and continue medication for 5 days. |
    And clicks on Save
    Then the prescription should be saved successfully
    And the prescription should appear in the prescription list