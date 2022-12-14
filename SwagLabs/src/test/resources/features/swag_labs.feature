#Author carlos.hincapie@sqasa.co

  Feature: But a item in Swag Lab
    ##Me as a user, I want to buy a item to verify the correct functioning of the page

  Background: Login in Swag Labs
    Given that "user" is on the web
    When "userA" logs in with his

  Scenario: See a product
    Then selects a product and should see a product on the page

  Scenario: Buy a product
    When adds a product in the cart and buys the product "userA"
    Then should see a msg saying that product is paid