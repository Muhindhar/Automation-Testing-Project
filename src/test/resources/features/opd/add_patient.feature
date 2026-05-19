@jerishwin
@OPDAddPatient
Feature: Jerishwin_Joseph_17-05-2026_Add New OPD Patient
  As a receptionist
  I want to add new patients to the OPD system
  So that their visits can be tracked

  Background:
    Given the user is logged into the Smart Hospital portal as a receptionist
    And the user is on the "OPD - Out Patient" page
    When the user clicks the Add Patient button
    And selects add icon

  
  Scenario: Add a new OPD patient successfully (Valid Case)
    And the user fills the Add Patient form with the following details:
      | Name           | Jane Doe   |
      | Gender         | Female     |
      | Year           | 30         |
      | Month		   | 05 		|
      | Day			   | 14		    |
    And clicks the "Save" button
    Then a "Record Saved Successfully" message should appear

  
  Scenario: Fail to add patient with missing required fields (Invalid Case)

    And the user leaves the mandatory "Patient Name" field blank
      | Name           |			|
      | Gender         | Female     |
      | Year           | 30         |
      | Month		   | 05 		|
      | Day			   | 14		    |
    And clicks the "Save" button
    Then the system should show a message "Name field is required"