package stepDefs;

import Utilities.PropertyReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserDriver {



    static WebDriver driver;

    @Before(order =2)
    public static void Webdriverinit(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        //driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
        driver.get(PropertyReader.getProp("HYRTutorial"));

        driver.manage().window().maximize();


    }

    public static WebDriver getWebDriver() {
        if (driver == null) {
            BrowserDriver.Webdriverinit();  // Create instance only if not already created
        }
        return driver;
    }


    public static void Quitdriver(){
        BrowserDriver.getWebDriver().quit();
    }




}
