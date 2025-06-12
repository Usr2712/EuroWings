package pagesCode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CalendarCode {


    public static WebDriver driver;



    @FindBy(xpath = "//input[@id='from']")
    static WebElement FromDate;



    @FindBy(xpath = "//input[@id='to']")
    static WebElement ToDate;

    @FindBy(xpath = "//select[@class='ui-datepicker-month']")
    static WebElement SelectMonth;


    @FindBy(xpath = "//iframe[@class='demo-frame']")
    static WebElement frame;





    public  CalendarCode(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver,this);

    }

    public void SelectFromDate(String Month , String Date){

        driver.switchTo().frame(frame);
        FromDate.click();
        Select sel = new Select(SelectMonth);
        sel.selectByVisibleText(Month);

        WebElement expDate = driver.findElement(By.xpath("//td[@class=' ui-datepicker-week-end ']//a[text()='"+Date+"']"));
        expDate.click();




    }
}
