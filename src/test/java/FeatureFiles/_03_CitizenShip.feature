Feature: Citizenship Functionality
  @SmokeTest
  Scenario: Create a Citizenship
    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login successfully
    And Navigate to citizenship
    When Create a citizenship
    Then Success message should be visible
