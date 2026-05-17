Feature: S_MYTHILY_2026_05_14_SmartHospital_Delete Prescription Validation

  Background:
    Given the doctor user is on the login page
    When the user selects Doctor login
    And clicks on Login
    Then the doctor dashboard should be displayed


  @DeletePrescription
  Scenario: Delete prescription from View Prescription

    When the user navigates to IPD
    And clicks Show for a specific patient
    And clicks on Prescription
    And clicks on View Prescription
    And clicks on Delete
    Then a confirmation popup should be displayed

    When the user confirms deletion
    Then the prescription should be deleted successfully