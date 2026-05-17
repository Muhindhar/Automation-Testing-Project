Feature: S_MYTHILY_2026_05_14_SmartHospital_Edit Prescription Validation

  Background:
    Given the doctor user is on the login page
    When the user selects Doctor login
    And clicks on Login
    Then the doctor dashboard should be displayed


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