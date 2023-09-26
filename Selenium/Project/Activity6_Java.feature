@activity6_Java

Feature: Verify that Directory Menu is visible and Clickable

  Scenario: To verify that Directory menu is Visible and clickable
    Given User Opens browser to the login page of OrangeHRM site
    When User locates Username and Password Field
    And User enters login credential
    And User clicks on Login
    Then User validates that homepage has opened
    And User validates that Directory Menu is visible
    Then User clicks on Directory Menu
    And User closes the browser