Feature: Muhindhar_16-05-2026_Downloading report from the front office
Description: downloading the reports from the front office page in different formats

  Background:
    Given user is on login page of smart hospitals
    And user clicks on receptionist button in site
    And click signin button of smart hospital site
    And user navigates to the front office link

  Scenario Outline: Download reports
    And user clicks on the "<format>" format
    Then the document should be downloaded successfully

    Examples:
      | format |
      | pdf    |
      | csv    |
      | excel  |
