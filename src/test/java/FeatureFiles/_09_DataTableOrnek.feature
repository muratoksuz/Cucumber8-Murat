Feature: Datatable ornek

  Scenario: User List

    When write username "murat"
    And write username and password "murat" and "1234"

    And write username as Datatable
      | murat   |
      | Mehmet  |
      | Ayse    |
      | İbrahim |
      | Esma    |

    And write username and password as Datatable
      | murat   | 1234 |
      | Mehmet  | 4567 |
      | Ayse    | 789  |
      | İbrahim | 3333 |
      | Esma    | 6666 |



