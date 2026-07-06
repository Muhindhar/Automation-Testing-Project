@Muhindhar
Feature: Muhindhar_04-06-2026_Postal Feature in the Front Office Module
  Description:
  As a receptionist user, I want to dispatch and receive postal records.

  Background:
    Given the user launches the application
    And the user is on the login page
    When the user clicks the "Receptionist" button
    And clicks on the Login button
    And user navigates to the front office link

  @DispatchPostal
  Scenario: Dispatch postal record
    And user clicks on the postal button
    And user clicks on the dispatch button
    And clicks the add dispatch button
    And enters the postal details
    And clicks the save button in the site
    Then user should be able to see their postal details
