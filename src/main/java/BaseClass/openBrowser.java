package BaseClass;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import PropertiesFile.ReadPropertiesFile;
import io.github.bonigarcia.wdm.WebDriverManager;

public class openBrowser {

    public static WebDriver driver;

    public static void NavToWebsite(String url) throws IOException {

        //Chromedriver setup
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        //this below line will open chrome browser
        driver = new ChromeDriver(options);
        //maximize browser
        driver.manage().window().maximize();
        //Navigate to website
        driver.get(url);
        //maxium Wait for 30 sec
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    public static void CloseBrowser() {
        driver.close();
        driver.quit();
    }

}