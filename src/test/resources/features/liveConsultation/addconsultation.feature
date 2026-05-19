Feature: M_VIGNESHWARAN_2026_05_17_SmartHospital_AddConsultationFeature

  Background:
    Given the user launches the application
    And the user is on the login page
    When the user clicks the "Super Admin" button
    And clicks on the Login button
    And clicks on the live consultation from the sidebar
    And clicks on the live consultation from the dropdown appeared
    And clicks on the add button

  @One
  Scenario: Add consultation with all valid fields using data table
    When User enters consultation details:
      | patient           | Olivier Thomas                          |
      | consultationTitle | General Consultation              |
      | consultationDate  | 20/05/2026 10:30 AM               |
      | duration          | 30                                |
      | opdOrIpd          | OPD                               |
      | opdIpdNo          | OPDN001                           |
      | consultantDoctor  | Sonia Bush                        |
      | hostVideo         | Enabled                           |
      | clientVideo       | Enabled                           |
      | description       | Consultation created successfully |
    And User clicks on Save button
    Then Consultation should be added successfully

  Scenario: Add consultation with mandatory fields only using data table
    When User enters consultation details:
      | patient          | Olivier Thomas      |
      | consultationDate | 20/05/2026 11:00 AM |
      | duration         | 20                  |
      | consultantDoctor | Sonia Bush          |
      | hostVideo        | Enabled             |
      | clientVideo      | Enabled             |
    And User clicks on Save button
    Then Consultation should be added successfully

  Scenario: Validate consultation creation with all empty fields
    When User leaves all consultation fields empty
    And User clicks on Save button
    Then Validation message should be displayed for mandatory fields
