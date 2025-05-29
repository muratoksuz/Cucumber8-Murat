Feature: Nationality Functionality

  Background:

    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login successfully

  Scenario Outline: Nationality Outline Test
    And Click on the Element LeftNav
      | setup       |
      | parameters  |
      | nationalities |

    And Click on the Element Dialog
      | addButton |

    And User sending the keys in Dialog
      | nameInput | <name> |

    And User sending the Enter keys in Dialog

    And Click on the Element Dialog
      | saveButton |

    Then Success message should be displayed

    And User delete the element from dialog
      | <name> |
    Examples:
      | name     |
      | murULKE1 |
      | murULKE2 |
      | murULKE3 |
      | murULKE4 |
      | murULKE5 |

