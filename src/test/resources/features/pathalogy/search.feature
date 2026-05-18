Feature: Search pathology report validation - Smart Hospital

  Background:
    Given the user launches the application
    When the user clicks the "User Login" button
    And the user clicks on the Sign In button
    Then the user should be redirected to the patient dashboard

  @ValidPathologySearch
  Scenario Outline: Verify pathology report search using valid bill number
    When the user clicks the Pathology menu
    And the user searches pathology reports by Bill Number "<billNo>"
    Then only pathology report results for Bill Number "<billNo>" should be displayed
    
    Examples:
      | billNo |
      |   638  |
      |   650  |
      |   644  |

  @InvalidPathologySearch
  Scenario Outline: search with invalid bill number
    When the user clicks the Pathology menu
    And the user searches pathology reports by Bill Number "<billNo>"
    Then "No matching records found" should be displayed
     
    Examples:
      | billNo |
      |   666  |
      |   610  |
      |   607  | 
