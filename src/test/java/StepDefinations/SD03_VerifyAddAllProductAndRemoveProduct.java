package StepDefinations;

import BaseClass.openBrowser;
import SwagLabTestCases.AT03_VerifyAddAllProductAndRemoveProduct;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.io.IOException;

public class SD03_VerifyAddAllProductAndRemoveProduct {

    @Given("user on product page and here click on AToZ filter and verify that each item is sorted by name in AToZ order")
    public void user_on_product_page_and_here_click_on_a_to_z_filter_and_verify_that_each_item_is_sorted_by_name_in_a_to_z_order() throws IOException {
        AT03_VerifyAddAllProductAndRemoveProduct obj = new AT03_VerifyAddAllProductAndRemoveProduct();
        obj.verifySortAToZ();

    }
    @Then("click on ZToA filter and verify that each item is sorted by name in ZToA order")
    public void click_on_z_to_a_filter_and_verify_that_each_item_is_sorted_by_name_in_z_to_a_order() throws IOException {
        AT03_VerifyAddAllProductAndRemoveProduct obj = new AT03_VerifyAddAllProductAndRemoveProduct();
        obj.verifySortZToA();
    }
    @Then("click on LowToHigh filter and verify that each item is sorted by price in LowToHigh order")
    public void click_on_low_to_high_filter_and_verify_that_each_item_is_sorted_by_price_in_low_to_high_order() throws IOException {
        AT03_VerifyAddAllProductAndRemoveProduct obj = new AT03_VerifyAddAllProductAndRemoveProduct();
        obj.verifyHighToLow();
    }
    @Then("click on HighToLow filter and verify that each item is sorted by price in HighToLow order")
    public void click_on_high_to_low_filter_and_verify_that_each_item_is_sorted_by_price_in_high_to_low_order() throws IOException {
        AT03_VerifyAddAllProductAndRemoveProduct obj = new AT03_VerifyAddAllProductAndRemoveProduct();
        obj.verifyLowToHigh();
        openBrowser.driver.quit();
    }

}
