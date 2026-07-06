@OpdDischarge
@jerishwin
@UnderDevelopment
Feature: Jerishwin_Joseph_25-05-2026_Discharge Patient
  As a receptionist
  I want to discharge a patient from the OPD

  Background:
    Given the user is logged into the Smart Hospital portal as a receptionist
    And the user is on the OPD page

  Scenario: Download a patients OPD Vist report
    When the user clicks the ID link for that patient
    And clicks on the Discharge icon
    And fills in the discharge form and clicks the Save button
    Then a Record Saved Successfully message should appear
