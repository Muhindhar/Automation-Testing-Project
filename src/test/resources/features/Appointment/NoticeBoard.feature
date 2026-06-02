@Muhindhar
Feature: Muhindhar_01-06-2026_Checking whether the notice board is visible to particular user
Description: As a receptionist user the Notice board should be visible to the receptionist user

  Background:
    Given the user is on the login page
    And user clicks on receptionist button
    And user clicks on signin button
    And user navigates to dashboard section

  @noticeboard
  Scenario: Visiblity of notices
    And user clicks on the notice displayed
    Then user should be able to see the list of notices 
    
    
