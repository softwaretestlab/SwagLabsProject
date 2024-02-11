package SwagLabTestCases;

import BaseClass.openBrowser;
import PropertiesFile.ReadPropertiesFile;
import common.AssertResponse;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.io.IOException;
import java.util.List;

public class AT03_VerifyAddAllProductAndRemoveProduct extends openBrowser {
   // ---------------------------verifySortAToZ------------------------------------
    @Test
    public void verifySortAToZ() throws IOException {
//        NavToWebsite(ReadPropertiesFile.PropFile("LoginPageUrl"));
//        driver.findElement(By.id("user-name")).sendKeys(ReadPropertiesFile.PropFile("username"));
//        driver.findElement(By.id("password")).sendKeys(ReadPropertiesFile.PropFile("password"));
//        driver.findElement(By.id("login-button")).click();
        Select FilterList = new Select(driver.findElement(By.xpath("//*[@class='product_sort_container']")));
        int FilterSize = FilterList.getOptions().size();
        System.out.println("FilterSize" + FilterSize);
        for (int i = 0; i < FilterSize; i++) {
            String FilterName = FilterList.getOptions().get(i).getText();
            System.out.println("FilterName" + FilterName);
            FilterList.getOptions().get(i).click();
            System.out.println("myFilterName" + FilterName);
            String FName = "Name (A to Z)";
            if (FilterName.contains(FName)) {
                List<WebElement> DefaultSorted = driver.findElements(By.xpath("//div[@class='inventory_item_name ']"));
                int DefaultSortedSize = DefaultSorted.size();
                String[] ActItemName = {"Sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt", "Sauce Labs Fleece Jacket", "Sauce Labs Onesie", "Test.allTheThings() T-Shirt (Red)"};
                for (int j = 0; j < DefaultSortedSize; j++) {
                    String ExpItemName = DefaultSorted.get(j).getText();
                    AssertResponse.VerifyMsg(ExpItemName, ActItemName[j]);
                    System.out.println("ExpItemName : " + ExpItemName);

                }
                break;
            }
        }

    }

    // ---------------------------verifySortZToA------------------------------------
    @Test
    public void verifySortZToA() throws IOException {
//        NavToWebsite(ReadPropertiesFile.PropFile("LoginPageUrl"));
//        driver.findElement(By.id("user-name")).sendKeys(ReadPropertiesFile.PropFile("username"));
//        driver.findElement(By.id("password")).sendKeys(ReadPropertiesFile.PropFile("password"));
//        driver.findElement(By.id("login-button")).click();
        Select FilterList = new Select(driver.findElement(By.xpath("//*[@class='product_sort_container']")));
        int FilterSize = FilterList.getOptions().size();
        System.out.println("FilterSize" + FilterSize);
        for (int i = 0; i < FilterSize; i++) {
            String FilterName = FilterList.getOptions().get(i).getText();
            System.out.println("FilterName" + FilterName);
            FilterList.getOptions().get(i).click();
            System.out.println("myFilterName"+FilterName);
            String FName= "Name (Z to A)";
            if(FilterName.contains(FName)){
                List<WebElement> DefaultSorted = driver.findElements(By.xpath("//div[@class='inventory_item_name ']"));
                int DefaultSortedSize = DefaultSorted.size();
                String[] ActItemName={"Test.allTheThings() T-Shirt (Red)","Sauce Labs Onesie","Sauce Labs Fleece Jacket","Sauce Labs Bolt T-Shirt","Sauce Labs Bike Light","Sauce Labs Backpack"};
                for (int j = 0; j < DefaultSortedSize; j++) {
                    String ExpItemName = DefaultSorted.get(j).getText();
                    AssertResponse.VerifyMsg(ExpItemName,ActItemName[j]);
                    System.out.println("ExpItemName : " + ExpItemName);

                }
                break;
            }
        }

    }

    //--------------------------verifyLowToHigh------------------------------------
    @Test
    public void verifyLowToHigh() throws IOException {
//        NavToWebsite(ReadPropertiesFile.PropFile("LoginPageUrl"));
//        driver.findElement(By.id("user-name")).sendKeys(ReadPropertiesFile.PropFile("username"));
//        driver.findElement(By.id("password")).sendKeys(ReadPropertiesFile.PropFile("password"));
//        driver.findElement(By.id("login-button")).click();
        Select FilterList = new Select(driver.findElement(By.xpath("//*[@class='product_sort_container']")));
        int FilterSize = FilterList.getOptions().size();
        System.out.println("FilterSize" + FilterSize);
        for (int i = 0; i < FilterSize; i++) {
            String FilterName = FilterList.getOptions().get(i).getText();
            System.out.println("FilterName" + FilterName);
            String FName= "Price (low to high)";
            if(FilterName.contains(FName)){
                FilterList.getOptions().get(i).click();
                List<WebElement> DefaultSorted = driver.findElements(By.xpath("//*[@class='inventory_item_price']"));
                int DefaultSortedSize = DefaultSorted.size();
                String[] ActItemName={"7.99","$9.99","$15.99","$15.99","29.99","49.99"};
                for (int j = 0; j < DefaultSortedSize; j++) {
                    String ExpItemName = DefaultSorted.get(j).getText();
                    AssertResponse.VerifyMsg(ExpItemName,ActItemName[j]);
                    System.out.println("ExpItemName : " + ExpItemName);

                }
                break;
            }
            }

            }
    //--------------------------verifyHighToLow------------------------------------
    @Test
    public void verifyHighToLow() throws IOException {
//        NavToWebsite(ReadPropertiesFile.PropFile("LoginPageUrl"));
//        driver.findElement(By.id("user-name")).sendKeys(ReadPropertiesFile.PropFile("username"));
//        driver.findElement(By.id("password")).sendKeys(ReadPropertiesFile.PropFile("password"));
//        driver.findElement(By.id("login-button")).click();
        Select FilterList = new Select(driver.findElement(By.xpath("//*[@class='product_sort_container']")));
        int FilterSize = FilterList.getOptions().size();
        System.out.println("FilterSize" + FilterSize);
        for (int i = 0; i < FilterSize; i++) {
            String FilterName = FilterList.getOptions().get(i).getText();
            System.out.println("FilterName" + FilterName);
            String FName= "Price (high to low)";
            if(FilterName.contains(FName)){
                FilterList.getOptions().get(i).click();
                List<WebElement> DefaultSorted = driver.findElements(By.xpath("//*[@class='inventory_item_price']"));
                int DefaultSortedSize = DefaultSorted.size();
                String[] ActItemName={"$49.99","$29.99","$15.99","$15.99","$9.99","$7.99"};
                for (int j = 0; j < DefaultSortedSize; j++) {
                    String ExpItemName = DefaultSorted.get(j).getText();
                    AssertResponse.VerifyMsg(ExpItemName,ActItemName[j]);
                    System.out.println("ExpItemName : " + ExpItemName);

                }
                break;
            }
        }

    }
}
