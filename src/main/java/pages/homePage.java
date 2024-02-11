package pages;

import BaseClass.openBrowser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePage extends openBrowser {

    @FindBy(xpath="//h1[contains(text(),'Jupiter Toys')]")
     WebElement AssertOnHomePage;

    @FindBy(xpath = "//*[contains(text(),'Contact')]")
     WebElement ContactLink;
    @FindBy(xpath="//*[contains(text(),'Start Shopping')]")
    WebElement StartShoppingBtn;
    public homePage(WebDriver d) {
        driver = d;
        PageFactory.initElements(d, this);
    }
    // FirstName
    public String VerifyOnHomePage(){

        String ActualText= AssertOnHomePage.getText();
        System.out.println("ActualText"+ActualText);
        return ActualText;
    }
    public void ClickOnContactlink(){

        ContactLink.click();
    }
    public void StartShoppingBtn(){
        StartShoppingBtn.click();
    }
}
