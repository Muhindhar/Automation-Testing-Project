Feature: IPD PDF Report Download Module

  As a doctor admin
  I want to download the IPD patient report in PDF format
  So that I can save patient records for future reference

  Background:
    Given the user launches the browser
    And the user navigates to the Smart Hospital login page "https://smart-hospital.in/demo"
    When the user enters valid doctor admin credentials
      | username        | password  |
      | admin@admin.com | Test@1234 |
    And clicks on the login button
    Then the user should be redirected to the dashboard
    When the user clicks on the IPD module
    And the user clicks on the In Patient option
    Then the IPD patient page should be displayed

  Scenario: Download IPD patient report using PDF option

    When the user clicks on the PDF option
    Then the IPD patient report should be downloaded successfully

  Scenario: Verify downloaded PDF report format

    When the user clicks on the PDF option
    Then the downloaded file should be visible in the download folder
    And the downloaded file format should be ".pdf"