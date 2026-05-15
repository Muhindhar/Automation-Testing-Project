Feature: Add New IPD Patient Popup Module

  As a doctor admin
  I want to add a new IPD patient through the New Patient popup form
  So that patient details can be stored successfully in the system

  Background:
    Given the user launches the application
    And the user is on the login page
    When the user clicks the "Doctor" button
    And clicks on the Login button
    Then the user should be redirected to the dashboard
    When the user clicks on the IPD module
    And the user clicks on the In Patient option
    Then the In Patient page should be displayed
    When the user clicks on the Add Patient button
    And the user clicks on the New Patient button
    Then the Add Patient popup form should be displayed

  Scenario Outline: Add new patient with valid details in popup form
    When the user enters patient details
      | Name   | GuardianName   | Gender   | DOB        | Phone      | Email             | Address    | Remarks      | Allergies   | TPA      | TPAID   | TPAValidity   | NationalID   | AlternateNumber |
      | <Name> | <GuardianName> | <Gender> | <DOB>      | <Phone>    | <Email>           | <Address>  | <Remarks>    | <Allergies> | <TPA>    | <TPAID> | <TPAValidity> | <NationalID> | <AlternateNumber> |
    And clicks on the Save button
    Then patient details should be saved successfully
    And success message should be displayed

    Examples:
      | Name   | GuardianName | Gender | DOB        | Phone      | Email            | Address   | Remarks      | Allergies | TPA       | TPAID | TPAValidity | NationalID | AlternateNumber |
      | Rahul  | Kumar        | Male   | 10/10/2000 | 9876543210 | rahul@gmail.com | Chennai   | Fever Case  | No         | HealthTPA | 12345 | 12/12/2026  | 567890     | 9123456780      |

  Scenario Outline: Add patient with missing mandatory fields
    When the user enters invalid patient details
      | Name   | Gender   | Phone   |
      | <Name> | <Gender> | <Phone> |
    And clicks on the Save button
    Then validation message should be displayed

    Examples:
      | Name | Gender | Phone |
      |      | Male   |       |
      | Arun |        | 12345 |

  Scenario Outline: Add patient admission details with valid data
    When the user enters admission and medical details
      | SymptomsType   | SymptomsTitle   | SymptomsDescription   | Note   | PreviousMedicalIssue   | AdmissionDate   | Case   | TPA   | Reference   | ConsultantDoctor   | BedGroup   | BedNumber   | LiveConsultation |
      | <SymptomsType> | <SymptomsTitle> | <SymptomsDescription> | <Note> | <PreviousMedicalIssue> | <AdmissionDate> | <Case> | <TPA> | <Reference> | <ConsultantDoctor> | <BedGroup> | <BedNumber> | <LiveConsultation> |
    And clicks on the final Save button
    Then patient admission details should be saved successfully
    And success message should be displayed

    Examples:
      | SymptomsType | SymptomsTitle | SymptomsDescription | Note         | PreviousMedicalIssue | AdmissionDate | Case    | TPA    | Reference | ConsultantDoctor | BedGroup | BedNumber | LiveConsultation |
      | Skin problems | High Fever   | Viral Fever        | Under Observe| No                   | 05/14/2026    | Fever   | Health | Friend    | Amit Singh      | | VIP Ward -Ground Floor | Yes              |

 