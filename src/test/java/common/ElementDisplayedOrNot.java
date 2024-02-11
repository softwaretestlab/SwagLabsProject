package common;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class ElementDisplayedOrNot {

    public static boolean isElementPresent(WebElement el){
        try{
            el.isDisplayed();
            return true;
        }
        catch(NoSuchElementException e){
            return false;
        }
    }
}
