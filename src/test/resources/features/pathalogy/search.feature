@Mythily
Feature: S_MYTHILY_2026_05_17_Search pathology report validation - Smart Hospital

  Background:
    Given the user launches the application
    When the user clicks on the Sign In button
    Then the user should be redirected to the patient dashboard

  @ValidPathologySearch
  Scenario: Verify pathology report search using valid bill number
    When the user clicks the Pathology menu
    And the user searches pathology reports by valid bill number
    Then only pathology report results should be displayed

  @InvalidPathologySearch
  Scenario: search with invalid bill number
    When the user clicks the Pathology menu
    And the user searches pathology reports by invalid bill number
    Then "No matching records found" should be displayed