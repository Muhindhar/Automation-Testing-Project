@Muhindhar
Feature: Muhindhar_16-05-2026_Downloading report from the front office
Description:
downloading the reports from the front office page in different formats

  Background:
    Given the user launches the application
    And the user is on the login page
    When the user clicks the "Receptionist" button
    And clicks on the Login button
    And user navigates to the front office link

  @downloadreports
  Scenario Outline: Download reports
    And user clicks on the "<format>" format
    Then the document should be downloaded successfully

    Examples:
      | format |
      | pdf    |
      | csv    |
      | excel  |

  @InvalidDownloadFormat
  Scenario: Validate invalid report download format
    When user clicks on the "txt" format
    Then invalid download format message should be displayed
