@Vigneshwaran
@Bug
Feature: M_VIGNESHWARAN_2026_05_17_SmartHospital_Add_Credential_In_Consultation_Feature

  Background:
    Given the user launches the application
    And the user is on the login page
    When the user clicks the "Doctor" button
    And clicks on the Login button
    And clicks on the live consultation from the sidebar
    And clicks on the live consultation from the dropdown appeared

  @ValidCredential
  Scenario: Verify user can add zoom credentials with valid data
    When clicks on the add credential button
    And enters the following credential details:
      | zoomApiKey | zoomApiSecret |
      | Key001     | Secret001     |
    And clicks on the save credential button
    Then the credential should be saved successfully

  @Bug @InvalidCredential
  Scenario Outline: Verify validation message when mandatory credential fields are missing
    When clicks on the add credential button
    And enters invalid credential data for "<testCase>"
    And clicks on the save credential button
    Then the validation error message should be displayed

    Examples:
      | testCase          |
      | Empty Api Key     |
      | Empty Api Secret  |
      | Empty Both Fields |
