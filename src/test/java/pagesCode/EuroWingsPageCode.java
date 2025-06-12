package pagesCode;

import Utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.management.relation.RelationSupport;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class EuroWingsPageCode {

    List<WebElement> enabledDates = new ArrayList<>();
    public static WebDriver driver;

    @FindBy(xpath = "//span[text()='Departure airport']")
    static WebElement Dep_airport;

    @FindBy(xpath = "//span[text()='Destination airport']")
    static WebElement Des_airport;


    @FindBy(xpath = "(//label[text()='Departure airport'])//parent::div//input")
    static WebElement DepAirportSearchBar;

    @FindBy(xpath = "(//label[text()='Destination airport'])//parent::div//input")
    static WebElement DesAirportSearchBar;


    @FindBy(xpath = "(//span[contains(text(),'London Heathrow')])[2]")
    static WebElement SelectDesAir;

    @FindBy(xpath = "//button[text()='Accept All']")
    static WebElement Cookies;


    @FindBy(xpath = "(//span[contains(text(),'Outgoing flight')])")
    static WebElement DateofFlightbtn;

    @FindBy(xpath = "(//span[contains(text(),'Return flight')])")
    static WebElement DateofreturnFlightbtn;


    @FindBy(xpath = "//span[text()='Search for flight']")
    static WebElement SearchForFlights;


    public EuroWingsPageCode(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);


    }

    public void AcceptCookies() {

        Cookies.click();
    }

    public void SelectingDepatureAirport(String DepAirport) throws InterruptedException {

        AcceptCookies();

        Dep_airport.click();
        DepAirportSearchBar.sendKeys(DepAirport);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement sug = driver.findElement(By.xpath("(//span[contains(text(),'" + DepAirport + "')])[3]"));

        WebElement suggestion = wait.until(ExpectedConditions.visibilityOf(sug));

        // Hover and click using Actions
        Actions act = new Actions(driver);
        act.moveToElement(suggestion).click().build().perform();
        Thread.sleep(2000);

    }

    public void SelectingDestinationAirport(String DesAirport) throws InterruptedException {


        Des_airport.click();
        DesAirportSearchBar.sendKeys(DesAirport);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        WebElement sug = driver.findElement(By.xpath("(//span[contains(text(),'" + DesAirport + "')])[3]"));

        WebElement suggestion = wait.until(ExpectedConditions.visibilityOf(sug));


        // Hover and click using Actions
        Actions act = new Actions(driver);
        act.moveToElement(suggestion).click().build().perform();

        Thread.sleep(2000);
    }

    public void SelectDateforgoing(String yr, String mn, String dt) throws InterruptedException {

        DateofFlightbtn.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        String fullmonth = ReusableMethods.FormatMonthToFullForm(mn);

        WebElement OutgoingFlight = driver.findElement(By.xpath("(//button[@class='a-cta a-cta--inline']//span)[3]"));
//span[text()='"+fullmonth+" "+yr+"']//parent::span//span[@class='a-cta__icon']

        //span[text()='"+mn+" "+yr+"']//parent::span//span[@class='a-cta__icon']
        wait.until(ExpectedConditions.visibilityOf(OutgoingFlight)).click();

        driver.findElement(By.xpath("//button[text()='" + mn + " " + yr + "']")).click();

        JavascriptExecutor js = (JavascriptExecutor) driver;


        DateTimeFormatter parser = DateTimeFormatter.ofPattern("MMM", Locale.ENGLISH);
        TemporalAccessor parsed = parser.parse(mn);

        Month month = Month.from(parsed);


        String fullMonth = month.getDisplayName(TextStyle.FULL, Locale.ENGLISH); // Already like "October"

        WebElement dateElement = driver.findElement(By.xpath("//input[starts-with(@aria-label, '" + dt + ". " + fullMonth + "')]"));


        if (dateElement.getAttribute("disabled") == null) {
            dateElement.click();

        } else {
            // find another enabled date
            enabledDates = driver.findElements(By.xpath("//input[@type='radio' and not(@disabled)]"));
            if (!enabledDates.isEmpty()) {
                enabledDates.get(0).click(); // fallback date
            }


            Thread.sleep(2000);
        }


    }




    public void SelectDateforReturn(String yr, String mn, String dt) throws InterruptedException {

        DateofreturnFlightbtn.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        WebElement ReturnFlight = driver.findElement(By.xpath("(//button[@class='a-cta a-cta--inline']//span)[3]"));

        wait.until(ExpectedConditions.visibilityOf(ReturnFlight)).click();

        driver.findElement(By.xpath("//button[text()='" + mn + " " + yr + "']")).click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        String fullMonth = ReusableMethods.FormatMonthToFullForm(mn);


        WebElement dateElement = driver.findElement(By.xpath("//input[@type='radio' and @aria-label='" + dt + ". " + fullMonth + " " + yr + "']"));


        js.executeScript("arguments[0].scrollIntoView(true);", dateElement);

        if (dateElement.getAttribute("disabled") == null) {
            dateElement.click();

        } else {
            // find another enabled date
             enabledDates = driver.findElements(By.xpath("//input[@type='radio' and not(@disabled)]"));
            if (!enabledDates.isEmpty()) {
                enabledDates.get(0).click(); // fallback date
            }


            Thread.sleep(2000);
        }
    }

  /*  public void SelectingPassengers(int countofpassengers){

        Passengers.click();


        for(int i = 1;i<countofpassengers;i++){

            driver.findElement(By.xpath("//button[@aria-label='Add adults to booking']")).click();
        }*/


    public void ClickOnSearchFlights() throws InterruptedException {


        SearchForFlights.click();
        Thread.sleep(2000);

    }
}


