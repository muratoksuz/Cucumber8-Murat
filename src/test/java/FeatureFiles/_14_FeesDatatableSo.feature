Feature: Fees Functionality


  Background:

    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login successfully

    @SmokeTest
  Scenario Outline: Fees with Datatable
    And Click on the Element LeftNav
      | setup      |
      | parameters |
      | fees       |

    And Click on the Element Dialog
      | addButton |

    And User sending the keys in Dialog
      | nameInput   | <name>     |
      | codeInput   | <code>     |
      | feeIntCode  | <intcode>  |
      | feePriority | <priority> |

    And User sending the Enter keys in Dialog

    And Click on the Element Dialog
      | saveButton |

    Then Success message should be displayed

    And User sending the Escape keys in Dialog

    And User delete the element from dialog
      | <name> |



    Examples:
      | name      | code | intcode | priority |
      | MuratPay1 | MP1  | 1111    | 111111   |
      | MuratPay2 | MP2  | 2222    | 222222   |
      | MuratPay3 | MP3  | 3333    | 333333   |
      | MuratPay4 | MP4  | 4444    | 444444   |
      | MuratPay5 | MP5  | 5555    | 555555   |

