Feature: Search functionality

  Scenario: User searches for valid product
    Given User opens the application.
    When user enters valid product "HP" into search box field
    And User clicks on search button
    Then User should get valid product displayed in search result

  Scenario: User searches for invalid product
    Given User opens the application.
    When user enters invalid product "Honda" into search box field
    And User clicks on search button
    Then User should get a message about no product maching

  Scenario: User searches without any product
    Given User opens the application.
    When user dont enters any product name into search box field
    And User clicks on search button
    Then User should get a message about no product maching
