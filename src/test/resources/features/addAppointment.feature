Feature: Muhindhar_12-05-2026_Add Appointment Functionality
  Description:
    Verify whether receptionist user is able to add appointment successfully.

  Background:
    Given the user is on the homepage
    And user clicks on receptionist button
    And user clicks on signin button
    Then user should navigate to receptionist dashboard

  @ValidAppointment
  Scenario: Add appointment successfully
    When user navigates to Appointment section
    And user clicks on Add Appointment
    And user enters valid patient details
      | Doctor            | Shift   | Appointment Date    | Slot                | Appointment Priority | Status  | Live Consultant |
      | Amit Singh (9009) | Morning | 05/20/2026 12:06 PM | 10:00 AM - 12:30 PM | Urgent               | Pending | No              |
    And user clicks on Save button
    Then appointment should be added successfully
    And success message should be displayed

  @InvalidAppointment
  Scenario: Validate mandatory field error messages
    When user navigates to Appointment section
    And user clicks on Add Appointment
    And user leaves mandatory fields empty
    And user clicks on Save button
    Then appropriate validation message should be displayed
    And appointment should not be created

  @DuplicateAppointment
  Scenario: Validate duplicate appointment creation
    When user navigates to Appointment section
    And user clicks on Add Appointment
    And user enters already existing appointment details
      | Doctor            | Shift   | Appointment Date    | Slot                | Appointment Priority | Status  | Live Consultant |
      | Amit Singh (9009) | Morning | 05/20/2026 12:06 PM | 10:00 AM - 12:30 PM | Urgent               | Pending | No              |
    And user clicks on Save button
    Then duplicate appointment warning message should be displayed
    And appointment should not be created
