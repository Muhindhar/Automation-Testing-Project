Feature: V_MALAVICKA_2026_05_14_SmartHospital_IPD Search Module
  As a hospital staff member
  I want to search IPD patients
  So that I can quickly find inpatient records

  Background:
    Given the user launches the application
    And the user is on the login page
    When the user clicks the "Doctor" button
    And clicks on the Login button

  Scenario Outline: Search patient using valid patient name
    When the user enters "<patient_name>" in the search box
    Then matching patient records should be displayed
    Examples:
      | patient_name |
      | Seher        |
      | Arpit        |

  Scenario Outline: Search patient using invalid patient name
    When the user enters "<invalid_patient_name>" in the search box
    Then no matching patient records should be displayed

    Examples:
      | invalid_patient_name |
      | xyz123               |
      | testuser             |