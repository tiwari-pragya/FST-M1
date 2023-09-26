@activity3_Java
Feature: OrangeHRM Login Functionality

  Scenario: Logging into OrangeHRM site
    Given User Opens browser to the login page of OrangeHRM site
    When User locates Username and Password Field
    And User enters login credential
    And User clicks on Login
    Then User validates that homepage has opened
    And User closes the browser