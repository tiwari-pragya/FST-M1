@activity7_Java

Feature: Add Employee Qualification

  Scenario: To add employee qualification
    Given User Opens browser to the login page of OrangeHRM site
    When User locates Username and Password Field
    And User enters login credential
    And User clicks on Login
    Then User validates that homepage has opened
    When User navigates to MyInfo Page
    And User locates the left hand menu and clicks on Qualifications menu
    And User clicks on Add Button to add qualification details
    And User adds qualification details
    Then User saves information
    And User closes the browser