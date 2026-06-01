@Malavicka
@UnderDevelopment
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
  And the user selects the patient certificate submenu

  Scenario: Generate patient certificate PDF using valid details
    And the user selects module as "IPD"
    And the user selects valid patient status
    And the user selects certificate template
    And the user clicks on "Search" button
    And the system displays a list of patients
    And the user selects the first patient from the list
    And the user clicks on "PDF" button
    Then the system should generate the certificate PDF
    And the PDF should be downloaded successfully

  Scenario: Handle certificate generation with invalid or missing details
    And the user selects module as "IPD"
    And the user selects invalid or empty patient status
    And the user selects certificate template
    And the user clicks on "Search" button
    Then the system should display "No records found" message
    And the patient list should not be displayed
    And the "PDF" button should not be enabled or should not work
