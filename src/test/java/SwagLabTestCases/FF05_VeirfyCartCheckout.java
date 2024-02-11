package SwagLabTestCases;

import BaseClass.openBrowser;
import PropertiesFile.ReadPropertiesFile;
import common.AssertResponse;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

public class FF05_VeirfyCartCheckout extends openBrowser {
    @Test
    public void verifySortAToZ() throws IOException {
        NavToWebsite(ReadPropertiesFile.PropFile("LoginPageUrl"));
        driver.findElement(By.id("user-name")).sendKeys(ReadPropertiesFile.PropFile("username"));
        driver.findElement(By.id("password")).sendKeys(ReadPropertiesFile.PropFile("password"));
        driver.findElement(By.id("login-button")).click();
        //------------------------------Add product to cart and verify---------------------------------
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
            System.out.println("PrdNameTxt : "+PrdNameTxt);
            //Product page -->First item cost
            String PrdAmtTxt = PrdAmt.get(i).getText();
            System.out.println("PrdAmtTxt : "+PrdAmtTxt);
            //Product page -->First item add to cart
            AddToCart.get(i).click();

            //Click on Cart to navigate to "your cart" page
            driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).click();
            //Your Cart page-->Get Added item name
            String AddPrdNameTxt = driver.findElement(By.xpath("//*[contains(text(),'Sauce Labs Backpack')]")).getText();
            System.out.println("AddPrdNameTxt : "+AddPrdNameTxt);
            //Your Cart page-->Get Added item price
            String AddPrdAmtTxt = driver.findElement(By.xpath("//*[@class='inventory_item_price']")).getText();
            System.out.println("AddPrdAmtTxt : "+AddPrdAmtTxt);


            //From product page and "Your Cart" page -->Item names should match
            AssertResponse.VerifyMsg(PrdNameTxt, AddPrdNameTxt);
            //From product page and "Your Cart" page -->Item price should match
            AssertResponse.VerifyMsg(PrdAmtTxt, AddPrdAmtTxt);
          //  return(PrdNameTxt,PrdNameTxt,PrdAmtTxt,AddPrdAmtTxt);
            break;
        }

    }
}