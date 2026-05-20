@Vigneshwaran
@UnderDevelopment
Feature: M_VIGNESHWARAN_2026_05_17_SmartHospital_Add_Consultation_Feature

  Background:
    Given the user launches the application
    And the user is on the login page
    When the user clicks the "Doctor" button
    And clicks on the Login button
    And clicks on the live consultation from the sidebar
    And clicks on the live consultation from the dropdown appeared

  Scenario: Add consultation with all valid fields
    And clicks on the add button
    When User enters consultation details for "Valid Consultation"
    And User clicks on Save button
    Then Consultation should be added successfully

  Scenario: Add consultation with mandatory fields only
    And clicks on the add button
    When User enters consultation details for "Mandatory Fields Consultation"
    And User clicks on Save button
    Then Consultation should be added successfully

  Scenario: Validate consultation creation with all empty fields
    And clicks on the add button
    When User enters consultation details for "Empty Consultation"
    And User clicks on Save button
    Then Validation message should be displayed for mandatory fields