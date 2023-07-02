Feature: Home Page Tests

  Background: Arrive home page
    When I click on continue as guest button
    And I click on maybe later button
   # And I handle the presence of the search bar



  Scenario:Updating content after refresh page
    When I refresh page
    Then I verify page content has been updated


  Scenario: Search with image
    When I click on search with image button
    And I click on select an existing photo
    And I select photo from library
    Then I verify the results related to my photo

  Scenario: New content with scroll down
    Given I collect current total content number
    When I scroll down
    Then I verify total content number increased





