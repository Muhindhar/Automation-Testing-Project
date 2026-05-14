Feature: Show OPD Patient Details (User Story 4.7)
  As a hospital worker
  I want to view the full details and history of an OPD patient
  So that I have full context of their treatment

  Background:
    Given the user is logged into the Smart Hospital portal as a receptionist
    And the user is on the "OPD - Out Patient" page

  @us_4.7 @show_details
  Scenario: View all tabs in the patient details view
    When the user clicks the "Show" (eye icon) button for a patient
    Then the patient profile should open displaying the following tabs:
      | Tab Name            |
      | Visits              |
      | Lab Investigation   |
      | Treatment History   |
      | Timeline            |
    And the basic patient details (Name, Age, Blood Group) should be visible at the top