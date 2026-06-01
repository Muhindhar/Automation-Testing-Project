@Underdevelopment
Feature: V_MALAVICKA_2026_06_01_SmartHospital_IPDPatient_EditPatientDetails
As a doctor admin
I want to edit the existing IPD patient details
So that the updated patient information can be saved successfully in the system
Background:
Given the user launches the application
And the user is on the login page
When the user clicks the "Doctor" button
And clicks on the Login button
Then the dashboard page should be displayed
Scenario Outline: Edit existing IPD patient details successfully
When the user clicks on the "IPD - In Patient" option
Then the IPD patient list page should be displayed
When the user enters "<IPDNumber>" in the search field
And the user selects the patient record
Then the patient overview page should be displayed
When the user clicks on the Edit button
Then the Edit Patient form should be displayed
When the user enters "<CaseDetails>" in the Case field
And the user enters "<Reference>" in the Reference field
And clicks on the Save button
Then the patient details should be updated successfully
And success message should be displayed
Examples:
  | IPDNumber | CaseDetails          | Reference |
  | IPDN126   | Allergic to sea food | Relative  |

