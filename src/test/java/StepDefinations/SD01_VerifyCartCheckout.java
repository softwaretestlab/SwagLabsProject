package StepDefinations;

import BaseClass.openBrowser;
import SwagLabTestCases.AT01_VerifyCartCheckout;
import PropertiesFile.ReadPropertiesFile;
import common.AssertResponse;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import java.io.IOException;

public class SD01_VerifyCartCheckout extends openBrowser {
    @Before(order=1)
    @Given("Open Browser and Navigate To Page")
    public void open_browser_and_navigate_to_page() throws IOException {
        NavToWebsite(ReadPropertiesFile.PropFile("LoginPageUrl"));
    }
    @Before(order=2)
    @When("Input Username")
    public void input_username() throws IOException {
        driver.findElement(By.id("user-name")).sendKeys(ReadPropertiesFile.PropFile("username"));
    }
    @Before(order=3)
    @When("Input Password")
    public void input_password() throws IOException {
        driver.findElement(By.id("password")).sendKeys(ReadPropertiesFile.PropFile("password"));
    }
    @Before(order=4)
    @When("Submit Credentials")
    public void submit_credentials() {
        driver.findElement(By.id("login-button")).click();

    }
    @Before(order=5)
    @Then("Welcome Page Should Be Open")
    public void welcome_page_should_be_open() throws IOException {
       String ActualText =driver.findElement(By.xpath("//*[contains(text(),'Products')]")).getText();
       String ExpectedText = "Products";
        AssertResponse.VerifyMsg(ReadPropertiesFile.PropFile("ExpectedText"),ActualText);

    }

    @Given("user on product page and here capture item name and price and add item to cart")
    public void user_on_product_page_and_here_capture_item_name_and_price_and_add_item_to_cart() throws IOException {
        AT01_VerifyCartCheckout obj = new AT01_VerifyCartCheckout();
        obj.addProductToCart();
    }
    @Then("Click on Cart to navigate to cart page")
    public void click_on_cart_to_navigate_to_cart_page() {
        AT01_VerifyCartCheckout obj = new AT01_VerifyCartCheckout();
        obj.ClickOnMiniCart();
    }
    @Then("On Cart page capture item name and price and compare with product page item name and price and both should match")
    public void on_cart_page_capture_item_name_and_price_and_compare_with_product_page_item_name_and_price_and_both_should_match() throws IOException {
        AT01_VerifyCartCheckout obj = new AT01_VerifyCartCheckout();
        obj.comparePrdpgeNCartPge();
        driver.quit();
    }


}
