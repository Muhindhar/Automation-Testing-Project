@Muhindhar
@Developing
Feature: Muhindhar_19-05-2026_Add Visitor Functionality
  Description:
    Verify whether receptionist/admin user is able to add
    visitor details successfully using CSV test data.

  Background:
    Given the user launches the application
    And the user is on the login page
    When the user clicks the "Receptionist" button
    And clicks on the Login button

   @ValidAddVisitor
  Scenario Outline: Validate add visitor with valid details
    When user clicks on "Add Visitor" button
    And user enters visitor details 
    And user clicks on save button
    Then visitor should be added successfully

    Examples:
      | rowNumber |
      | 1         |
      | 2         |

   @InvalidAddVisitor
  Scenario Outline: Validate add visitor with invalid details
    When user clicks on "Add Visitor" button
    And user enters invalid visitor details from CSV "<rowNumber>"
    And user clicks on save button
    Then proper validation message should be displayed

    Examples:
      | rowNumber |
      | 3         |
      | 4         |
      | 5         |

   @MandatoryFieldValidation
  Scenario: Validate add visitor without mandatory fields
    When user clicks on "Add Visitor" button
    And user clicks on save button
    Then mandatory field validation message should be displayed
