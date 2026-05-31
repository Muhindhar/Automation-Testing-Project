@Malavicka
Feature: V_MALAVICKA_2026_05_29_SmartHospital_IPD_PDF_Download_Module

  As a hospital staff member
  I want to download IPD patient details in PDF format
  So that I can store and review inpatient records offline

  Background:
    Given the user launches the application
    And the user is on the login page
    When the user clicks the "Doctor" button
    And clicks on the Login button
    Then the user should be navigated to the dashboard page

  Scenario: Download IPD patient details in PDF format
    When the user clicks on the "IPD - In Patient" module
    And the user clicks on the PDF download button
    Then the IPD patient details should be downloaded in PDF format