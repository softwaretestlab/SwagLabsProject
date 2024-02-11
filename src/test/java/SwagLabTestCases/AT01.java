package SwagLabTestCases;

import org.junit.Test;
import pages.contactPage;
import pages.homePage;


import java.io.IOException;
import static BaseClass.openBrowser.NavToWebsite;
import static BaseClass.openBrowser.driver;
import static org.junit.Assert.assertTrue;


public class AT01 {
    @Test
    public void at01() throws IOException, InterruptedException {
        //Navigate to homepage
        NavToWebsite("HomePageUrl");
        //homePage object creation
        homePage hPage = new homePage(driver);
        //Assert on homepage
         String ExpectedText1="Jupiter Toys";
         assertTrue(ExpectedText1.contains(hPage.VerifyOnHomePage()));
        //ClickOnContactlink
        hPage.ClickOnContactlink();
        //click on submit button
        contactPage cPage= new contactPage(driver);
        cPage.submitButtonClick();

        //3.	Verify error messages
        String ExpectedText2="We welcome your feedback";
        assertTrue(ExpectedText2.contains(cPage.FeedBackErrMsg()));
       // System.out.println(cPage.FeedBackErrMsg());
        String ExpectedText3="Forename is required";
        assertTrue(ExpectedText3.contains(cPage.ForenameErrMsg()));
      //  System.out.println(cPage.ForenameErrMsg());
        String ExpectedText4="Email is required";
        assertTrue(ExpectedText4.contains(cPage.EmailErrMsg()));
       // System.out.println(cPage.EmailErrMsg());
        String ExpectedText5="Message is required";
        assertTrue(ExpectedText5.contains(cPage.MsgErrMsg()));
       // System.out.println(cPage.MsgErrMsg());

      //  4.	Populate mandatory fields
        cPage.EnterForename("John");
        cPage.EnterEmail("john.smith@gmail.com");
        cPage.EnterMessage("Automation Testing");

        // check all 3 mandatory messages disappeared
//        if(ElementDisplayedOrNot.isElementPresent(cPage.FeedBackErrMsgGone())==false);
//        if(ElementDisplayedOrNot.isElementPresent(cPage.ForenameErrMsgGone())==false);
//        if(ElementDisplayedOrNot.isElementPresent(cPage.EmailErrMsgGone())==false);
//        if(ElementDisplayedOrNot.isElementPresent(cPage.MsgErrMsgGone())==false);

        driver.quit();

    }





}
