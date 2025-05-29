Feature: Country Multi Scenario

  Background:
    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login successfully
    And Navigate to country

  Scenario Outline: Create a country

    When Create a country name as "<name>" code as "<code>"
    Then Success message should be displayed

    When Create a country name as "<name>" code as "<code>"
    Then UnSuccess message should be visible

    When Delete a country code of "<name>"
    Then Deleted message should be visible

    Examples:
      |name  | code|
      |murtt1  | mtt1|
      #|murtt2  | mtt2|
      #|murtt3  | mtt3|
      #|murtt4  | mtt4|
      #|murtt5  | mtt5|