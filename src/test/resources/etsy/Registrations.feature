Feature: Registrations Tests

  Scenario: Succesful registration
    Given I am on the registration page
    When I enter a valid email
    And I click on the continue button
    When I enter valid firstName and password
    And I click on register button
    Then I should be on home page

