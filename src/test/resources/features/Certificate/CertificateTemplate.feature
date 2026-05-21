@Malavicka
Feature: V_MALAVICKA_2026_05_14_Generate patient certificate in IPD module

  As a doctor
  I want to generate patient certificates
  So that I can verify patient certificate details

  Background:
    Given the user launches the application
    And the user is on the login page
    When the user clicks the "Doctor" button
    And clicks on the Login button
    Then the user should be redirected to the dashboard
    When the user clicks on the "Certificate" menu
    And the user selects the "Certificate" submenu

  Scenario: Generate patient certificate using valid details
    When the user selects module from excel data
    And the user selects patient status from excel data
    And the user selects certificate template from excel data
    And the user clicks on the Search button
    Then the system should display the matching patient records
    When the user selects the patient from excel data
    And the user clicks on the Generate button
    Then the patient certificate details should be displayed successfully
    Then the certificate popup should be closed successfully

  Scenario: Generate patient certificate using invalid details
    When the user selects invalid module from excel data
    And the user selects invalid patient status from excel data
    And the user selects invalid certificate template from excel data
    And the user clicks on the Search button
    Then the system should display no matching patient records
    And the user should see an appropriate validation or empty result message