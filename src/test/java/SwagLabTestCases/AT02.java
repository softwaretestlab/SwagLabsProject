package SwagLabTestCases;

import common.AssertResponse;
import org.junit.Test;
import pages.contactPage;
import pages.homePage;
import java.io.IOException;
import java.time.Duration;
import static BaseClass.openBrowser.NavToWebsite;
import static BaseClass.openBrowser.driver;
import static org.junit.Assert.assertTrue;

public class AT02 {
    @Test
    public void at01() throws IOException, InterruptedException {
        int i=1;
        while(i<6) {
            //Navigate to homepage
            NavToWebsite("HomePageUrl");
            //homePage object creation
            homePage hPage = new homePage(driver);
            //Assert on homepage
            String ExpectedText1 = "Jupiter Toys";
            assertTrue(ExpectedText1.contains(hPage.VerifyOnHomePage()));
            //ClickOnContactlink
            hPage.ClickOnContactlink();
            //click on submit button
            contactPage cPage = new contactPage(driver);
            cPage.submitButtonClick();


            //  2.	Populate mandatory fields
            cPage.EnterForename("John");
            cPage.EnterEmail("john.smith@gmail.com");
            cPage.EnterMessage("Automation Testing");
            //3.	Click submit button
            cPage.submitButtonClick();
           driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//           driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            //  4.	Validate successful submission message
            String ExpectedText6 = "Thanks John";
            //assertTrue(ExpectedText6.contains(cPage.ResponseMsg()));
            AssertResponse.VerifyMsg(ExpectedText6, cPage.ResponseMsg());
            driver.quit();
            i++;
        }



        driver.quit();
    }

}
