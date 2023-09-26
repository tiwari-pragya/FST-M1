@activity9_Java

Feature: Emergency Contact Details

  Scenario: To retrieve emergency contacts
    Given User Opens browser to the login page of OrangeHRM site
    When User locates Username and Password Field
    And User enters login credential
    And User clicks on Login
    Then User validates that homepage has opened
    When User navigates to MyInfo Page
    And User locates the left hand menu and clicks on Emergency Contact menu
    Then User retrieves information of all the contacts listed and prints the information
    And User closes the browser
