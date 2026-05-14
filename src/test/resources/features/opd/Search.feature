Feature: OPD Patient Search
  As a receptionist
  I want to search for OPD patients by name or ID
  So that I can quickly find their records

  # Background runs before every scenario to set up the starting point
  Background:
    Given the user is logged into the Smart Hospital portal as a receptionist
    And the user is on the OPD page

  # Scenario Outline allows us to run the same test multiple times with the data in the Examples table
  @us_4.1 @search
  Scenario Outline: Search for an OPD patient (Valid and Invalid)
    When the user types "<SearchKeyword>" into the OPD search box
    Then the patient table should display "<ExpectedResult>"

    Examples:
      | SearchKeyword	| ExpectedResult                            |
      | maria   		| The single record for Patient ID "Maria"	|
      | XYZ999        	| A "No data available in table" message    |