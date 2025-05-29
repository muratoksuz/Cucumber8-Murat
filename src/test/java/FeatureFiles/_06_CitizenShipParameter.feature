Feature: Citizenship Functionality

  Background:
    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login successfully
    And Navigate to citizenship


  Scenario: Create a Citizenship with Parameter
    When Create a citizenship name as "murti" code as "mur1234"
    Then Success message should be visible


  Scenario: Create a Citizenship with Parameter Negative
    When Create a citizenship name as "murti" code as "mur1234"
    Then UnSuccess message should be visible


  Scenario: Delete Citizenship
    When Delete a citizenship code of "mur1234"
    Then Deleted message should be visible