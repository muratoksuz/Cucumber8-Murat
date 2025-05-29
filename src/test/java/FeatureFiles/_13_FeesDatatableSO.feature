Feature: Fee Functionality

  Background:

    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login successfully

    @Regression
  Scenario: Fee Outline Test

    And Click on the Element LeftNav
      | setup       |
      | parameters  |
      | fees |

    And Click on the Element Dialog
      | addButton |

    And User sending the keys in Dialog
      | nameInput | MuratPay |
      | codeInput | MP |
      | feeIntCode | 11 |
      | feePriority | 1 |

    And User sending the Enter keys in Dialog

    And Click on the Element Dialog
      | saveButton |

    Then Success message should be displayed

    And User sending the Escape keys in Dialog

    And User delete the element from dialog
      | nameInput | MuratPay |