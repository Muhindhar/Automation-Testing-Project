Feature: Prescription Module Validation

  Background:
    Given the doctor user is on the login page
    When the user enters valid doctor credentials
    And clicks on Login
    Then the doctor dashboard should be displayed


  @ValidPrescription
  Scenario: Add prescription with valid details

    When the user navigates to IPD
    And clicks Show for a specific patient
    And clicks on Prescription
    And clicks on Add Prescription
    And enters all valid prescription details
    And clicks on Save
    Then the prescription should be added successfully
    And a success popup message should be displayed


  @PartialFillValidation
  Scenario: Add prescription with partial details

    When the user navigates to IPD
    And clicks Show for a specific patient
    And clicks on Prescription
    And clicks on Add Prescription
    And enters partial prescription details
    And leaves mandatory fields empty
    And clicks on Save
    Then validation error messages should be displayed
    And the prescription should not be saved


  @EmptyPrescriptionValidation
  Scenario: Add prescription without entering any details

    When the user navigates to IPD
    And clicks Show for a specific patient
    And clicks on Prescription
    And clicks on Add Prescription
    And clicks on Save without entering any prescription details
    Then validation messages should be displayed
    And the prescription should not be saved


  @SavePrescription
  Scenario: Save prescription successfully

    When the user navigates to IPD
    And clicks Show for a specific patient
    And clicks on Prescription
    And clicks on Add Prescription
    And fills valid prescription details
    And clicks on Save
    Then the prescription should be saved successfully
    And the prescription should appear in the prescription list


  @SaveAndPrintPrescription
  Scenario: Save and print prescription successfully

    When the user navigates to IPD
    And clicks Show for a specific patient
    And clicks on Prescription
    And clicks on Add Prescription
    And fills valid prescription details
    And clicks on Save And Print
    Then the prescription should be saved successfully
    And the prescription print preview should be displayed


  @PrintPrescription
  Scenario: Print existing prescription

    When the user navigates to IPD
    And clicks Show for a specific patient
    And clicks on Prescription
    And clicks on View Prescription
    And clicks on Print
    Then the prescription print preview should be displayed


  @EditPrescription
  Scenario: Edit existing prescription

    When the user navigates to IPD
    And clicks Show for a specific patient
    And clicks on Prescription
    And clicks on View Prescription
    And clicks on Edit
    And updates prescription details
    And clicks on Save
    Then the prescription should be updated successfully


  @DeletePrescription
  Scenario: Delete existing prescription

    When the user navigates to IPD
    And clicks Show for a specific patient
    And clicks on Prescription
    And clicks on View Prescription
    And clicks on Delete
    Then a confirmation popup should be displayed
    When the user confirms deletion
    Then the prescription should be deleted successfully