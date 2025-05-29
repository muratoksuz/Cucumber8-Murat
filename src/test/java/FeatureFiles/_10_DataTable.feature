Feature: Datatable Functionality

  Background:
    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login successfully


  Scenario: Country Functionality
    And Click on the Element LeftNav
      | setup       |
      | parameters  |
      | countries |


    And Click on the Element Dialog
      | addButton |


    And  User sending the keys in Dialog
    |nameInput|murUlk1|
    |codeInput|murcd1|

    And Click on the Element Dialog
      | saveButton |

  Scenario: Create Nationality Functionality

    And Click on the Element LeftNav
      | setup         |
      | parameters    |
      | nationalities |

    And Click on the Element Dialog
      | addButton |

    And User sending the keys in Dialog
      | nameInput | muratNat1971 |

    And User sending the Enter keys in Dialog


    And Click on the Element Dialog
      | saveButton |

    Then Success message should be displayed

    And User delete the element from dialog
      | muratNat1971 |



    Scenario: Citizenship Functionality
      And Click on the Element LeftNav
        | setup         |
        | parameters    |
        | citizenship |

      And Click on the Element Dialog
        | addButton |

      And  User sending the keys in Dialog
        |nameInput|murCitz1|
        |shortName|murCT1|

      And Click on the Element Dialog
        | saveButton |

      Then Success message should be displayed

      And User delete the element from dialog
        | murCitz1 |