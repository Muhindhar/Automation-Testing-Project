Feature: M_VIGNESHWARAN_2026_05_16_SmartHospital_JoinConsultationFeature

  Background:
    Given the user launches the application
    And the user is on the login page
    When the user clicks the "Super Admin" button
    And clicks on the Login button
    And clicks on the live consultation from the sidebar
    And clicks on the live consultation from the dropdown appeared

  Scenario: Verify Join button is visible when consultation status is Awaited
    Given the user identifies a consultation record with status "Awaited"
    Then the Join button should be visible for that consultation
    And the user should be able to click the Join button

  Scenario: Verify Join button is not visible when consultation status is not awaited
    Given the user identifies a consultation record with status not "Awaited"
    Then the Join button should not be visible for that consultation

  Scenario: Verify Start Now button is displayed in the Join Consultation popup
    Given the user identifies a consultation record with status "Awaited"
    When the user clicks the Join button
    Then the consultation popup should be displayed
    And the Start Now button should be visible in the popup

  Scenario: Verify clicking Start Now opens Zoom meeting in a new tab
    Given the user identifies a consultation record with status "Awaited"
    When the user clicks the Join button
    And the user clicks the Start Now button
    Then a new browser tab should be opened
    And the Zoom meeting URL should contain "zoom.us"