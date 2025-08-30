package stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pagesCode.HyrPageCode;

public class HyrStepDefs {

    HyrPageCode hyrPageCode = new HyrPageCode(BrowserDriver.getWebDriver());


    @When("users clicks on new window button")
    public void usersClicksOnNewWindowButton() {


        hyrPageCode.ClickNewWinBtn();
        hyrPageCode.EnterDetails();

    }

    @And("User comes backs and clicks on new tab button")
    public void userComesBacksAndClicksOnNewTabButton() {

        hyrPageCode.clickonNewTabBtn();
    }
}
