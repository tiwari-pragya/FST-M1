@activity4_Java
Feature: New Employee Creation

  Scenario: Adding a new Employee
    Given User Opens browser to the login page of OrangeHRM site
    When User locates Username and Password Field
    And User enters login credential
    And User clicks on Login
    Then User validates that homepage has opened
    When User clicks on PIM menu
    And User clicks on Add Button to add employee
    And User fills in details and click on Save button
    #And User performs search operation
    Then User navigates to Employee List tab on PIM page and verifies new user creation
    #And User closes the browser