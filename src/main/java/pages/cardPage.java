package pages;

import BaseClass.openBrowser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class cardPage extends openBrowser {
    //price
    @FindBy(xpath = "/html/body/div[2]/div/form/table/tbody/tr[1]/td[2]")
    WebElement StuffedFrogPrice;
    @FindBy(xpath = "/html/body/div[2]/div/form/table/tbody/tr[2]/td[2]")
    WebElement FluffyBunnyPrice;
    @FindBy(xpath = "/html/body/div[2]/div/form/table/tbody/tr[3]/td[2]")
    WebElement ValentineBearPrice;
    //Quantity
    @FindBy(xpath = "/html/body/div[2]/div/form/table/tbody/tr[1]/td[3]/input")
    WebElement StuffedFrogQuantity;
    @FindBy(xpath = "/html/body/div[2]/div/form/table/tbody/tr[2]/td[3]/input")
    WebElement FluffyBunnyQuantity;
    @FindBy(xpath = "/html/body/div[2]/div/form/table/tbody/tr[3]/td[3]/input")
    WebElement ValentineBearQuantity;
    //SubTotal
    @FindBy(xpath = "/html/body/div[2]/div/form/table/tbody/tr[1]/td[4]")
    WebElement StuffedFrogSubTotal;
    @FindBy(xpath = "/html/body/div[2]/div/form/table/tbody/tr[2]/td[4]")
    WebElement FluffyBunnySubTotal;
    @FindBy(xpath = "/html/body/div[2]/div/form/table/tbody/tr[3]/td[4]")
    WebElement ValentineBearSubTotal;
    //total
    @FindBy(xpath = "/html/body/div[2]/div/form/table/tfoot/tr[1]/td/strong")
    WebElement FinalTotal;

    public cardPage(WebDriver d) {
        driver = d;
        PageFactory.initElements(d, this);
    }
    // Price
    public String StuffedFrogPrice() {
        String StuffedFrgPrice = StuffedFrogPrice.getText();
        return StuffedFrgPrice;
    }
    public String FluffyBunnyPrice() {
        String FluffyBnyPrice = FluffyBunnyPrice.getText();
        return FluffyBnyPrice;
    }
    public String ValentineBearPrice() {
        String ValentineBrPrice = ValentineBearPrice.getText();
        return ValentineBrPrice;
    }
    //Quantity
    public void StuffedFrogQuantity(String StuffedFrogQty) {
                StuffedFrogQuantity.clear();
                StuffedFrogQuantity.sendKeys(StuffedFrogQty);
    }
    public void FluffyBunnyQuantity(String FluffyBunnyQty) {
        FluffyBunnyQuantity.clear();
        FluffyBunnyQuantity.sendKeys(FluffyBunnyQty);
    }
    public void ValentineBearQuantity(String ValentineBearQty) {
        ValentineBearQuantity.clear();
        ValentineBearQuantity.sendKeys(ValentineBearQty);
    }
    //SubTotal
    public String StuffedFrogSubTotal() {
        String StuffedFrogSubTtl = StuffedFrogSubTotal.getText();
        return StuffedFrogSubTtl;
    }
    public String FluffyBunnySubTotal() {
        String FluffyBunnySubTtl = FluffyBunnySubTotal.getText();
        return FluffyBunnySubTtl;
    }
    public String ValentineBearSubTotal() {
        String ValentineBearSubTtl = ValentineBearSubTotal.getText();
        return ValentineBearSubTtl;
    }
    //total
    public String FinalTotal() {
        String FinalTtl = FinalTotal.getText();
        return FinalTtl;
    }
}

