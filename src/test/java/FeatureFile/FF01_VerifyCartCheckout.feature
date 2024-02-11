Feature: Checkout function
  @FunctionalTest
  Scenario: Verify Cart Checkout
    Given user on product page and here capture item name and price and add item to cart
    Then Click on Cart to navigate to cart page
    Then On Cart page capture item name and price and compare with product page item name and price and both should match