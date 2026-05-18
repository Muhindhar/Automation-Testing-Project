Feature: Muhindhar_13-05-2026_Downloading the PDF (Printing)
  Description:
    Verify whether receptionist user is able to download
    appointment details successfully.

  Background:
    Given the user is logged in as receptionist
    And user is on appointment page

  @DownloadAppointment
  Scenario Outline: Download appointment filter in different formats
    When user clicks on "<filter>" filter
    And user selects "<format>" download option
    Then file should be downloaded successfully for "<fileName>"

    Examples:
      | filter               | format | fileName                 |
      | Old Appointment      | pdf    | Appointment Details.pdf  |
      | Upcoming Appointment | csv    | Appointment Details.csv  |
      | Today Appointment    | xlsx   | Appointment Details.xlsx |
