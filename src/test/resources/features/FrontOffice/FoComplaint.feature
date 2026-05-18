Feature: Muhindhar_16-05-2026_Add a complaint in the front office page
  Description:To add complaints with different complaint types and different sources using excel data.

  Background:
    Given user is on login page of site
    And user clicks on receptionist button
    And click signin button
    And user navigates to the front office link

  @DifferentComplaints
  Scenario: Add complaint using excel data
    And clicks on the complaint link
    And click on the add complaint
    When user enters the complaint details from excel
    And click save button in the site
    Then user should be able to see the complaints
