Feature: DataTable-Senaryo Outline Functionality

  Background:
    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login successfully

  Scenario Outline: Citizenship Functionality
    And Click on the Element LeftNav
      | setup         |
      | parameters    |
      | citizenship |

    And Click on the Element Dialog
      | addButton |

    And  User sending the keys in Dialog
      |nameInput|<name>|
      |shortName|<shortName>|

    And Click on the Element Dialog
      | saveButton |

    Then Success message should be displayed

    And User delete the element from dialog
      | <name> |
    Examples:
      |name  | shortName|
      |MurCitz1  | murCT1|
      |MurCitz2  | murCT2|
      |MurCitz3  | murCT3|
      |MurCitz4  | murCT4|
      |MurCitz5  | murCT5|