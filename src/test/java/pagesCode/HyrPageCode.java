package pagesCode;

import com.beust.ah.A;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.decorators.WebDriverDecorator;

import java.util.Set;

public class HyrPageCode {

    public static WebDriver driver;

    @FindBy(xpath = "//button[@id='newWindowBtn']")
    static WebElement NewWinBtn;

    @FindBy(xpath = "//input[@id='firstName']")
    static WebElement FirstName;

    @FindBy(xpath = "//button[@Id='newTabBtn']")
    static WebElement NewtabBtn;

    @FindBy(xpath = "//button[@id='alertBox']")
    static WebElement AlertBtn;

    @FindBy(xpath = "//button[@id='confirmBox']")
    static WebElement ConfirmBtn;

    @FindBy(xpath = "//button[@id='promptBox']")
    static WebElement PromptBox;

    @FindBy(xpath = "//div[@id='output']")
    static WebElement VerMsg;





    Set<String> allWindowHandles ;


    public String mainWindowHandle;


    public HyrPageCode(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver,this);


    }

    public void ClickNewWinBtn(){

        mainWindowHandle = driver.getWindowHandle();
        NewWinBtn.click();


    }
    public void EnterDetails(){

        allWindowHandles  = driver.getWindowHandles();;

        for (String handle : allWindowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                driver.manage().window().maximize();
                break;
            }
        }

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollIntoView(true);", FirstName);
        FirstName.sendKeys("1227");

       // driver.switchTo().window(mainWindowHandle);
    }

    public void clickonNewTabBtn(){

       // driver.switchTo().window(mainWindowHandle);

       String mainWindowHan = driver.getWindowHandle();
        NewtabBtn.click();

       Set<String> allWindowHandless  = driver.getWindowHandles();;
        for (String handle : allWindowHandless) {
            if (!handle.equals(mainWindowHan)) {
                driver.switchTo().window(handle);
                //driver.manage().window().maximize();
                PromptBox.click();
                Alert alert = driver.switchTo().alert(); // Switch to the alert

               alert.accept();


                System.out.println(VerMsg.getText());
                break;
            }
        }




    }


}
