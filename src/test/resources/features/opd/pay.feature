Feature: OPD Payment (User Story 4.8)
As a receptionist
I want to collect and record payments from OPD patients
So that hospital billing is accurate

Background:
Given the user is logged into the Smart Hospital portal as a receptionist
And the user is viewing an OPD patient with a pending balance

@us_4.8 @pay
Scenario: Make a valid OPD payment
When the user clicks the "Add Payment" button
And enters "500" in the "Amount" field
And selects "Cash" as the "Payment Mode"
And clicks the "Save" button
Then a "Payment Successful" message should appear
And the patient's "Paid Amount" should increase by 500
And the "Balance Amount" should decrease by 500

@us_4.8 @pay
Scenario: Attempt to make a payment with an invalid amount
When the user clicks the "Add Payment" button
And enters "-50" in the "Amount" field
And clicks the "Save" button
Then the system should display a validation error "Amount must be valid"
And the payment should not be processed