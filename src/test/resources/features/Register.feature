Feature: Registration Functionality

  Scenario: User create account only with manadatory fields
    Given User navigates to register account page.
    When User enters the details into below fields
      | firstName       | Prakash                    |
      | lastName        | Lale                       |
      | telephone       |                 1234567890 |
      | password        |                      12345 |
      | confirmPassword |                      12345 |
    And User selects privacy policy
    And User clicks on Continue button
    Then User account should get created successfully

  Scenario: User create account only with all fields
    Given User navigates to register account page.
    When User enters the details into below fields
      | firstName       | Prakash                    |
      | lastName        | Lale                       |
      | telephone       |                 1234567890 |
      | password        |                      12345 |
      | confirmPassword |                      12345 |
    And User select Yes for newsletter
    And User selects privacy policy
    And User clicks on Continue button
    Then User account should get created successfully

  Scenario: User creates a duplicate account
    Given User navigates to register account page.
    When User enters the details into below fields with duplicate email
      | firstName       | Prakash                    |
      | lastName        | Lale                       |
      | email           | prakashlale97+02@gmail.com |
      | telephone       |                 1234567890 |
      | password        |                      12345 |
      | confirmPassword |                      12345 |
    And User select Yes for newsletter
    And User selects privacy policy
    And User clicks on Continue button
    Then User account should get warning message about duplicate email
    
  Scenario: User creates account without filling any details.
    Given User navigates to register account page.
    When User dont enter any details into fields.
    And User clicks on Continue button
    Then User should get warning message for all the mandatory fields.
