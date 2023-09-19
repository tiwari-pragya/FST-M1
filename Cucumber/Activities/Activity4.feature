@activity4
Feature: Login Test

  Scenario: Testing Login without Examples
    Given User is on Login Page
    When User enters "admin" and "password"
    Then User reads the page title and confirmation message
    And User closes the browser