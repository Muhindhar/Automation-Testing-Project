@OPD_Search
@jerishwin
Feature: Jerishwin_Joseph_13-05-2026_OPD Patient Search
  As a receptionist
  I want to search for OPD patients by name or ID
  So that I can quickly find their records

  Background:
    Given the user is logged into the Smart Hospital portal as a receptionist
    And the user is on the OPD page

  @us_4.1 @search
  Scenario Outline: Search for an OPD patient (Valid and Invalid)
    When the user types "<SearchKeyword>" into the OPD search box
    Then the patient table should display "<ExpectedResult>"

    Examples:
      | SearchKeyword	| ExpectedResult                            |
      | maria   		| The single record for Patient ID "Maria"	|
      | XYZ999        	| A "No data available in table" message    |