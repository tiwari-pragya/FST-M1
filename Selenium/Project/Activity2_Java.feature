@activity2_Java

Feature: Get URL of Header Image

  Scenario: To print URL of header image
    Given User Opens browser to the login page of OrangeHRM site
    When User fetches url of header image
    Then User prints url to console
    And User closes the browser