@Muhindhar
Feature: Muhindhar_06-07-2026_Blood Component Issue Billing Module

Description:
As a receptionist, I want to view the blood component issue billing details.

Background:
	Given the user is on the login page
	And user clicks on receptionist button
	And user clicks on signin button
	And user clicks on the billing link

@BloodComponentIssue
Scenario: Check blood component issue billing details
	When user clicks on the blood component issue button
	And user clicks on the data
	Then user should be able to see the details of the particular person

@InvalidBloodComponentIssue
Scenario: View blood component details without selecting a record
    When user clicks on the blood component issue button
    Then user should not be able to view the patient details
