@Mythily
Feature: S_MYTHILY_2026_05_14_SmartHospital_Print Prescription Validation

  Background:
    Given the doctor user is on the login page
    When the user selects Doctor login
    And clicks on Login
    Then the doctor dashboard should be displayed


  @PrintPrescription
  Scenario: Print prescription from View Prescription

    When the user navigates to IPD
    And clicks Show for a specific patient
    And clicks on Prescription
    And clicks on View Prescription
    And clicks on Print
    Then the prescription print preview should be displayed