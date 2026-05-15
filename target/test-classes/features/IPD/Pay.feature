Feature: IPD Patient Payment Module

  As a doctor admin
  I want to add payment details for IPD patients
  So that patient billing information can be updated successfully

  Background:
    Given the user launches the browser
    And the user navigates to the Smart Hospital login page "https://smart-hospital.in/demo"
    When the user enters valid doctor admin credentials
      | username        | password  |
      | admin@admin.com | Test@1234 |
    And clicks on the login button
    Then the user should be redirected to the dashboard
    When the user clicks on the IPD module
    And the user clicks on the In Patient option
    Then the IPD patient page should be displayed

  Scenario Outline: Add payment successfully for IPD patient

    When the user searches patient name "<PatientName>"
    Then the matching patient profile should be displayed

    When the user clicks on IPD number "<IPDNO>"
    Then the patient profile page should be opened

    When the user clicks on the Payment option
    And the user clicks on the Add Payment button
    Then the Add Payment form should be displayed

    When the user enters payment details
      | Date   | Amount   | PaymentMode   | Note   |
      | <Date> | <Amount> | <PaymentMode> | <Note> |

    And clicks on the Save button

    Then payment should be added successfully
    And success message should be displayed

    Examples:
      | PatientName | IPDNO   | Date       | Amount | PaymentMode | Note               |
      | Taruna      | IPDN125 | 14/05/2026 |    0   | Cash        | IPD payment added  |

  Scenario Outline: Add payment with missing mandatory fields

    When the user searches patient name "<PatientName>"
    And the user clicks on IPD number "<IPDNO>"
    And the user clicks on the Payment option
    And the user clicks on the Add Payment button
    Then the Add Payment form should be displayed

    When the user enters invalid payment details
      | Date   | Amount   |
      | <Date> | <Amount> |

    And clicks on the Save button

    Then validation message should be displayed

    Examples:
      | PatientName | IPDNO   | Date       | Amount |
      | Taruna      | IPDN125 |            | 5000   |
      | Taruna      | IPDN125 | 14/05/2026 |        |