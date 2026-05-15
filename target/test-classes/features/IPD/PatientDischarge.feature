Feature: IPD Patient Discharge Module

  As a doctor admin
  I want to discharge an IPD patient
  So that completed patient treatments can be updated in the system

  Background:
    Given the user launches the application
    And the user is on the login page
    When the user clicks the "Doctor" button
    And clicks on the Login button
    Then the user should be redirected to the dashboard
    When the user clicks on the IPD module
    And the user clicks on the In Patient option
    Then the IPD patient page should be displayed

  Scenario Outline: Discharge IPD patient successfully

    When the user searches patient name "<PatientName>"
    Then the matching patient profile should be displayed

    When the user clicks on the IPD number of the patient
    Then the patient profile page should be opened

    When the user clicks on the Patient Discharge option
    Then the Patient Discharge form should be displayed

    When the user enters discharge details
      | DischargeDate   | DischargeStatus   | Note   | Operation   | Diagnosis   | Investigation   | TreatmentHome   |
      | <DischargeDate> | <DischargeStatus> | <Note> | <Operation> | <Diagnosis> | <Investigation> | <TreatmentHome> |

    And clicks on the Save button

    Then the patient should be discharged successfully
    And success message should be displayed

    Examples:
      | PatientName | DischargeDate | DischargeStatus | Note              | Operation | Diagnosis    | Investigation | TreatmentHome |
      | Ashok       | 14/05/2026    | Normal          | Patient recovered | No Surgery| Viral Fever  | Blood Test    | Take Rest     |

  Scenario Outline: Discharge patient with missing mandatory fields

    When the user searches patient name "<PatientName>"
    And the user clicks on the IPD number of the patient
    And the user clicks on the Patient Discharge option
    Then the Patient Discharge form should be displayed

    When the user enters invalid discharge details
      | DischargeDate   | DischargeStatus   |
      | <DischargeDate> | <DischargeStatus> |

    And clicks on the Save button

    Then validation message should be displayed

    Examples:
      | PatientName | DischargeDate | DischargeStatus |
      | Ashok       |                | Discharged      |
      | Ashok       | 14/05/2026     |                  |