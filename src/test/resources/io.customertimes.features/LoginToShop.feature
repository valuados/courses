Feature: LoginToShop

  Scenario: Login to Shop
    Given User goes to login page
    When User enters email "valuados1@gmail.com" and password "jbCgXyoC"
    And User clicks on login button
    Then User "valuados1@gmail.com" should be logged to application