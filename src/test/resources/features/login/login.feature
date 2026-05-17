Feature: M_VIGNESHWARAN_2026_05_12_SmartHospital_LoginFeature

  Background:
    Given the user launches the application
    And the user is on the login page

  @negative
  Scenario: Login with invalid email and password
    When the user enters wrong email
    And the user enters wrong password
    And clicks on the Login button
    Then an authentication error message should be displayed
    And the user should remain on the login page

  @negative
  Scenario: Login with valid email and invalid password
    When the user enters email
    And the user enters wrong password
    And clicks on the Login button
    Then an authentication error message should be displayed
    And the user should remain on the login page

  @negative
  Scenario: Login with empty email and password
    When the user leaves the email field empty
    And the user leaves the password field empty
    And clicks on the Login button
    Then validation messages should be displayed for mandatory fields

  @negative
  Scenario: Login with empty email
    When the user leaves the email field empty
    And the user enters password
    And clicks on the Login button
    Then a email required validation message should be displayed

  @negative
  Scenario: Login with empty password
    When the user enters email
    And the user leaves the password field empty
    And clicks on the Login button
    Then a password required validation message should be displayed

  @ValidLoginWithOutline
  Scenario Outline: Verify login functionality for multiple user roles
    When the user clicks the "<role>" button
    And clicks on the Login button
    Then the user should be redirected to the dashboard
    And the role of the user in profile should "<role>"

    Examples:
      | role         | role         |
      | Super Admin  | Super Admin  |
      | Admin        | Admin        |
      | Doctor       | Doctor       |
      | Pharmacist   | Pharmacist   |
      | Pathologist  | Pathologist  |
      | Radiologist  | Radiologist  |
      | Accountant   | Accountant   |
      | Receptionist | Receptionist |
      | Nurse        | Nurse        |
