Feature: Product Order

Background:
    Given Navigate to the website
    When Enter email as "tteam.5.techno@gmail.com" and password as "TeamFive5*"
    Then Welcome message should be displayed

Scenario: Order Product
  Given Choose product after login
  And Observe product in basket and change the amounts
  Then Enter the payment info
  Then Order success message should be observed
