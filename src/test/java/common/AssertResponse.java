package common;

import BaseClass.openBrowser;
import org.junit.Assert;
import org.openqa.selenium.By;

import static org.junit.Assert.assertTrue;

public class AssertResponse {
    public static void VerifyMsg(String ExpectedText,String ActualResponse){

        assertTrue(ExpectedText.contains(ActualResponse));
    }
    public static void VerifyMsg(double ExpectedResponse,double ActualResponse){

        Assert.assertEquals(ExpectedResponse,ActualResponse,0);
    }



}
