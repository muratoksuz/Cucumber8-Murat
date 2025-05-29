Feature: ApachePOI Citizen Utility

  Background:
    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login successfully
    And Navigate to citizenship

  Scenario: Create and Delete CitizenShip from Excel
    When User create a citizenship with ApachePOI
    Then User delete a citizenship with ApachePOI