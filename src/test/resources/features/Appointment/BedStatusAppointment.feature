@Muhindhar
Feature: Muhindhar_27-05-2026_Checking the status of bed as a receptionist
  Description:
  As a receptionist user I need to check the availability of the bed

  Background:
    Given the user is on the login page
    And user clicks on receptionist button
    And user clicks on signin button
    And user navigates to Appointment section

  @Bedstatus
  Scenario: Validate patient details from bed status
    When user clicks on the bed status
    And user clicks on the room
    Then user is able to see the details of the patient

  @ViewBedAvailability
  Scenario: Validate bed availability details
    When user clicks on the bed status
    And user clicks on the room
    Then user should be able to view bed occupancy details
