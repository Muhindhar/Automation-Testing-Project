Feature: Move OPD to IPD (User Story 4.5)
  As a hospital administrator
  I want to transfer an OPD patient to the In-Patient Department (IPD)
  So that they can be admitted to a ward

  Background:
    Given the user is logged into the Smart Hospital portal as a receptionist
    And the user is on the "OPD - Out Patient" page

  @us_4.5 @move_to_ipd
  Scenario: Successfully move a patient from OPD to IPD
    Given the user opens the profile of an existing OPD patient
    When the user clicks the "Move to IPD" button
    And fills in the admission form with the following details:
      | Bed Group  | General Ward |
      | Bed Number | G-105        |
      | Symptoms   | High fever   |
    And clicks the "Save" button
    Then a success message should be displayed
    And the patient should now appear in the "IPD - In Patient" module