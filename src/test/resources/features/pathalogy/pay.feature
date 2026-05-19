Feature: S_MYTHILY_2026_05_18_Pay pathology report validation - Smart Hospital

  Background:
    Given the user launches the application
    When the user clicks the "User Login" button
    And the user clicks on the Sign In button
    Then the user should be redirected to the patient dashboard

  @ValidPathologySearch
  Scenario Outline: Verify pathology report search using valid bill number
    When the user clicks the Pathology menu
    And the user searches pathology reports by Bill Number "<billNo>"
    Then only pathology report results for Bill Number "<billNo>" should be displayed
    When click pay on resulted report
    And enter "<amt>" the payment amount
    And click add button
    And in the payment details page click make payment
    And enter the "<mobile>" mobile number and click continue button
    And click the UPI payment option
    And enter the "<upiId>"
    And click Verify and Pay button
    Then Payment Success Message will displayed as "Thank you for your payment"
    
    Examples:
      | billNo | amt  |    mobile  |     upiId         |
      |   638  | 1.00 | 9025590255 | mythily@gmail.com |
          
      
  @InvalidPaymentExceedAmount
  Scenario Outline: Verify payment fails when amount exceeds balance
    When the user clicks the Pathology menu
    And the user searches pathology reports by Bill Number "<billNo>"
    Then only pathology report results for Bill Number "<billNo>" should be displayed
    When click pay on resulted report
    And enter "<amt>" the payment amount
    And click add button
    Then an error message should be displayed for invalid payment amount

    Examples:
      | billNo |   amt   |
      |  638   | 9999.00 |

  @InvalidPaymentNegativeAmount
  Scenario Outline: Verify payment fails when negative amount is entered
    When the user clicks the Pathology menu
    And the user searches pathology reports by Bill Number "<billNo>"
    Then only pathology report results for Bill Number "<billNo>" should be displayed
    When click pay on resulted report
    And enter "<amt>" the payment amount
    And click add button
    Then an error message should be displayed for invalid payment amount

    Examples:
      | billNo |  amt  |
      |  638   | -1.00 |