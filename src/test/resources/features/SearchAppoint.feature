Feature: Muhindhar_12-05-2026_Search Patients via Search Bar
  Description:
    Verify whether receptionist user is able to search patient appointments successfully using the search bar.

  Background:
    Given the user is on the homepage
    And user clicks on receptionist button
    And user clicks on signin button
    Then user should navigate to receptionist dashboard
    And user navigates to Appointment section

  @SearchToday
  Scenario: Search today appointment patient successfully
    When user clicks on the Today Appointment link
    And user enters patient name in the search bar
      | Name           |
      | Olivier Thomas |
    And user clicks on the patient name
    Then user should be able to see the patient details

  @SearchOld
  Scenario: Search old appointment patient successfully
    When user clicks on the Old Appointment link
    And user enters valid patient name in the search bar
      | Name           |
      | Cameron Martin |
    And user clicks on the particular patient
    Then user should be able to see the patient details

  @SearchUpcoming
  Scenario: Search upcoming appointment patient successfully
    When user clicks on the Upcoming Appointment link
    And user enters correct patient name in the search bar
      | Name           |
      | Nivetha Thomas |
    And user clicks on the exact patient from the list
    Then user should be able to see the patient details
