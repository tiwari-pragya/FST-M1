@activity2
Feature: Login Test

  Scenario: Testing Login
    Given User is on Login Page
    When User enters username and password
    Then User reads the page title and confirmation message
    And User closes the browser