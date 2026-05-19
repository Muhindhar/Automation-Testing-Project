@attendanceReport
@jerishwin
Feature: Jerishwin_Joseph_16-05-2026_Attendance Report 
	    
	Scenario Outline: View Attendance Report
		Given the user is logged into the Smart Hospital portal as role in Excel
		When the user clicks the profile image
		And clicks the profile button
		And clicks the attendance button
		Then the user should be able to view the attendance report         