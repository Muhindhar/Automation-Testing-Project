Feature: S_MYTHILY_2026_05_18_SmartHospital_Delete Prescription Validation

  Background:
    Given the user launches the application
    And the user is on the login page
    When the user clicks the "Doctor" button
    And clicks on the Login button
    Then the user should be redirected to the dashboard
    When clicks the IPD -In Patient menu
    And searches patient by IPD Number "128"
    Then only patient "128" IPD should be displayed
    When clicks the IPD Number "128"
    And clicks on Prescription

  @DeletePrescription
  Scenario: Delete prescription from View Prescription

    And clicks on View Prescription
    And clicks on Delete
    Then a confirmation popup should be displayed
    When the user confirms deletion
    Then the prescription should be deleted successfully