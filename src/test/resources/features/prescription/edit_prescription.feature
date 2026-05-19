@Mythily
Feature: S_MYTHILY_2026_05_14_SmartHospital_Edit Prescription Validation

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

  @EditPrescription
  Scenario: Edit existing prescription

    And clicks on View Prescription
    And clicks on Edit
    And updates prescription details
    And clicks on Save
    Then the prescription should be updated successfully