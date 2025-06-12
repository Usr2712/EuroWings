package pagesCode;

import io.cucumber.java.eo.Se;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DropDownCode {


public static WebDriver driver;

    @FindBy(xpath = "//select[@title='Search in']")
    static WebElement CategoryDrpdown;

    public DropDownCode(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver,this);

    }


    public void SelectCategoryfromDropDown(){


        Select select = new Select(CategoryDrpdown);
        select.selectByVisibleText("Books");

    }

    public void SelectCategoryfromDropDownExamples(String catogories) throws InterruptedException {


        Select select = new Select(CategoryDrpdown);
        Thread.sleep(30);
        System.out.println(catogories);
        select.selectByVisibleText(catogories);

    }

    public void SelectCategoryfromMap(String catogories) throws InterruptedException {


        Select select = new Select(CategoryDrpdown);
        Thread.sleep(30);
        System.out.println(catogories);
        select.selectByVisibleText(catogories);

    }



}
