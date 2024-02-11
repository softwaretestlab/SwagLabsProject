package StepDefinations;

import SwagLabTestCases.AT02_VerifyAddAllProductsNDelete;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class SD02_AT02_VerifyAddAllProductsNDelete {
    @Given("user on product page and here add all items to cart")
    public void user_on_product_page_and_here_add_all_items_to_cart() {
        AT02_VerifyAddAllProductsNDelete obj = new AT02_VerifyAddAllProductsNDelete();
        obj.AddAllItemsToCart();
    }
    @Given("Click on Cart to navigate to the cart page")
    public void click_on_cart_to_navigate_to_the_cart_page() {
        AT02_VerifyAddAllProductsNDelete obj = new AT02_VerifyAddAllProductsNDelete();
        obj.NavToCartPage();
    }
    @Then("on Cart page remove all items and verify all items removed")
    public void on_cart_page_remove_all_items_and_verify_all_items_removed() {
        AT02_VerifyAddAllProductsNDelete obj = new AT02_VerifyAddAllProductsNDelete();
        obj.RmAllItemsNVerifyRm();
    }
}
