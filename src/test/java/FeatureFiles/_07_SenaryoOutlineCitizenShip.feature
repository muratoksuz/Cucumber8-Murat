Feature: Citizenship Functionality

  Background:
    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login successfully
    And Navigate to citizenship

  @Regression
  Scenario Outline: Create a Citizenship with Parameter
    When Create a citizenship name as "<name>" code as "<shortName>"

    Then Success message should be visible
    When Create a citizenship name as "<name>" code as "<shortName>"

    Then UnSuccess message should be visible
    When Delete a citizenship code of "<shortName>"
    Then Deleted message should be visible
    Examples:
      |name  |shortName|
      |muratCC1  |murc1|
      |muratCC2  |murc2|
      #|muratCC3  |murc3|
      #|muratCC4  |murc4|

