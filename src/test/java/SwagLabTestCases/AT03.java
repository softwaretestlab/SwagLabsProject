package SwagLabTestCases;

import common.AssertResponse;
import org.junit.Test;
import pages.cardPage;
import pages.homePage;
import pages.shopPage;

import java.io.IOException;

import static BaseClass.openBrowser.NavToWebsite;
import static BaseClass.openBrowser.driver;
import static org.junit.Assert.assertTrue;

public class AT03 {
    @Test
    public void at01() throws IOException, InterruptedException {
        //Navigate to homepage
        NavToWebsite("HomePageUrl");
        //homePage object creation
        homePage hPage = new homePage(driver);
        //click shopping button
        hPage.StartShoppingBtn();
        //shopPage object creation
        shopPage sPage = new shopPage(driver);
        //price of each item
        String ShopFrogPrice=sPage.StuffFrogprice();
        System.out.println("FrogPrice : "+ShopFrogPrice);
        String ShopFluffyBunnyPrice=sPage.FluffyBunnyprice();
        System.out.println("FluffyBunnyPrice : "+ShopFluffyBunnyPrice);
        String ShopBearPrice=sPage.ValBearprice();
        System.out.println("BearPrice : "+ShopBearPrice);
        //Click on each item
        sPage.StuffFrogBuyBtn();
        sPage.FluffyBunnyBuyBtn();
        sPage.ValBearBuyBtn();
        //Click on cart
        sPage.CartBtnClick();
        //-----------------CartPage------------------------------
        //Match price from Contact Page with CartPage
        cardPage crdPg= new cardPage(driver);
        String CartStuffedFrogPrice=crdPg.StuffedFrogPrice();
        String CartFluffyBunnyPrice=crdPg.FluffyBunnyPrice();
        String CartValentineBearPrice=crdPg.ValentineBearPrice();
        AssertResponse.VerifyMsg(ShopFrogPrice,CartStuffedFrogPrice);
        AssertResponse.VerifyMsg(ShopFluffyBunnyPrice,CartFluffyBunnyPrice);
        AssertResponse.VerifyMsg(ShopBearPrice,CartValentineBearPrice);

        //Update quantity
        crdPg.StuffedFrogQuantity("2");
        crdPg.FluffyBunnyQuantity("5");
        crdPg.ValentineBearQuantity("3");

        //calculated Price*Quantity
        String a = CartStuffedFrogPrice.substring(1,CartStuffedFrogPrice.length());
        double CartStuffedFrogPriceTimesVal = (Double.parseDouble(a)*2);
        System.out.println("CartStuffedFrogPriceTimesVal : "+CartStuffedFrogPriceTimesVal);

        String b = CartFluffyBunnyPrice.substring(1,CartFluffyBunnyPrice.length());
        double CartFluffyBunnyPriceTimesVal = (Double.parseDouble(b)*5);
        System.out.println("CartFluffyBunnyPriceTimesVal : "+CartFluffyBunnyPriceTimesVal);

        String c = CartValentineBearPrice.substring(1,CartValentineBearPrice.length());
        double CartValentineBearPriceTimesVal = (Double.parseDouble(c)*3);
        System.out.println("CartValentineBearPriceTimesVal : "+CartValentineBearPriceTimesVal);


        //remove $ from start of subtotal
        String d=crdPg.StuffedFrogSubTotal();
        double StuFrgSbTtl=Double.parseDouble(d.substring(1,d.length()));
        System.out.println("StuFrgSbTtl : "+StuFrgSbTtl);
        String e=crdPg.FluffyBunnySubTotal();
        double FlufBunSbTtl=Double.parseDouble(e.substring(1,e.length()));
        String f=crdPg.ValentineBearSubTotal();
        double ValBrSbTtl=Double.parseDouble(f.substring(1,f.length()));

        //Price*Quantity = Subtotal
        AssertResponse.VerifyMsg(CartStuffedFrogPriceTimesVal,StuFrgSbTtl);
        AssertResponse.VerifyMsg(CartFluffyBunnyPriceTimesVal,FlufBunSbTtl);
        AssertResponse.VerifyMsg(CartValentineBearPriceTimesVal,ValBrSbTtl);

        //total=Sum(SubTotal)
        String g=crdPg.FinalTotal();
        double FinalTotal=Double.parseDouble(g.substring(7,g.length()));
        double SumOfSubtotal=(StuFrgSbTtl+FlufBunSbTtl+ValBrSbTtl);
        AssertResponse.VerifyMsg(FinalTotal,SumOfSubtotal);

        driver.quit();
    }
}
