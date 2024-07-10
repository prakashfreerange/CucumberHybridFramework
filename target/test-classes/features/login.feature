Feature: Verify Login Functionality

  Scenario Outline: Login with valid credentials
    Given User has navigated to login page
    When User enters valid email address <username>
    And User enters valid password <password>
    And user clicks on Login Button
    Then User should get successfully logged in

    Examples: 
      | username                 | password  |
      | prakash+01@freerange.com | Avdi@1212 |

  Scenario: Login with invalid credentials
    Given User has navigated to login page
    When User enters invalid email address "pra@freerange.com"
    And User enters invalid password "Avdi@1212"
    And user clicks on Login Button
    Then User should get a warning message

  Scenario: Login with valid email but invalid password
    Given User has navigated to login page
    When User enters valid email address "prakash+01@freerange.com"
    And User enters invalid password "2343"
    And user clicks on Login Button
    Then User should get a warning message

  Scenario: Login without providing any credentails.
    Given User has navigated to login page
    When User dont enter email address
    And User dont enter password
    And user clicks on Login Button
    Then User should get a warning message

  Scenario: Login with invalid email but valid password
    Given User has navigated to login page
    When User enters invalid email address "pra@freerange.com"
    And User enters valid password "Avdi@1212"
    And user clicks on Login Button
    Then User should get a warning message
