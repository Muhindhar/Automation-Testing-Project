Feature: S_MYTHILY_2026_05_17_Search pathology report validation - Smart Hospital

  Background:
    Given the user launches the application
    When the user clicks the "User Login" button
    And the user clicks on the Sign In button
    Then the user should be redirected to the patient dashboard

  @ValidPathologySearch
  Scenario: Verify pathology report search using valid bill number
    When the user clicks the Pathology menu
    And the user searches pathology reports by Bill Number "638"
    Then only pathology report results for Bill Number "638" should be displayed

  @InvalidPathologySearch
  Scenario: search with invalid bill number
    When the user clicks the Pathology menu
    And the user searches pathology reports by Bill Number "666"
    Then "No matching records found" should be displayed
