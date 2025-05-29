Feature: Country Multi Scenario

  Background:
    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login successfully
    And Navigate to country

  Scenario: Create a country
    When Create a country
    Then Success message should be displayed

  Scenario: Create a country
    When Create a country name as "murUlk1" code as "MurUlk1Kod1"
    Then Success message should be displayed