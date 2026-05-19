Feature: Muhindhar_13-05-2026_Appointment Filter Functionality
  Description:
    Verify whether receptionist user is able to filter appointment records successfully.

  Background:
    Given the user is on the login page
    And user clicks on receptionist button
    And user clicks on signin button
    And user navigates to Appointment section

  @TodayAppointmentFilter
  Scenario: Validate today appointment filter
    When user clicks on the Today Appointment filter
    Then user should be able to see today's appointment details

  @UpcomingAppointmentFilter
  Scenario: Validate upcoming appointment filter
    When user clicks on the Upcoming Appointment filter
    Then user should be able to see upcoming appointments

  @OldAppointmentFilter
  Scenario: Validate old appointment filter
    When user clicks on the Old Appointment filter
    Then user should be able to see old appointments
