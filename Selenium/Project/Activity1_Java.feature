@activity1_Java

Feature: Verify Website Title

  Scenario: To verify website title
    Given User Opens browser to the login page of OrangeHRM site
    When User get the title of the page
    Then User validates it matches with 'OrangeHRM'
    And User closes the browser