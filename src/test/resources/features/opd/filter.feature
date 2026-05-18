#Feature: Filter OPD Patients (User Story 4.3)
#  As a receptionist
#  I want to filter the OPD list by specific criteria like the Consultant Doctor
#  So that I can organize the patient list easily

#  Background:
#    Given the user is logged into the Smart Hospital portal as a receptionist
#    And the user is on the "OPD - Out Patient" page

#  @us_4.3 @filter
#  Scenario Outline: Filter patients by Consultant Doctor
#    When the user selects "<DoctorName>" from the "Consultant" filter dropdown
#    And clicks the "Search" button in the filter bar
#    Then the resulting table should only show patients assigned to "<DoctorName>"

#    Examples:
 #     | DoctorName  |
 #     | Sonia Bush  |
  #    | Amit Singh  |