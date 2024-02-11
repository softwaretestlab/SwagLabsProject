package pages;

import BaseClass.openBrowser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class shopPage extends openBrowser {
    // this is how we store the locator of the webelement


    @FindBy(xpath="//*[@id='product-2']/div/p/span")
    WebElement StuffFrogprice;

    @FindBy(xpath="//*[@id='product-2']/div/p/a")
    WebElement StuffFrogBuyBtn;

    @FindBy(xpath="//*[@id='product-4']/div/p/span")
    WebElement FluffyBunnyprice;

    @FindBy(xpath="//*[@id='product-4']/div/p/a")
    WebElement FluffyBunnyBuyBtn;

    @FindBy(xpath="//*[@id='product-7']/div/p/span")
    WebElement ValBearprice;

    @FindBy(xpath="//*[@id='product-7']/div/p/a")
    WebElement ValBearBuyBtn;

    @FindBy(xpath="//*[contains(text(),'Cart')]")
    WebElement CartBtnClick;

    public shopPage(WebDriver d) {
        driver = d;
        PageFactory.initElements(d, this);
    }
// FirstName

    public String StuffFrogprice(){
        String StuffFrogpricetxt=StuffFrogprice.getText();
        return StuffFrogpricetxt;
    }
    public String FluffyBunnyprice(){
        String FluffyBunnypricetxt=FluffyBunnyprice.getText();
        return FluffyBunnypricetxt;
    }
    public String ValBearprice(){
        String ValBearpricetxt=ValBearprice.getText();
        return ValBearpricetxt;
    }
    public void StuffFrogBuyBtn(){
    StuffFrogBuyBtn.click();
            }
    public void FluffyBunnyBuyBtn(){
        FluffyBunnyBuyBtn.click();
          }
      public void ValBearBuyBtn(){
       ValBearBuyBtn.click();
            }
    public void CartBtnClick(){
        CartBtnClick.click();
    }

}

