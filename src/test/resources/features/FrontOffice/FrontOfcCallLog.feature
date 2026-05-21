@Muhindhar
Feature: Muhindhar_16-05-2026_To check the call log in the front office module
Description: As a receptionist user i want to add call logs and see all the call logs

  Background:
    Given the user launches the application
    And the user is on the login page
    When the user clicks the "Receptionist" button
    And clicks on the Login button
    And user navigates to the front office link

  @Addcall
  Scenario: add outgoing call log
    And user clicks on phone call log link
    And user click on add call log link
    When user enters following details
      | name      | phone      | description  | calltype | note   | call duration |
      | muhindhar | 9876543254 | emergency    | Outgoing | simply | 1:02          |
      | user      | 9833543254 | family       | Incoming | error  | 3:03          |
      | admin     | 9876543265 | friends      | Outgoing | random | 00:45         |
      | vignesh   | 9876543765 | conversation | Incoming | simple | 11:22         |
    And click save button
    Then user should be able to see in the call log list

  @EmptyCallLog
  Scenario: Validate mandatory field error messages
    And user clicks on Phone Call Log link in site
    And user clicks the  Add Call Log link
    And user leaves mandatory fields empty
    And user clicks on Save button
    Then validation error message should be displayed
