Feature: V_MALAVICKA_2026_05_14_Generate patient certificate in IPD module

As a doctor
I want to generate patient certificates
So that I can verify patient certificate details

Background:
 Given the user launches the application
 And the user is on the login page
 When the user clicks the "Doctor" button
 And clicks on the Login button
 Then the user should be redirected to the dashboard
 When the user clicks on the "Certificate" menu
 And the user selects the "Certificate" submenu

Scenario Outline: Generate patient certificate using valid details
When the user selects the following certificate details:
| Module         | Patient Status        | Certificate Template        |
| <Module>       | <PatientStatus>       | <CertificateTemplate>       |
And the user clicks on the Search button
Then the system should display the matching patient records
When the user selects the patient "<PatientName>"
And the user clicks on the Generate button
Then the patient certificate details should be displayed successfully
When the user clicks on the Cancel button
Then the certificate popup should be closed successfully

Examples:
  | Module | PatientStatus | CertificateTemplate       | PatientName |
  | IPD    | Discharged    | Sample Print File Cover   | Seher       |


Scenario Outline: Generate patient certificate using invalid details
When the user selects the following certificate details:
| Module         | Patient Status        | Certificate Template        |
| <Module>       | <PatientStatus>       | <CertificateTemplate>       |
And the user clicks on the Search button
Then the system should display no matching patient records
And the user should see an appropriate validation or empty result message

```
Examples:
  | Module | PatientStatus | CertificateTemplate |
  | ABCD   | InvalidStatus | Dummy Certificate   |
```
