Feature: Country Multi Scenario

  Background:
    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login successfully


  Scenario: Create a country
    And Navigate to country
    When Create a country
    Then Success message should be displayed

  Scenario: Create a Citizenship
    And Navigate to citizenship
    When Create a citizenship
    Then Success message should be visible
