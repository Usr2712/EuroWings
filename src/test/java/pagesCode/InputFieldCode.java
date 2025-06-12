package pagesCode;

import io.cucumber.java.en_old.Ac;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.swing.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class InputFieldCode {

    List<String> values = new ArrayList<>();
    public static WebDriver driver;

    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    static WebElement SearchBar;

    @FindBy(xpath = "//span[@id='nav-search-submit-text']")
    static WebElement SearchIcon;

    @FindBy(xpath = "//span[text()='iphone 13']")
    static WebElement SearchRes;

    @FindBy(xpath = "//span[text()='iphone 13s back case']")
    static WebElement Product;





    public InputFieldCode(WebDriver driver) {

        this.driver=driver;
        PageFactory.initElements(driver,this);

    }

    public void SearchAnProduct() {


        SearchBar.sendKeys("IPhone");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> searchResults = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.xpath("//div[@class='left-pane-results-container']")));

        for (WebElement results : searchResults) {
            System.out.println(" - " + results.getText());

            values.add(results.getText());


        }
        System.out.println(values);

    }


    public void SearchForanProduct(String BrandName){

        SearchBar.sendKeys(BrandName);
        SearchIcon.click();

    }

    public void Validationofsearchresults(){

        String ActualRes = SearchRes.getText();
        Assert.assertEquals(ActualRes,"Iphone 13");

    }

    public void SelectProductFromSugeestion(String BrandName) {

        SearchBar.sendKeys("Iphone13");
        Actions actions = new Actions(driver);


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        List<WebElement> searchResults = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.xpath("//div[@class='left-pane-results-container']")));

        Boolean found = false;
        for (WebElement suggestion : searchResults) {

            String actualText = suggestion.getText().toLowerCase();

            if (actualText.contains(BrandName.toLowerCase())) {
                actions.moveToElement(suggestion).pause(Duration.ofMillis(500)).click().build().perform();
                break;
            }
            else{

                found=true;
            }
            if(found=true){

                System.out.println("Product not there in search results");

            }
        }


    }
}
