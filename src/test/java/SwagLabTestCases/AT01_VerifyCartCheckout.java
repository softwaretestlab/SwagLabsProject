package SwagLabTestCases;

import BaseClass.openBrowser;
import PropertiesFile.ReadPropertiesFile;
import common.AssertResponse;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class AT01_VerifyCartCheckout extends openBrowser {

    @Test
    public void verifySortAToZ() throws IOException {
        NavToWebsite(ReadPropertiesFile.PropFile("LoginPageUrl"));
        driver.findElement(By.id("user-name")).sendKeys(ReadPropertiesFile.PropFile("username"));
        driver.findElement(By.id("password")).sendKeys(ReadPropertiesFile.PropFile("password"));
        driver.findElement(By.id("login-button")).click();
    }

    @Test
    public void addProductToCart( ) throws IOException {
        //------------------------------Add product to cart and capture product name and price---------------------------------
        //Product page -->list of item
        List<WebElement> PrdName = driver.findElements(By.xpath("//*[@class='inventory_item_name ']"));
        //Product page -->all items cost
        List<WebElement> PrdAmt = driver.findElements(By.xpath("//*[@class='inventory_item_price']"));
        //Product page -->all items, add to cart buttons
        List<WebElement> AddToCart = driver.findElements(By.xpath("//button[contains(text(),'Add to cart')]"));
        int AddToCartSize = AddToCart.size();


        for (int i = 0; i < AddToCartSize; i++) {
            //Product page -->First item name
           String PrdNameTxt = PrdName.get(i).getText();
            System.out.println("PrdNameTxt : " + PrdNameTxt);
            Properties pro = new Properties();
            pro.put("PrdNameTxt",PrdNameTxt);
            //Product page -->First item cost
            String PrdAmtTxt = PrdAmt.get(i).getText();
            System.out.println("PrdAmtTxt : " + PrdAmtTxt);
            pro.put("PrdAmtTxt",PrdAmtTxt);
            FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"\\src\\main\\java\\PropertiesFile\\TestData.properties", false);
            pro.store(file,"This is my property file");
            //Product page -->First item add to cart
            AddToCart.get(i).click();
            break;
        }

    }
    //------------------------------Click on Cart to navigate to "your cart" page------
    @Test
    public void ClickOnMiniCart() {

        //Click on Cart to navigate to "your cart" page
        driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).click();
    }
    //------------------------------On CartPage capture item name and price and compare with product page itemname and price------
    @Test
    public void comparePrdpgeNCartPge() throws IOException {
        //Your Cart page-->Get Added item name
        String AddPrdNameTxt = driver.findElement(By.xpath("//*[contains(text(),'Sauce Labs Backpack')]")).getText();
        System.out.println("AddPrdNameTxt : "+AddPrdNameTxt);
        //Your Cart page-->Get Added item price
        String AddPrdAmtTxt = driver.findElement(By.xpath("//*[@class='inventory_item_price']")).getText();
        System.out.println("AddPrdAmtTxt : "+AddPrdAmtTxt);
        AT01_VerifyCartCheckout obj = new AT01_VerifyCartCheckout();
        //From product page and "Your Cart" page -->Item names should match
         AssertResponse.VerifyMsg(ReadPropertiesFile.TestDataPropFile("PrdNameTxt"), AddPrdNameTxt);
         //From product page and "Your Cart" page -->Item price should match
         AssertResponse.VerifyMsg(ReadPropertiesFile.TestDataPropFile("PrdAmtTxt"), AddPrdAmtTxt);


    }



}