Feature: Delete IPD Patient Module

  As a doctor admin
  I want to delete an IPD patient record
  So that unwanted patient records can be removed from the system

  Background:
    Given the user launches the application
    And the user is on the login page
    When the user clicks the "Doctor" button
    And clicks on the Login button
    Then the user should be redirected to the dashboard
    When the user clicks on the IPD module
    And the user clicks on the In Patient option
    Then the IPD patient page should be displayed

  Scenario Outline: Delete IPD patient successfully using IPD number

    When the user searches IPD number "<IPDNO>"
    And the matching patient record should be displayed
    And the user clicks on the patient profile
    And the user clicks on the Delete Patient option
    Then delete confirmation popup should be displayed
    When the user clicks on OK button
    Then the patient record should be deleted successfully

    Examples:
      | IPDNO   |
      | IPDN128 |

  Scenario Outline: Cancel delete patient operation

    When the user searches IPD number "<IPDNO>"
    And the matching patient record should be displayed
    And the user clicks on the patient profile
    And the user clicks on the Delete Patient option
    Then delete confirmation popup should be displayed
    When the user clicks on Cancel button
    Then the patient record should not be deleted

    Examples:
      | IPDNO   |
      | IPDN128 |
