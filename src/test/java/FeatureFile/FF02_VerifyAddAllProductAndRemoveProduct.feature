Feature: Add to cart functionality
  @FunctionalTest
  Scenario: Verify add all products and remove products
    Given user on product page and here add all items to cart
    And Click on Cart to navigate to the cart page
    Then on Cart page remove all items and verify all items removed