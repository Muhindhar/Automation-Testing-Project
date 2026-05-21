@Mythily
Feature: S_MYTHILY_2026_05_14_SmartHospital_Edit Prescription Validation

  Background:
    Given the user launches the application
    And the user is on the login page
    When the user clicks the "Doctor" button
    And clicks on the Login button
    Then the user should be redirected to the dashboard
    When clicks the IPD -In Patient menu
    And searches patient by IPD Number
    Then only patient with that IPD should be displayed
    When clicks that IPD Number
    And clicks on Prescription

  @EditPrescription
  Scenario: Edit existing prescription

    And clicks on View Prescription
    And clicks on Edit
    And updates the prescription details
    And clicks on Save
    Then the prescription should be updated successfully