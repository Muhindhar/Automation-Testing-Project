@Malavicka
Feature: V_MALAVICKA_2026_05_29_SmartHospital_Change_Language_Module

  As a hospital staff member
  I want to change the application language
  So that I can use the application in my preferred language

  Background:
    Given the user launches the application
    And the user is on the login page
    When the user clicks the "Doctor" button
    And clicks on the Login button
    Then the user should be navigated to the dashboard page

  Scenario: Change the application language to Hindi
    When the user clicks on the language option
    And the user selects "Hindi" from the list of available languages
    Then the application language should be changed to Hindi