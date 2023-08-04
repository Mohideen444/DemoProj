
Feature: Validate the login functionality of Orange HRM

  @login
  Scenario: Check the successful login to the orange HRM with valid credentials
    Given user navigates to the orange hrm login page
		And user enters valid "admin" user name
		And user enters valid "admin" password
		When user clicks the login button
		Then the user navigated to the dashboard page

  @loginError
  Scenario Outline: Check the login error on orange HRM when using invalid credentials
    Given user navigates to the orange hrm login page
		And user enters invalid "<username>" user name
		And user enters invalid "<password>" password
		When user clicks the login button
		Then the user gets "Invalid credentials" error message
		#Then the user gets "Invalid credentials" error message

    Examples: 
      | username  | password 	|
      | test			| test123		|
