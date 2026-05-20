@OpdReport
@jerishwin
Feature: Jerishwin_Joseph_13-05-2026_Download OPD Report (User Story 4.4)
  As a receptionist or patient
  I want to download OPD visit reports
  So that I can have a physical or digital copy of the bill/details

  Background:
    Given the user is logged into the Smart Hospital portal as a receptionist
    And the user is on the OPD page

  Scenario: Download a patients OPD Vist report
    When the user clicks the ID link for that patient
    And navigates to the Visits tab
    And clicks the Pdf icon on the visit record
    Then the report should be downloaded successfully