@profilePage
@jerishwin
Feature: Jerishwin_Joseph_16-05-2026_Profile 
	    
	Scenario Outline: View Profile Details
		Given the user is logged into the Smart Hospital portal as "<role>"
		When the user clicks the profile image
		And clicks the profile button
		Then the user should be navigated to the profile page showing "<role>"
		
		Examples:
            | role          |            | Doctor        |            | Nurse         |            | Receptionist  |            | Admin         |