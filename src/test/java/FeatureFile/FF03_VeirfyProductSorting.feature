Feature: Filter function
  @FunctionalTest
  Scenario: Verify Product Sorting
    Given user on product page and here click on AToZ filter and verify that each item is sorted by name in AToZ order
    Then click on ZToA filter and verify that each item is sorted by name in ZToA order
    Then click on LowToHigh filter and verify that each item is sorted by price in LowToHigh order
    Then click on HighToLow filter and verify that each item is sorted by price in HighToLow order