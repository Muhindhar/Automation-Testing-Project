Feature: Muhindhar_13-05-2026_Downloading the PDF (Printing)
  Description:
    Verify whether receptionist user is able to download appointment details as PDF successfully.

  Background:
    Given the user is on the homepage
    And user clicks on receptionist button
    And user clicks on signin button
    Then user should navigate to receptionist dashboard
    And user navigates to Appointment section

  @ValidDownloadPdf
  Scenario: Download old appointment details as PDF
    When user clicks on the Old Appointments filter
    And user clicks on the PDF logo
    Then appointment PDF should be downloaded successfully

  @UpcomingDownloadPdf
  Scenario: Download upcoming appointment details as PDF
    When user clicks on the Upcoming Appointments filter
    And user clicks on the PDF logo
    Then appointment PDF should be downloaded successfully

  @TodayDownloadPdf
  Scenario: Download today appointment details as PDF
    When user clicks on the Today Appointments filter
    And user clicks on the PDF logo
    Then appointment PDF should be downloaded successfully
