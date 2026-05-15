Feature: Add Prescription (User Story 4.6)
  As a doctor or admin
  I want to add prescriptions to an OPD visit
  So that the patient knows what medication to take

  Background:
    Given the user is logged into the Smart Hospital portal as a doctor
    And the user is viewing an existing OPD patient profile

  @us_4.6 @prescription
  Scenario: Add multiple medicines to a prescription
    When the user clicks the "Add Prescription" button
    And adds the following medications to the prescription list:
      | Category | Medicine        | Dosage | Duration | Instruction |
      | Tablet   | Paracetamol     | 500mg  | 5 Days   | After Meal  |
      | Syrup    | Cough Syrup ABC | 10ml   | 3 Days   | Before Meal |
    And clicks "Save"
    Then the prescription should be saved successfully
    And the medications should be visible under the "Prescription" tab