Feature: Attendance Report 
	    
	Scenario:
		Given the user is logged into the Smart Hospital portal as "<role>"
		When the user clicks the profile image
		And clicks the profile button
		And clicks the attendance button
		Then the user should be able to view the attendance report
		Examples:
            | role          |            | Doctor        |            | Receptionist  |
            | Admin         |
            | Nurse         |         