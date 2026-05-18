#Feature: Add New OPD Patient (User Story 4.2)
 # As a receptionist
  #I want to add new patients to the OPD system
  #So that their visits can be tracked

  #Background:
   # Given the user is logged into the Smart Hospital portal as a receptionist
   # And the user is on the "OPD - Out Patient" page

#  @us_4.2 @add_patient
 # Scenario: Add a new OPD patient successfully (Valid Case)
#    When the user clicks the "Add Patient" button
 #   And the user fills the Add Patient form with the following details:
  #    | Name           | Jane Doe   |
   #   | Gender         | Female     |
    #  | Age            | 30         |
     # | Consultant     | Amit Singh |
      #| Charge Category| Standard   |
#    And clicks the "Save" button
 #   Then a "Record Saved Successfully" message should appear
  #  And the patient "Jane Doe" should be visible in the OPD list

 # @us_4.2 @add_patient
  #Scenario: Fail to add patient with missing required fields (Invalid Case)
   # When the user clicks the "Add Patient" button
 #   And the user leaves the mandatory "Patient Name" field blank
  #  And clicks the "Save" button
   # Then the system should highlight the "Patient Name" field with an error
    #And the patient record should not be created