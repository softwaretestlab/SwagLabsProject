package pages;

import BaseClass.openBrowser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class contactPage extends openBrowser {
    //submit button
    @FindBy(xpath="//*[contains(text(),'Submit')]")
    WebElement SubmitButton;
    //error messages
    @FindBy(xpath="//*[contains(text(),'We welcome your feedback')]")
    WebElement FeedbackMsg;
    @FindBy(xpath="//*[contains(text(),'Forename is required')]")
    WebElement ForenameErrMsg;
    @FindBy(xpath="//*[contains(text(),'Email is required')]")
    WebElement EmailErrMsg;
    @FindBy(xpath="//*[contains(text(),'Message is required')]")
    WebElement MsgErrMsg;
//enter data
    @FindBy(id="forename")
    WebElement forenameInputBox;
    @FindBy(id="email")
    WebElement emailinputBox;
    @FindBy(id="message")
    WebElement messageInputBox;
//response
    @FindBy(xpath = "//*[contains(text(),'Thanks John')]")
    WebElement ResponseMsg;
    public contactPage(WebDriver d) {
        driver = d;
        PageFactory.initElements(d, this);
    }
    //click submit button
    public void submitButtonClick(){
        SubmitButton.click();
    }
    public String FeedBackErrMsg(){
       String FeedBackMsg=FeedbackMsg.getText();
       return FeedBackMsg;
    }
    public WebElement FeedBackErrMsgGone(){
        WebElement FeedBackErrMsgGone= FeedbackMsg;
        return  FeedBackErrMsgGone;

    }
    public String ForenameErrMsg(){
        String ForenameMsg=ForenameErrMsg.getText();
        return ForenameMsg;
    }

    public WebElement ForenameErrMsgGone(){
        WebElement ForenameErrMsgGone= ForenameErrMsg;
        return  ForenameErrMsgGone;

    }
    public String EmailErrMsg(){
        String EmailMsg=EmailErrMsg.getText();
        return EmailMsg;
    }
    public WebElement EmailErrMsgGone(){
        WebElement EmailErrMsgGone= EmailErrMsg;
        return  EmailErrMsgGone;
    }
    public String MsgErrMsg(){
        String Msg=MsgErrMsg.getText();
        return Msg;
    }
    public WebElement MsgErrMsgGone(){
        WebElement MsgErrMsgGone= MsgErrMsg;
        return  MsgErrMsgGone;
    }

    //input boxes
    public void EnterForename(String forename){
        forenameInputBox.sendKeys(forename);
    }
    public void EnterEmail(String EnterEmail){
        emailinputBox.sendKeys(EnterEmail);
    }
    public void EnterMessage(String message){
        messageInputBox.sendKeys(message);
    }
//repsonse
public String ResponseMsg(){
    String ResMsg=ResponseMsg.getText();
    return ResMsg;
}

}

