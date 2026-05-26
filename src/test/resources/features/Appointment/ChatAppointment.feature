@Muhindhar
Feature: Muhindhar_25-05-2026_Chat with doctor in the appointment module
Description:
Verify whether the user is able to chat with the doctor

  Background:
    Given the user launches the application
    And the user is on the login page
    When the user clicks the "Receptionist" button
    And clicks on the Login button

  @ValidMessage
  Scenario: Validate chat with doctor
    When user clicks on appointment section
    And clicks on chat icon in the appointment page
    And user selects the doctor in the chat page
    And user sends the message in the chatbox
    Then user should be able to send the message
    
   
