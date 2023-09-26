@activity8_Java

Feature: Apply for leave

  Scenario: To apply for leave
    Given User Opens browser to the login page of OrangeHRM site
    When User locates Username and Password Field
    And User enters login credential
    And User clicks on Login
    Then User validates that homepage has opened
    When User navigates to dashboard page and clicks on apply leave option
    And User enters leave details and clicks on Apply
    Then User navigates to My Leave page to check the status of the leave application
    And User closes the browser