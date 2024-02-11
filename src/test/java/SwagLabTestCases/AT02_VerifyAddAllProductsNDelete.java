package SwagLabTestCases;

import BaseClass.openBrowser;
import PropertiesFile.ReadPropertiesFile;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

public class AT02_VerifyAddAllProductsNDelete extends openBrowser {
    @Test
    public void LoginToWebsite() throws IOException, InterruptedException {
        NavToWebsite(ReadPropertiesFile.PropFile("LoginPageUrl"));
        driver.findElement(By.id("user-name")).sendKeys(ReadPropertiesFile.PropFile("username"));
        driver.findElement(By.id("password")).sendKeys(ReadPropertiesFile.PropFile("password"));
        driver.findElement(By.id("login-button")).click();
    }
        //-----------Product page -->all items, add to cart -----------------
    @Test
    public void AddAllItemsToCart() {
        List<WebElement> AddToCart = driver.findElements(By.xpath("//button[contains(text(),'Add to cart')]"));
        int AddToCartSize = AddToCart.size();

        for (int i = 0; i < AddToCartSize; i++) {

            //Product page --> item add to cart
            AddToCart.get(i).click();
        }
    }
    @Test
    public void NavToCartPage() {
        //---------------------Click on Cart to navigate to "your cart" page-------------------
        driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).click();
    }
    @Test
    public void RmAllItemsNVerifyRm(){
    //------------Cart page- remove all items and verify all items removed--------
        List<WebElement> RemoveBtn = driver.findElements(By.xpath("//*[@class='btn btn_secondary btn_small cart_button']"));
        int RemoveBtnCnt=RemoveBtn.size();

        for (int i = 0; i < RemoveBtnCnt; i++) {
            //Product page --> item add to cart
            RemoveBtn.get(i).click();
        }
        //this block of code proves cart is empty (element not present) meaning all items are removed

        try{
            driver.findElement(By.xpath("//*[@class='shopping_cart_badge']"));
            //Since, no exception, so element is present
            System.out.println("Element present");
        }catch(NoSuchElementException e){
            //Element is not present
            System.out.println("Element not present");
        }
        driver.quit();
    }
}