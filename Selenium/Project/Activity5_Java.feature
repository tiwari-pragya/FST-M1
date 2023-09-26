@activity5_Java

Feature: Edit User

  Scenario: To edit User Information
    Given User Opens browser to the login page of OrangeHRM site
    When User locates Username and Password Field
    And User enters login credential
    And User clicks on Login
    Then User validates that homepage has opened
    When User navigates to MyInfo Page
    And User click on Edit Button
    And User edits Name, Gender, Nationality and DOB fields
    Then User clicks on Save
    And User closes the browser