# Login fonksiyon kontrolü
# Önce siteye git(driver.get)
# Sonra login bilgilerini gir(username password sendkeys)
# Sonra giriş yaptığını kontrol et


  Feature: Login functionality

    @SmokeTest @Regression
    Scenario: Login with valid username and password

      Given Navigate to Campus
      When Enter username and password and click login button
      Then User should login successfully



