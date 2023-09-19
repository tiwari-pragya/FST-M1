@activity5
Feature: Login Test

  Scenario Outline: Testing Login with Example
    Given User is on Login Page
    When User enters "<Usernames>" and "<Passwords>"
    Then User reads the page title and confirmation message
    And User closes the browser

    Examples:
    | Usernames | Passwords |
    | admin     | password  |
    | adminUser | Password  |