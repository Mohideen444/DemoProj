@tag
Feature: Attendance functionality validations in the Orange HRM

Background:
	Given user successfully logged-in as "admin" in the Orange HRM portal

  @punchOut
  Scenario: Check whether the user able to punchout
  
    Given the user navigated to the dashboard page
    When user clicks the stop watch icon under Time at Work card
    Then user redirects to the attendance page
    When user enters the puchout notes
    And the user clicks on out button
    Then the user punched out successfully
    
