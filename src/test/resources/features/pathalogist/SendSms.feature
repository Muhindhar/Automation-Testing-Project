@Mythily
Feature: S_MYTHILY_2026_05_28_Send SMS validation - Smart Hospital

  Background:
    Given the user launches the application
    And the user navigates to admin login
    When the user clicks on the Pathologist login button
    Then the user should be redirected to the pathologist dashboard
    When the user clicks the messaging menu
    And the user clicks on send SMS tab

  @ValidSMSSend
  Scenario Outline: Verify valid message send
    When the user enters the "<title>"
    And the user enters the "<tempId>"
    And the user selects the SMS and MobileApp button
    And the user enters the message "<message>"
    And the user selects the patient and nurse
    And the user clicks the send button
    Then success message "Record Saved Successfully" should be displayed

    Examples:
      | title           | tempId | message                        |
      | Greeting To All | 101    | Hey All! GoodMorning Everyone! |

  @InvalidSMSSend
  Scenario: Verify empty message send
    When the user clicks the send button with empty fields
    Then error message "Message To field is required" should be displayed

  @MissingRequiredFields
  Scenario: Verify missing required fields
    When the user enters the message "Test message"
    And the user clicks the send button with missing fields
    Then missing field error "Send Through field is required" should be displayed