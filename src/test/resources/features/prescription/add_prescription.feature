@Mythily
Feature: S_MYTHILY_2026_05_14_SmartHospital_Add Prescription Validation

   Background:
    Given the user launches the application
    And the user is on the login page
    When the user clicks the "Doctor" button
    And clicks on the Login button
    Then the user should be redirected to the dashboard
    When clicks the IPD -In Patient menu
    And searches patient by IPD Number
    Then only patient with that IPD should be displayed
    When clicks that IPD Number
    And clicks on Prescription tab
    And clicks on Add Prescription button

  @ValidPrescriptionSave @UnderDevelopment
  Scenario: Add prescription with valid details from Excel and click Save

    When fills the valid prescription details
    And clicks on Save
    Then the prescription should be saved successfully
    And the prescription should appear in the prescription list

  @MissingMandatoryFields
  Scenario Outline: Validate error message when Save is clicked without mandatory prescription details

    When enters prescription details
      | headerNote   | prescribeBy   |
      | <headerNote> | <prescribeBy> |
    And clicks on Save
    Then an error message should be displayed as "Please select any one pathology, radiology or medicine details"

    Examples:
      | headerNote                                                                                      | prescribeBy      |
      | Patient complains of fever, cough, and body pain for the past 3 days. Patient condition stable. | Amit Singh(9009) |
      |                                                                                                 |                  |

  @InvalidPrescription
  Scenario: Validate error message when Save is clicked without filling any prescription details

    When clicks on Save
    Then an error message should be displayed as "Please select any one pathology, radiology or medicine details"